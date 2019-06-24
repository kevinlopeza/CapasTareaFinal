<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Credenciales válidas</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style2.css">
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

<div class="jumbotron jumbotron-fluid">
  <div class="container">
    
    <div class="row">
    <div class="col-sm">
      <img src="${pageContext.request.contextPath}/resources/sucursales.png">
      
      <img height="40px" width="700px" src="${pageContext.request.contextPath}/resources/line1.png">
      
      <img height="40px" width="700px" src="${pageContext.request.contextPath}/resources/linea2.png">
      
      <img height="40px" width="700px" src="${pageContext.request.contextPath}/resources/linea3.png">
      
    </div>
    <div class="col-sm">
      <img width="200px" height="200px" src="${pageContext.request.contextPath}/resources/pizza.png">
    </div>

  	</div>
	
      <button type="button" class="btn btn-info" onclick="window.location.href='${pageContext.request.contextPath}/add'"><i class="fa fa-plus"></i>Añadir sucursal</button>
    
    <div class="container">
</div>

  </div>
</div>

<div class="divprincipal" align ="center">
			<c:if test = "${not empty message}">
				<div class="alert">
  				<span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span> 
  				<strong> ${message} </strong> 
			</div>
			</c:if>
		
		    <table class = "table">
	    	<thead class ="thread-light">
	    		<tr>
	    			<th>Código</th>
	    			<th>Nombre</th>
	    			<th>Ubicación</th>
	    			<th>Cantidad de mesas</th>
	    			<th>Gerente</th>
	    			<th>Horarios</th>
	    			<th>Opciones</th>
	    		</tr>
	    	</thead>
	    	<tbody>
	    		<c:forEach items="${storeList}" var="store">
	                <tr>
	                <td>${store.code}</td>
	                <td>${store.name}</td>
	                <td>${store.address}</td>
	                <td>${store.numTables}</td>
	                <td>${store.manager}</td>
	                <td>${store.schedule}</td>
	                <td>
	                	<button class="btn btn-primary" onclick="window.location.href='${pageContext.request.contextPath}/store/${store.code}'"><i class="fa fa-binoculars"></i>Ver</button>
						<button class="btn btn-secondary" onclick="window.location.href='${pageContext.request.contextPath}/store/edit/${store.code}'"><i class="fa fa-edit"></i>Editar</button>
						<button class="btn btn-success" onclick="window.location.href='${pageContext.request.contextPath}/store/delete/${store.code}'"><i class="fa fa-trash"></i>Eliminar</button>
	                </td>
	                </tr>
	    		</c:forEach>
	    	</tbody>
	    </table>
</div>
</body>
</html>