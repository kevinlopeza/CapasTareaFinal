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
</head>
<body>
    <table>
    	<thead>
    		<tr>
    			<th>Código</th>
    			<th>Nombre</th>
    			<th>Ubicación</th>
    			<th>Cantidad de mesas</th>
    			<th>Gerente</th>
    			<th>Horarios</th>
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
                </tr>
    		</c:forEach>
    	</tbody>
    </table>
</body>
</html>