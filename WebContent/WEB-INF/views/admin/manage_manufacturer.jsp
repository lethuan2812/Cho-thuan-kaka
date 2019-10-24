<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/inclue/taglib.jsp"%>


<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">
<title>Manufacturer</title>

</head>
<body>
	<p>This is page Manage Manufacturer</p>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">ManufacturerID</th>
				<th scope="col">ManufacturerName</th>
				<th scope="col">Description</th>
				<th scope="col"></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="nsx" items="${Manufacturer}">
				<tr>
					<td>${nsx.manufacturerID}</td>
					<td>${nsx.manufacturerName}</td>
					<td>${nsx.description}</td>
					<td><a class="btn btn-success"
						href="homeAdmin/manufacturer/update_manufacturer/${nsx.manufacturerID}.php">Update</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>