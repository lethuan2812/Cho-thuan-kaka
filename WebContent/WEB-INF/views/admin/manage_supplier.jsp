<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/inclue/taglib.jsp"%>


<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">
<title>Supplier</title>

</head>
<body>
	<p>This is page Manage Supplier</p>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">SupplierID</th>
				<th scope="col">SupplierName</th>
				<th scope="col">Address</th>
				<th scope="col">Email</th>
				<th scope="col">Phone</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="ncc" items="${Supplier}">
				<tr>
					<td>${ncc.supplierID}</td>
					<td>${ncc.supplierName}</td>
					<td>${ncc.address}</td>
					<td>${ncc.email}</td>
					<td>${ncc.phone}</td>
			<%-- 		<td><a class="btn btn-success"
						href="homeAdmin/employe/update_customer/${kh.customerID}.php">Sửa</a></td>
					<td><a class="btn btn-success"
						href="homeAdmin/employe/deletekh/${kh.customerID}.php">Xóa</a></td> --%>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>