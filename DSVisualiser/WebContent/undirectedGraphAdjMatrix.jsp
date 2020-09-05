<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.util.*, java.io.IOException, java.io.PrintWriter, javax.servlet.*, com.abhinav.Tree.BinarySearchTree,javafx.util.Pair" %>
<%@ include file="upper-navbar.jsp" %>
<%@ include file="lower-navbar.jsp" %>
    

<!DOCTYPE HTML>
<html>
<head>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.js" type="text/javascript"></script>
	<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.js" type="text/javascript"></script>
	<script src="jQueryRotateCompressed.2.2.js" type="text/javascript"></script>
	<script src="simulate.js"></script>
	<script src="generateUndirectedGraphAdjMatrix.js"></script>
	<style>
		.box{
			height: 50px;
			width: 50px;
			background-color: #bbb;
			border-radius: 50%;
			background-color: rgb(143, 188, 143);
			display: inline-block;
			text-align: center;
			line-height: 50px;
			position: absolute;
			
		}
	
		.lineclass{
			width: 1px;
			height: 1px;
			border: solid thin black;
			position: absolute;
			background-color: black;
			-webkit-border-radius: 10px;
			-moz-border-radius: 10px;
			border-radius: 10px;
			z-index: -1;
		}


		.arc {
			border: 3px solid #000;
			border-radius: 50%;
			height: 60px;
			width: 60px;
			
			transform: rotate(180deg);
			position: absolute;
			top: -37px;
			left: -12.5px;
			z-index: -1;
		}
		
		body {
	
			height: 2000px;
			background-color: #FFF;
		}
		
		.adjMatrix
		{
			position: absolute;
			top: 150px;
			left:20px;
		}
		
		textarea
		{
			z-index:-199;
		}
		
		.nodes
		{
			position: absolute;
			top:400px;
			left:15px;
			border: 2px solid #000;
			height: 2000px;
			width: 98%;
		
		}
		
	</style>


	<script>
		
			$("body").on("mousedown", function(e) { 
				
				var div = $("<div>").draggable().appendTo("body");
				e.type = "mousedown.draggable";
				e.target = div[0];
				div.trigger(e);
				
			});
		
	</script>
	
	<title>Undirected Graph</title>
</head>
<body>
	
	
	<div class="adjMatrix">

	<textarea id="matrix" name="matrix" rows="10" cols="40">
0,1,1,0,1,1
1,0,1,0,0,0
1,1,0,1,1,0
0,0,1,0,1,0
1,0,1,1,0,0
1,0,0,0,1,0
	</textarea> <br>
	<input id="gen" type="button" value="Generate Graph" onclick="parseMatrix()">

	</div> 

	<p id="lines"></p>

	<div class="nodes" id="nodes">
	
	</div>
</body>
</html>