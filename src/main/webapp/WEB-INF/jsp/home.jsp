<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/loginCommon/header.jsp" />
<section>
	<c:url value="/eventInfo" var="eventInfoURL" />
	<form method="GET" action="${eventInfoURL}" >

		<input type="submit" value="Create New Cookout" class="btn centered  btnMargBottom" />
	</form>

	<div class="allCookouts">
		<div class="hosted centered opaque rounded">
			<h2>Hosted</h2>
			<c:forEach var="event" items="${hostList}">
				<div class="events">
					<c:url var="eventUrl" value="/hostEventDetails" >
				 	<c:param name="eventId" value="${event.eventId}" />
				 	</c:url>
					<a href="${eventUrl}">${event.name}</a>
				</div>
			</c:forEach>
		</div>

		<div class="invited centered opaque rounded">
			<h2>Invited</h2>
			<c:forEach var="event" items="${invitedList}">
				<div class="events">
					<c:url var="eventUrl" value="/guestEventDetails" >
				 	<c:param name="eventId" value="${event.eventId}" />
				 	</c:url>
					<a href="${eventUrl}">${event.name}</a>
				</div>
			</c:forEach>
		</div>
	</div>

</section>
<c:import url="/WEB-INF/jsp/loginCommon/footer.jsp" />