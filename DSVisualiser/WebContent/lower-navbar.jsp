<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.lowernav {
  overflow: hidden;
  background-color: #333;
}

.lowernav a {
  float: left;
  display: block;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.lowernav a:hover {
  background-color: #ddd;
  color: black;
}

.lowernav a.active {
  background-color: #4CAF50;
  color: white;
}

.lowernav .icon {
  display: none;
}

@media screen and (max-width: 600px) {
  .lowernav a:not(:first-child) {display: none;}
  .lowernav a.icon {
    float: right;
    display: block;
  }
}

@media screen and (max-width: 600px) {
  .lowernav.responsive {position: relative;}
  .lowernav.responsive .icon {
    position: absolute;
    right: 0;
    lower: 0;
  }
  .lowernav.responsive a {
    float: none;
    display: block;
    text-align: left;
  }
}


.dropdown {
  float: left;
  overflow: hidden;
}

.dropdown .dropbtn {
  font-size: 16px;  
  border: none;
  outline: none;
  color: white;
  padding: 18px 16px;
  background-color: inherit;
  font-family: inherit;
  margin: 0;
}

.navbar a:hover, .dropdown:hover .dropbtn {
  background-color: #ddd;
  color: black;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  float: none;
  color: black;
  padding: 18px 16px;
  text-decoration: none;
  display: block;
  text-align: left;
}

.dropdown-content a:hover {
  background-color: #ddd;
}

.dropdown:hover .dropdown-content {
  display: block;
}
</style>

<script>
function myFunction() {
  var x = document.getElementById("mylowernav");
  if (x.className === "lowernav") {
    x.className += " responsive";
  } else {
    x.className = "lowernav";
  }
}
</script>

</head>
<body>

<div class="lowernav" id="mylowernav">

  <div class="dropdown">
    <button class="dropbtn">Binary Tree 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="completeLevelOrderBinaryTree.jsp">From Level Order Array (Complete Binary Tree)</a>
      <a href="anyLevelOrderBinaryTree.jsp">From Level Order Array (Any Binary Tree)</a>
      <a href="inorderPreorderBinaryTree.jsp">From Inorder, Preorder Array (Any Binary Tree)</a>
      <a href="inorderPostorderBinaryTree.jsp">From Inorder, Postorder Array (Any Binary Tree)</a>
    </div>
  </div> 
  
  <div class="dropdown">
    <button class="dropbtn">Binary Search Tree 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="preorderBST.jsp">From Preorder Array</a>
      <a href="postorderBST.jsp">From Postorder Array</a>
      <a href="nodeInsertionBST.jsp">Node Insertion</a>
    </div>
  </div> 
  
  <div class="dropdown">
    <button class="dropbtn">Graph
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="undirectedGraphAdjMatrix.jsp">From Adjacency Matrix (Undirected Graph)</a>
      <a href="#">From Adjacency Matrix (Directed Graph)</a>
    </div>
  </div> 

</div>





</body>
</html>

