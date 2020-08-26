<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.util.*, java.io.IOException, java.io.PrintWriter, javax.servlet.*, com.abhinav.Tree.BinarySearchTree,javafx.util.Pair" %>
    
<%@ include file="upper-navbar.jsp" %>
<%@ include file="lower-navbar.jsp" %>

<!DOCTYPE html>
<html style="width:100%;height:100%;">
<head>
<meta charset="ISO-8859-1">
<title>BST From Node Insertion</title>
<script src="rearrange.js"></script>
<style>
	.Node
	{	
		  height: 40px;
		  width: 40px;
		  background-color: #bbb;
		  border-radius: 50%;
		  background-color: rgb(143, 188, 143);
		  display: inline-block;
		  text-align: center;
		  line-height: 40px;	
	}
	.array
	{
		padding-left: 24px;
		padding-top: 20px;
	}
</style>

<script>
	window.onload = function(){
	  document.getElementById('rearrange').click();
	}
</script>


</head>
<body style="width:100%;height:100%;">
<form method="post" action="nodeInsertionBSTController" class="array">
Enter node to be inserted (Integer only): <input type="text" name="nodeElement">
<input type="submit" name="submit"><input type="submit" name="reset" value="Reset">
</form>

<svg id="svgid" height="100%" width="100%"></svg>

	<%
		//Prevent caching in client browser
		//response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		
		int maxID=-1;
		if(request.getAttribute("tree")!=null)
		{
			BinarySearchTree tree= (BinarySearchTree) request.getAttribute("tree");
			tree.setValues(tree.root);
			Map<Integer, Integer> ids_Data= tree.ids_Data;
			
			Set<Integer> idSet= ids_Data.keySet();
			Iterator<Integer> it= idSet.iterator();
			
			
			while(it.hasNext())
			{
				int id= it.next();
				int data= ids_Data.get(id);
				
				out.println("<div class='Node' id='"+id+"'> "+ data +" </div>");
				if(id>maxID) maxID=id;
			}
			
			Map<Integer, Pair<Integer, Character>> childs= tree.childs;
			Set<Integer> idSet2= childs.keySet();
			Iterator<Integer> it2= idSet2.iterator();
			
			out.println("<p id='child-data' hidden>");
			while(it2.hasNext())
			{
				int childID= it2.next();
				int parent= childs.get(childID).getKey();
				char type= childs.get(childID).getValue();
				
				out.print(childID+" "+parent+" "+type+",");
				//out.println("<br>");
			}
			out.println("</p>");
			
			Vector<Integer> v= tree.levelNodes;
			out.println("<p id='levelNodes' hidden>");
			for(int i=0; i<v.size(); i++)
			{
				out.print(v.get(i)+",");
			}
			out.println("</p>");
			
			Map<Integer, Pair<Integer,Integer>> parents= tree.parents;
			Set<Integer> idSet3= parents.keySet();
			Iterator<Integer> it3= idSet3.iterator();
			out.println("<p id='parent-data' hidden>");
			while(it3.hasNext())
			{
				int parentID= it3.next();
				int lChild= parents.get(parentID).getKey();
				int rChild= parents.get(parentID).getValue();
				
				out.print(parentID+" "+lChild+" "+rChild+",");
			
			}
			out.println("</p>");
			
			out.println("<p id='height' hidden>");
			out.println(tree.height);
			out.println("</p>");
			
			request.removeAttribute("tree");
		}
	%> 
<button type="button" onclick="rearrangeNodes(<%out.print(maxID);%>)" id="rearrange" hidden>Rearrange</button>


</body>
</html>

