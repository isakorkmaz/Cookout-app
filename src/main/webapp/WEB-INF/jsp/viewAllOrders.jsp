<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/loginCommon/header.jsp" />
<c:url var="otherStyleSheetLink" value="/css/tempStyle.css"/>
<link rel="stylesheet" href="${otherStyleSheetLink}"/>

<section class="opaque rounded">

	<h1 class="centered" id="makeBold">${event.name}</h1>

	<table class="all-orders-table" id="makeBold">
		<tr>
			<th class="category-column">Category</th>
			<th class="item-column">Menu Item</th>
			<th class="guest-order-column">Name</th>
			<th></th>
		</tr>
		<c:forEach var="order" items="${orders}" >
		<tr>
			<td class="category-column">${order.categoryName}</td>
			<td class="item-column">${order.menutItemName}</td>
			<td class="guest-order-column">${order.firstName} ${order.lastName}</td>
			<td class="place-order-column">
				<c:url var="finishOrderUrl" value="/deleteOrder/${order.foodOrderId}"/>
				<form action="${finishOrderUrl}" method="POST">
				<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />
					<input type="submit" class="btn rounded" value="Finished Order"/>			
				</form>
			</td>
		</tr>
		</c:forEach>
	</table>
		<div class="eventDetailsButton centered">
			<c:url var="hostDetailsUrl" value="/test"/>
			<form method="POST" action="${hostDetailsUrl}" >
			<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />
			<input class="btn" type="submit" value="Go To Event Details" />
			</form>
		</div>
</section>

<c:import url="/WEB-INF/jsp/loginCommon/footer.jsp" />