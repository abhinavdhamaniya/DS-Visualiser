<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    


<html lang="en">
<head>
  <title>Navbar</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link href="https://fonts.googleapis.com/css?family=Raleway:400,500,500i,700,800i" rel="stylesheet">
  <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
  <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script> 
  <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	<script type="text/javascript">
	$(document).ready(function () {
	$('.navbar-light .dmenu').hover(function () {
	        $(this).find('.sm-menu').first().stop(true, true).slideDown(150);
	    }, function () {
	        $(this).find('.sm-menu').first().stop(true, true).slideUp(105)
	    });
	});
	</script>
  
  	<style>
  	
	  	.social-part .fa
	  	{
	    	padding-right:20px;
		}
		ul li a
		{
		    margin-right: 20px;
		}
	
	  	
  	</style>
  
</head>
  <body>

    <nav class="navbar navbar-expand-sm navbar-dark bg-dark">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
          <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            
	          <li class="nav-item dropdown dmenu">
	          <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
	            Binary Tree
	          </a>
	          <div class="dropdown-menu sm-menu">
	            <a class="dropdown-item" href="completeLevelOrderBinaryTree.jsp">From Level Order Array (Complete Binary Tree)</a>
	            <a class="dropdown-item" href="anyLevelOrderBinaryTree.jsp">From Level Order Array (Any Binary Tree)</a>
	            <a class="dropdown-item" href="inorderPreorderBinaryTree.jsp">From Inorder, Preorder Array (Any Binary Tree)</a>
	            <a class="dropdown-item" href="inorderPostorderBinaryTree.jsp">From Inorder, Postorder Array (Any Binary Tree)</a>
	          </div>
	          </li> 
	          
	          <li class="nav-item dropdown dmenu">
	          <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
	            Binary Search Tree
	          </a>
	          <div class="dropdown-menu sm-menu">
	            <a class="dropdown-item" href="preorderBST.jsp">From Preorder Array</a>
	            <a class="dropdown-item" href="postorderBST.jsp">From Postorder Array</a>
	            <a class="dropdown-item" href="nodeInsertionBST.jsp">Node Insertion</a>
	          </div>
	          </li> 
	          
	          <li class="nav-item dropdown dmenu">
	          <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
	            Graph
	          </a>
	          <div class="dropdown-menu sm-menu">
	            <a class="dropdown-item" href="undirectedGraphAdjMatrix.jsp">From Adjacency Matrix (Undirected Graph)</a>
	            <a class="dropdown-item" href="#">From Adjacency Matrix (Directed Graph)</a>
	          </div>
	          </li> 
          
          </ul>
          
          <div class="social-part">
            <i class="fa fa-facebook" aria-hidden="true"></i>
            <i class="fa fa-twitter" aria-hidden="true"></i>
            <i class="fa fa-instagram" aria-hidden="true"></i>
          </div>
          
        </div>
      </nav>
</body>
</html>
