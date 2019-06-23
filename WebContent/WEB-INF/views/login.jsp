<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<head>
	<link rel="stylesheet" href="resources/style.css">
	<meta charset="UTF-8">
	<title>Bienvenido</title>
</head>

<body>

<div class="login-page">
  <div class="form">
    <form class="login-form" action="${pageContext.request.contextPath}/verify" method="post">
      <input type="text" name="username" placeholder="Nombre de usuario"/>
      <input type="password" name="password" placeholder="Contraseña"/>
      <button type="submit" onclick="location.href='${pageContext.request.contextPath}/'">Iniciar sesión</button>
    </form>
  </div>
</div>

<h1 name="errorMessage"></h1>

</body>
</html>