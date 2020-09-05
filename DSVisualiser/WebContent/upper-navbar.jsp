<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>

.uppernav {
  overflow: hidden;
  background-color: white;
}

.uppernav a {
  float: left;
  display: block;
  color: #black;
  text-align: center;
  padding: 20px 16px;
  text-decoration: none;
  font-size: 24px;
}


@media screen and (max-width: 600px) {
  .uppernav a:not(:first-child) {display: none;}
  .uppernav a.icon {
    float: right;
    display: block;
  }
}

@media screen and (max-width: 600px) {
  .uppernav.responsive {position: relative;}
  .uppernav.responsive .icon {
    position: absolute;
    right: 0;
    upper: 0;
  }
  .uppernav.responsive a {
    float: none;
    display: block;
    text-align: left;
  }
}
</style>

<script>
function myFunction() {
  var x = document.getElementById("myuppernav");
  if (x.className === "uppernav") {
    x.className += " responsive";
  } else {
    x.className = "uppernav";
  }
}
</script>

</head>
<body>

<div class="uppernav" id="myuppernav">
  <a>Welcome to DS-Visualiser</a>
</div>





</body>
</html>

    