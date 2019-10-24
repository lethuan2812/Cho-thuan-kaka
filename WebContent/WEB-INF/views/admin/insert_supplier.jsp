<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>
<!DOCTYPE html>

<html>

<head>
<meta charset="UTF-8">
<title>SUPPLIER</title>


</head>
<body>
	<div class="container"
		style="padding-top: 10px; width: 400px; height: 800px; border: 2px solid blue; border-radius: 10px">
		<h2 style="text-align: center;">Insert Supplier</h2>
		${message}

		<form:form action="insert_supplier.php" modelAttribute="Supplier">

			<div class="form-group">
				<label>SupplierName</label>
				<form:input path="supplierName" class="form-control" />
			</div>
			
			<div class="form-group">
				<label>Address</label>
				<form:input path="address" class="form-control" />
			</div>

			<div class="form-group">
				<label>Email</label>
				<form:input path="email" class="form-control" />
			</div>
			
			<div class="form-group">
				<label>Phone</label>
				<form:input path="phone" class="form-control" />
			</div>



			<div>
				<button type="submit" class="btn btn-success">Đăng Ký</button>
			</div>
		</form:form>

	</div>
</body>
</html>