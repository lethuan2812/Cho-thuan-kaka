<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/inclue/taglib.jsp"%>


<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">
<title>Trang chủ</title>

</head>
<body>
	<p>This is page Manage Employe</p>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">Name</th>
				<th scope="col">ID</th>
				<th scope="col">password</th>
				<th scope="col">companyName</th>
				<th scope="col">address</th>
				<th scope="col">phone</th>
				<th scope="col">email</th>
				<th scope="col">description</th>
				<th scope="col">Status</th>
				<th scope="col">Chi Tiết</th>
				<th scope="col">Xóa</th>
				<th scope="col"></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="kh" items="${Customer}">
				<tr>
					<td>${kh.customerName}</td>
					<td>${kh.cUserID}</td>
					<td>${kh.password}</td>
					<td>${kh.companyName}</td>
					<td>${kh.address}</td>
					<td>${kh.phone}</td>
					<td>${kh.email}</td>
					<td>${kh.description}</td>
					<td>${kh.status}</td>

					<td><a class="btn btn-success"
						href="homeAdmin/employe/update_customer/${kh.customerID}.php">Sửa</a></td>
					<td><a class="btn btn-success"
						href="homeAdmin/employe/deletekh/${kh.customerID}.php">Xóa</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>