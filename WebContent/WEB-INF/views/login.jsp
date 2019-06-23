<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<head>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style1.css">
	<meta charset="UTF-8">
	<title>Bienvenido</title>
</head>

<body>

<div class="login-page">
  
  <div class="form">
    
    <img src="${pageContext.request.contextPath}/resources/title.png">
    
    <form class="login-form" action="${pageContext.request.contextPath}/verify" method="post">
      <input type="text" name="username" placeholder="Nombre de usuario"/>
      <input type="password" name="password" placeholder="Contraseña"/>
      <button type="submit" onclick="location.href='${pageContext.request.contextPath}/'">Iniciar sesión</button>
    </form>
  
  
  <br>
  <font color="blue">${error}</font>
  
  </div>
  
  
    <img src="${pageContext.request.contextPath}/resources/chef.png" width="300px" height="300px">
    
  
</div>



</body>
</html>