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
			<h2>Update_Manufacturer</h2>
			<form:form
				action="${pageContext.request.contextPath}/homeAdmin/manufacturer/update_manufacturer.php"
				modelAttribute="manufacturer" method="POST">


				<div class="form-group">
					<label>ManufacturerID:</label>
					<form:input type="text" path="manufacturerID" class="form-control" />
				</div>
				
				<div class="form-group">
					<label>ManufacturerName:</label>
					<form:input type="text" path="manufacturerName" class="form-control" />
				</div>

				<div class="form-group">
					<label>Description:</label>
					<form:input path="description" class="form-control" readonly="" />
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