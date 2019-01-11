<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/loginCommon/header.jsp" />

<section class="full menu ">

	<div class="opaque rounded centered miniPad miniMargin ">

		<h2>${event.name}</h2>
		<div class="fourColumns ">
			<div class="entrees ">
				<h3>Entrees</h3>
				<c:forEach var="menuItem" items="${menu}">
					<c:if test="${menuItem.foodCategory == 'Entree'}">
						<ul class="ul">
							<li>${menuItem.name}</li>
							<c:if test="${!empty menuItem.description}">
								<p>${menuItem.description}</p>
							</c:if>
						</ul>
						<c:url var="orderThis" value="/addOrder/${menuItem.menuItemId}" />
						<form method="POST" action="${orderThis}" class="marginBottom">
							<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" /> <input
								type="submit" value="Order This Item">
							<hr />
						</form>
					</c:if>
				</c:forEach>
			</div>

			<div class="sides  ">
				<h3>Sides</h3>
				<c:forEach var="menuItem" items="${menu}">
					<c:if test="${menuItem.foodCategory == 'Side'}">
						<ul class="ul">
							<li>${menuItem.name}</li>
							<c:if test="${!empty menuItem.description}">
								<p>${menuItem.description}</p>
							</c:if>
						</ul>
						<c:url var="orderThis" value="/addOrder/${menuItem.menuItemId}" />
						<form method="POST" action="${orderThis}" class="marginBottom">
							<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" /> <input
								type="submit" value="Order This Item">
						</form>
					</c:if>
				</c:forEach>
			</div>

			<div class="desserts ">
				<h3>Desserts</h3>

				<c:forEach var="menuItem" items="${menu}">
					<c:if test="${menuItem.foodCategory == 'Dessert'}">
						<ul class="ul">
							<li>${menuItem.name}</li>
							<c:if test="${!empty menuItem.description}">
								<p>${menuItem.description}</p>
							</c:if>
						</ul>
						<c:url var="orderThis" value="/addOrder/${menuItem.menuItemId}" />
						<form method="POST" action="${orderThis}" class="marginBottom ">
							<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" /> <input
								type="submit" value="Order This Item">
						</form>
					</c:if>
				</c:forEach>
			</div>

			<div class="beverages">
				<h3>Beverages</h3>
				<c:forEach var="menuItem" items="${menu}">
					<c:if test="${menuItem.foodCategory == 'Beverage'}">
						<ul class="ul ">
							<li>${menuItem.name}</li>
							<c:if test="${!empty menuItem.description}">
								<p>${menuItem.description}</p>
							</c:if>
						</ul>
						<c:url var="orderThis" value="/addOrder/${menuItem.menuItemId}" />
						<form method="POST" action="${orderThis}" class="marginBottom ">
							<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" /> <input
								type="submit" value="Order This Item">
						</form>
					</c:if>
				</c:forEach>
			</div>
		</div>
	</div>

	<div>
		<c:url var="guestEventDetailsUrl"
			value="/guestEventDetails?eventId=${event.eventId}" />
		<form method="POST" action="${guestEventDetailsUrl}">
			<input type="submit" value="Go To Event Details"
				class="btn2 eventDetailsButton guestGoToEvntButton btn btnMargTop rounded centered" />
		</form>
	</div>
</section>
<section class="orderedItems ">

	<div class="opaque rounded centered miniPad miniMargin ">

		<h2>Your Order</h2>
		<br />
		<div class="fourColumns ">
			<div class="entrees ">

				<c:forEach var="ordersItem" items="${orders}">
					<c:if test="${ordersItem.categoryName == 'Entree'}">
						<ul class="ul">
							<li>${ordersItem.menutItemName}</li>
							<c:if test="${!empty ordersItem.description}">
								<p>${ordersItem.description}</p>
							</c:if>
						</ul>

					</c:if>
				</c:forEach>
			</div>

			<div class="sides  ">

				<c:forEach var="ordersItem" items="${orders}">
					<c:if test="${ordersItem.categoryName == 'Side'}">
						<ul class="ul">
							<li>${ordersItem.menutItemName}</li>
							<c:if test="${!empty ordersItem.description}">
								<p>${ordersItem.description}</p>
							</c:if>
						</ul>

					</c:if>
				</c:forEach>
			</div>

			<div class="desserts ">


				<c:forEach var="ordersItem" items="${orders}">
					<c:if test="${ordersItem.categoryName == 'Dessert'}">
						<ul class="ul">
							<li>${ordersItem.menutItemName}</li>
							<c:if test="${!empty ordersItem.description}">
								<p>${ordersItem.description}</p>
							</c:if>
						</ul>

					</c:if>
				</c:forEach>
			</div>

			<div class="beverages">

				<c:forEach var="ordersItem" items="${orders}">
					<c:if test="${ordersItem.categoryName == 'Beverage'}">
						<ul class="ul">
							<li>${ordersItem.menutItemName}</li>
							<c:if test="${!empty ordersItem.description}">
								<p>${ordersItem.description}</p>
							</c:if>
						</ul>

					</c:if>
				</c:forEach>
			</div>
		</div>
	</div>
</section>

<c:import url="/WEB-INF/jsp/loginCommon/footer.jsp" />