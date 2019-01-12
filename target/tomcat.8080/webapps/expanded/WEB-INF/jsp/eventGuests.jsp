<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/loginCommon/header.jsp" />

<c:url var="guestFieldsSrc" value="/js/eventGuestsFields.js" />
<script src="${guestFieldsSrc}"></script>
<c:url var="guestFormSrc" value="/js/eventGuestForm.js" />
<script src="${guestFormSrc}"></script>

<section class="opaque">
	<div class="centered">
		<h2>Invite Your Guests</h2>
	</div>
	<div class="guestGrid">
		<div class="leftGuest">
			<c:url var="eventGuestsURL" value="/eventGuests" />
			<form method="POST" action="${eventGuestsURL}" id="guest-form">
				<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" /> <label
					for="firstName">Enter Guest First Name: </label> <input type="text"
					id="firstName" class="width100" name="firstName"
					placeholder="First Name" /> <span id="firstName-error">&nbsp;</span>
				<label for="lastName">Enter Guest Last Name: </label> <input
					type="text" id="lastName" class="width100" name="lastName"
					placeholder="Last Name" /> <span id="lastName-error">&nbsp;</span>
				<label for="email">Enter Guest Email: </label> <input type="text"
					id="email" class="width100" name="email"
					placeholder="Guest@email.com" /> <span id="email-error">&nbsp;</span>
				<input type="button" value="Invite" id="guest-submit"
					class="btn btnMargTop" />
			</form>
		</div>
		<div class="rightGuest">
			<c:forEach var="invitedGuest" items="${guestList}">
				<div class="invitedGuest miniPad">
					<p>${invitedGuest.firstName} ${invitedGuest.lastName}</p>
					<p>${invitedGuest.email}</p>
					
					<c:url var="deleteGuestURL"
						value="/uninviteGuest/${invitedGuest.attendeeId}" />
					<form method="POST" action="${deleteGuestURL}">
						<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" /> <input
							type="submit" value="Uninvite Guest" />
					</form>
				</div>
			</c:forEach>
		</div>
	</div>
</section>
<c:url var="eventMenuURL" value="/eventMenu" />
<form method="GET" action="${eventMenuURL}">
	<input type="submit" value="Food Menu" class="btn btnMargTop" />
</form>
<c:url value="/eventInfo" var="eventInfoURL" />
	<form method="GET" action="${eventInfoURL}" >
		<input type="submit" value="When/Where" class="btn centered  btnMargTop" />
	</form>
<c:url var="eventURL" value="/test" />
<form method="POST" action="${eventURL}">
	<input type="submit" value="Overview" class="btn btnMargTop" /> <input
		type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />
</form>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />