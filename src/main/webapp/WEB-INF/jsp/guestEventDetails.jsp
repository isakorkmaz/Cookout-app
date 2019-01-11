<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/loginCommon/header.jsp" />

<c:url var="dateFormatterSrc" value="/js/dateFormatter.js"/>
<script src="${dateFormatterSrc}"></script>
<%-- 
<script>
	var dateTag = document.getElementById("event-date");
	
	var dateString = dateTage.value.toString();
	
	dateString = dateString.subString(7);
	
	console.log(dateString);

</script>
--%>

<section>
	<div class="opaque rounded miniPad">
			<h2 class="centered">${event.name}</h2>
		<div class="detailsGrid">
			<div class="hostEventDetails centered">
				<div class="detailsLeft">
					<p class="hostEventDate" id="makeBold">Date: <span id="event-date">${event.eventDate}</span></p> 
					<p class="hostEventTime" id="makeBold">Time: <span id="event-time">${event.eventTime}</span></p>
				</div>
			</div>
	
			
				<div class="detailsLeft centered">
					<div class="hostEventAddress" id="makeBold">
						<p class="hostStreetAddress">Street: ${address.streetAddress}</p>
						<div class="cityStateCip">
							<p class="hostCity">City: ${address.city}</p>
							<p class="hostState">State: ${address.state}</p>
							<p class="hostZip">Zip: ${address.zip}</p>
						</div>
					</div>
				</div>
				<div class="detailsRight centered">
					<div class="rsvpButton" id="makeBold">
						<c:url var="rsvpURL" value="/guestEventDetails" />
						<form method="POST" action="${rsvpURL}">
							<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />
							<c:if test="${eventAttendee == true}">
								<p>RSVP</p>
								<input type="radio" name="rsvp" value="true" checked="checked"
									onclick="this.form.submit();">Yes<br>
								<input type="radio" name="rsvp" value="false"
									onclick="this.form.submit();">No 
							</c:if>
							<c:if test="${eventAttendee == false}">
								<p>RSVP</p>
								<input type="radio" name="rsvp" value="true"
									onclick="this.form.submit();">Yes<br>
								<input type="radio" name="rsvp" value="false" checked="checked"
									onclick="this.form.submit();">No 
									</c:if>
						</form>
					</div>
				</div>
			</div>
	</div>
	<div class="guestOrder">
		<c:url var="guestOrderURL" value="/placeOrder" />
		<form method="GET" action="${guestOrderURL}">
			<input type="submit" value="Order for this Event"
				class="btn btnMargTop width100">
		</form>
	</div>

</section>

<c:import url="/WEB-INF/jsp/loginCommon/footer.jsp" />