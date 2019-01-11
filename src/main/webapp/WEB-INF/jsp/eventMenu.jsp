<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/WEB-INF/jsp/loginCommon/header.jsp" />

<c:url var="eventMenuFieldsSrc" value="/js/menuFields.js"/>
<script src="${eventMenuFieldsSrc}"></script>
<c:url var="eventMenuFormSrc" value="/js/menuForm.js"/>
<script src="${eventMenuFormSrc}"></script>

<section class="rounded centered opaque extendedPadding">

	<h2>Create Your Menu</h2>

	<h4>For ${event.name}</h4>

	<c:url var="eventMenuURL" value="/eventMenu" />
	<form method="POST" action="${eventMenuURL}" id="menu-form">
		<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />

		<div class="col-sm-6">

			<div>
				<label for="foodCategory">Select a Menu Item Type: </label> <select
					name="foodCategoryId" id="foodCategoryId" class="width100">
					<c:forEach var="foodCategory" items="${foodCategories}">
						<option value="${foodCategory.foodCategoryId}">${foodCategory.foodType}</option>
					</c:forEach>
				</select>
			</div>

			<div>
				<label for=foodName>Enter the Menu Item Name </label> <input
					type="text" id="foodName" name="foodName" class="width100"/>
					<span id="foodName-error">&nbsp;</span>
			</div>
			<div>
				<label for="description">Description (optional) </label> <input
					type="text" id="description" name="description" class="width100"></input>
			</div>
			<input type="button" value="Submit" id="menu-submit" class="btn width100"/>
		</div>
	</form>
	<div class="col-sm-6 opaque roundedBottom">
		<c:forEach var="menuItem" items="${foodMenuItems}">
			<div class="menuItem">
				<div class="rightMenu">
					<p class="list">${menuItem.foodCategory}: ${menuItem.name}</p>
					<p>${menuItem.description}</p>
				</div>

				<div class="leftMenu">
					<c:url var="deleteMenuItemURL"
						value="/deleteMenuItem/${menuItem.menuItemId}" />
					<form method="POST" action="${deleteMenuItemURL}">
						<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />
						<button type="submit">
							<span class="glyphicon glyphicon-trash"></span>
						</button>
					</form>
				</div>
			</div>
		</c:forEach>
	</div>
</section>

	<c:url var="eventGuestsURL" value="/eventGuests" />
	<form method="GET" action="${eventGuestsURL}">
		<input type="submit" value="Invite Guests" class="rounded opaque btn btnMargTop"/>
	</form>
	
	<c:url value="/eventInfo" var="eventInfoURL" />
	<form method="GET" action="${eventInfoURL}" >
		<input type="submit" value="When/Where" class="btn centered  btnMargTop" />
	</form>
	
	<c:url var="eventURL" value="/test"/>
	<form method="POST" action="${eventURL}">
		<input type="submit" value="Overview" class="btn btnMargTop" />
		<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />
	</form>

<c:import url="/WEB-INF/jsp/loginCommon/footer.jsp" />