<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>
<!DOCTYPE html>

<html>

<head>
<meta charset="UTF-8">
<title>Insert_customer</title>


</head>
<body>
	<div class="container"
		style="padding-top: 10px; width: 400px; height: 800px; border: 2px solid blue; border-radius: 10px">
		<h2 style="text-align: center;">Insert Manufacturer</h2>
		${message}

		<form:form action="insert_manufacturer.php" modelAttribute="Manufacturer">

			<div class="form-group">
				<label>Manufacturer Name</label>
				<form:input path="manufacturerName" class="form-control" />
			</div>

			<div class="form-group">
				<label>Description</label>
				<form:input path="description" class="form-control" />
			</div>

			
			<div>
				<button type="submit" class="btn btn-success">Đăng Ký</button>
			</div>
		</form:form>

	</div>
</body>
</html>