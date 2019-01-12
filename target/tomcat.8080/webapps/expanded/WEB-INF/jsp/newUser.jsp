<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/loginCommon/header.jsp" />

<%-- <script type="text/javascript">
	$(document).ready(function () {
		$.validator.addMethod('capitals', function(thing){
			return thing.match(/[A-Z]/);
		});
		$("form").validate({
			
			rules : {
				userName : {
					required : true
				},
				password : {
					required : true,
					minlength: 8,
					capitals: true
				},
				confirmPassword : {
					required : true,		
					equalTo : "#password"; 
				},
				firstName: {
					required: true;
				},
				lastName: {
					required: true;
				},
				email: {
					required: true;
				}
			},
			messages : {			
				password: {
					minlength: "Password too short, make it at least 8 characters",
					capitals: "Field must contain a capital letter",
				},
				confirmPassword : {
					equalTo : "Passwords do not match"
				}
			},
			errorClass : "error"
		});
	});
</script> --%>

<c:url var="newUserFieldSrc" value="/js/newUserFields.js"/>
<script src="${newUserFieldSrc}"></script>
<c:url var="newUserFormSrc" value="/js/newUserForm.js"/>
<script src="${newUserFormSrc}"></script>

<c:url var="formAction" value="/users" />
<form method="POST" action="${formAction}" id="new-user-form">
<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}"/>
	<div class="row">
		<div class="col-sm-2"></div>
		<div class="col-sm-8">
		
			<div class="form-group">
				<h4 id="error-msg" class="error">${errorMsg}</h4>
			</div>
		
			<div class="form-group login-labels">
				<label for="userName">User Name: </label>  
				<input type="text" id="userName" name="userName" placeHolder="User Name" class="form-control opaque" />
				<span id="userName-error">&nbsp;</span>
			</div>
			<div class="form-group login-labels">
				<label for="password">Password: </label>
				<input type="password" id="password" name="password" placeHolder="Password" class="form-control opaque" />
				<span id="password-error">&nbsp;</span>
			</div>
			<div class="form-group login-labels">
				<label for="confirmPassword">Confirm Password: </label>
				<input type="password" id="confirmPassword" name="confirmPassword" placeHolder="Re-Type Password" class="form-control opaque" />	
				<span id="confirmPassword-error">&nbsp;</span>
			</div>
			
			<div class="form-group login-labels">
				<label for="firstName">First Name: </label>
				<input type="text" id="firstName" name="firstName" placeHolder="First Name" class="form-control opaque" />
				<span id="firstName-error">&nbsp;</span>
			</div>
			
			<div class="form-group login-labels">
				<label for="lastName">Last Name: </label>
				<input type="text" id="lastName" name="lastName" placeHolder="Last Name" class="form-control opaque" />
				<span id="lastName-error">&nbsp;</span>
			</div>
			
			<div class="form-group login-labels">
				<label for="email">Email: </label>
				<input type="email" id="email" name="email" placeHolder="johnsmith@email.com" class="form-control opaque" />
				<span id="email-error">&nbsp;</span>
			</div>
			
			<div class="form-group login-labels">
				<label for="foodRestrictions">Food Restrictions: </label>
				<textarea id="foodRestrictions" name="foodRestrictions" class="form-control opaque">
				</textarea>
			</div>
			
			<input type="button" class="btn btn-default opaque" id="new-user-submit" value="Create User"/>
	
		</div>
		<div class="col-sm-2"></div>
	</div>
</form>
		
<c:import url="/WEB-INF/jsp/loginCommon/footer.jsp" />