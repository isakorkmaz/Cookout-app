<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/loginCommon/header.jsp" />

<script type="text/javascript">
	$(document).ready(function () {
	
		$("form").validate({
			
			rules : {
				userName : {
					required : true
				},
				password : {
					required : true
				}
			},
			messages : {			
				confirmPassword : {
					equalTo : "Passwords do not match"
				}
			},
			errorClass : "error"
		});
	});
</script>

<div class="row">
	<div class="col-sm-2"></div>
	<div class="col-sm-8">
		<c:url var="formAction" value="/login" />
		<form method="POST" action="${formAction}">
		<input type="hidden" name="destination" value="${param.destination}"/>
		<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}"/>
			<div class="form-group login-labels">
				<label for="userName">User Name: </label>
				<input type="text" id="userName" name="userName" placeHolder="User Name" class="form-control opaque" />
			</div>
			<div class="form-group login-labels">
				<label for="password">Password: </label>
				<input type="password" id="password" name="password" placeHolder="Password" class="form-control opaque" />
			</div>
			<button type="submit" class="btn btn-default opaque">Login</button>
		</form>
	</div>
	<div class="col-sm-2"></div>
</div>
<c:import url="/WEB-INF/jsp/loginCommon/footer.jsp" />