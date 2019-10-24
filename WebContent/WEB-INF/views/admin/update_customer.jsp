<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>

	<div>
		<div class="container">
			${message }
			<h2>Update_Customer</h2>
			<form:form
				action="${pageContext.request.contextPath}/homeAdmin/employe/update_customer.php"
				modelAttribute="customer" method="POST">


				<div class="form-group">
					<label>CustomerID:</label>
					<form:input type="text" path="CustomerID" class="form-control" />
				</div>
				
				<div class="form-group">
					<label>CustomerName:</label>
					<form:input type="text" path="customerName" class="form-control" />
				</div>

				<div class="form-group">
					<label>UserID:</label>
					<form:input path="cUserID" class="form-control" readonly="" />
				</div>

				<div class="form-group">
					<label>Password:</label>
					<form:input path="password" class="form-control" />
				</div>

				<div class="form-group">
					<label>companyName:</label>
					<form:input path="companyName" class="form-control" />
				</div>

				<div class="form-group">
					<label>Address:</label>
					<form:input path="address" class="form-control" />
				</div>

				<div class="form-group">
					<label>Phone:</label>
					<form:input path="phone" class="form-control" />
				</div>

				<div class="form-group">
					<label>Email:</label>
					<form:input path="email" class="form-control" />
				</div>

				<div class="form-group">
					<label>Discription:</label>
					<form:input path="description" class="form-control" />
				</div>

				<div>
					<label>Status</label> <br />
					<form:select path="Status" class="form-control">
						<form:option value="0" label="not exist" />
						<form:option value="1" label="exist" />
					</form:select>
				</div>

				<div>
					<button class="btn btn-success">Update</button>
				</div>
			</form:form>
			<br />
			<div>
				<button onclick="window.location.href='admin/quanlynv.htm'"
					class="btn btn-success">Back</button>
			</div>
		</div>
	</div>


</body>
</html>