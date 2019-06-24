<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style1.css">
	<meta charset="UTF-8">
	<title>Añadir sucursal</title>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

		
		<c:if test = "${not empty message}">
				<div class="alert">
  				<span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span> 
  				<strong> ${message} </strong> 
			</div>
		</c:if>

		<div class="form mt-4" >
			<h2> ${action} sucursal </h2>
			<form:form action="${pageContext.request.contextPath}/save" method="POST" modelAttribute="store" autocomplete="off">
				<form:input type="hidden" name="code" path="code"/>
				<div class="input-field">
				    <label for="name">Nombre</label>
				    <form:input id="name" type="text" name="name" path="name"/>
				    <form:errors path="name" cssStyle="color:red;"/>
				</div>	
				<div class="input-field col s12">
				    <label for="address">Dirección</label>
				    <form:input id="address" type="text" name="address" path="address"/>
				    <form:errors path="address" cssStyle="color:red;"/>
				</div>
				<div class="input-field col s12">
				    <label for="sch">Horarios</label>
				    <form:input id="sch" type="text" name="schedule" path="schedule"/>
				    <form:errors path="schedule" cssStyle="color:red;"/>
				</div>
				<div class="input-field col s12">
				    <label for="nmesas">Número de mesas</label>
				    <form:input id="nmesas" type="number" name="numtables" path="numTables"/>
				    <form:errors path="numTables" cssStyle="color:red;"/>
				</div>
				<div class="input-field col s12">
				    <label for="gerente">Nombre del gerente</label>
				    <form:input id="gerente" type="text" name="manager" path="manager"/>
				    <form:errors path="manager" cssStyle="color:red;"/>
				</div>
				<button type="submit"><i class="fa fa-save"></i>     Guardar</button>
				<br>
				<br>
			</form:form>
			<form action="${pageContext.request.contextPath}/sucursales" method="post">
					<button type="submit" ><i class="fa fa-arrow-left"></i>    Regresar</button>
				</form>
		</div>
	
</body>
</html>