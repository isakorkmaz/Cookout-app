<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/loginCommon/header.jsp" />

<c:url var="dateFormatterSrc" value="/js/dateFormatter.js"/>
<script src="${dateFormatterSrc}"></script>
<section class="hostEventSection opaque rounded">
	<h2 class="centered">${event.name}</h2>
	<div class="miniPadTop">

		<div id="hostEvenDetailsOpaqueContainer">

			<div id="hostEventDetails">

				<div id="hostEventDateTime">
					<p class="hostEventDate hostEventInfo">Date: <span id="event-date">${event.eventDate}</span></p>
					<p class="hostEventTime hostEventInfo">Time: <span id="event-time">${event.eventTime}</span></p>
				</div>

				<div class="hostEventAddress">
					<p class="hostStreetAddress hostEventInfo">Street:
						${address.streetAddress}</p>
					<p class="hostCity hostEventInfo">City: ${address.city}</p>
					<p class="hostState hostEventInfo">State: ${address.state}</p>
					<p class="hostZip hostEventInfo">Zip: ${address.zip}</p>
				</div>
			</div>

			<div id="divHostEventDetailButtons">
				<div class="editMenuButton">
					<c:url var="editMenuURL" value="/eventMenu" />
					<form method="GET" action="${editMenuURL}">
						<input class="hostEventDetailButton btn rounded" type="submit"
							value="Edit Menu">
					</form>
				</div>
				<div class="editEventButton">
					<c:url value="/eventInfo" var="eventInfoURL" />
					<form method="GET" action="${eventInfoURL}">
						<input class="hostEventDetailButton btn rounded" type="submit"
							value="Edit Time/Place" />
					</form>
				</div>
				<div class="viewGuests">
					<c:url var="viewGuestsURL" value="/eventGuests" />
					<form method="GET" action="${viewGuestsURL}">
						<input class="hostEventDetailButton btn rounded" type="submit"
							value="View/Edit Guest List">
					</form>
				</div>

				<div class="viewShortOrdersButton">
					<c:url var="viewShortOrdersURL" value="/viewShortOrders" />
					<form method="GET" action="${viewShortOrdersURL}">
						<input class="hostEventDetailButton btn rounded" type="submit"
							value="View Short Orders">
					</form>
				</div>
				
				<div class="viewAllOrdersButton">
					<c:url var="viewAllOrdersUrl" value="/viewAllOrders"/>
					<form method="GET" action="${viewAllOrdersUrl}">
						<input class="hostEventDetailButton btn rounded" type="submit" 
						value="View Guest Orders"/>
					</form>
				</div>
			</div>
		</div>
	</div>
</section>

<c:import url="/WEB-INF/jsp/loginCommon/footer.jsp" />