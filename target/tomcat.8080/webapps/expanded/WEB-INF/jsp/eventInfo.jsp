<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/loginCommon/header.jsp" />

<c:url var="infoFieldsSrc" value="/js/eventInfoFields.js" />
<script src="${infoFieldsSrc}"></script>
<c:url var="infoFormSrc" value="/js/eventInfoForm.js" />
<script src="${infoFormSrc}"></script>

<section id="create-event-basics-page">

	<div class="opaque roundedTop centered">
		<h2>Event Time/Date</h2>
	</div>
	<c:url var="eventInfoUrl" value="/eventInfo" />
	<form method="POST" action="${eventInfoUrl}" id="info-form">
		<div class="roundedBottom centered opaque miniPad">

			<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" /> <input
				type="hidden" name="hostUserName" value="${user.userName}" />

			<div>
				<label class="eventInfoLabel" for="eventName">Name of the
					Event: </label> <input class="eventInfoInput" type="text" name="eventName"
					id="eventName" placeholder="e.g. Bob's Cookout"
					value="${event.name}" /> <span id="eventName-error">&nbsp;</span>
			</div>

			<div>
				<label class="eventInfoLabel" for="eventTime">Event Start
					Time: </label> <input type="time" class="eventInfoInput" name="eventTime"
					id="eventTime" value="${event.eventTime}" /> <span
					id="eventTime-error">&nbsp;</span>
			</div>

			<div>
				<label class="eventInfoLabel" for="eventDate">Date of the
					Event: </label> <input class="eventInfoInput" type="date" name="eventDate"
					id="eventDate" value="${event.eventDate}" /> <span
					id="eventDate-error">&nbsp;</span>
			</div>

			<div>
				<label class="eventInfoLabel" for="streetAddress">Street
					Address: </label> <input class="eventInfoInput" type="text"
					name="streetAddress" id="streetAddress"
					value="${address.streetAddress}" /> <span id="streetAddress-error">&nbsp;</span>
			</div>

			<div>
				<label class="eventInfoLabel" for="city">City: </label> <input
					class="eventInfoInput" type="text" name="city" id="city"
					value="${address.city}" /> <span id="city-error">&nbsp;</span>
			</div>

			<div>
				<label class="eventInfoLabel" for="state">State: </label> <select
					class="eventInfoInput" name="state" id="state">
					<option value="AL">Alabama</option>
					<option value="AK">Alaska</option>
					<option value="AZ">Arizona</option>
					<option value="AR">Arkansas</option>
					<option value="CA">California</option>
					<option value="CO">Colorado</option>
					<option value="CT">Connecticut</option>
					<option value="DE">Delaware</option>
					<option value="DC">District Of Columbia</option>
					<option value="FL">Florida</option>
					<option value="GA">Georgia</option>
					<option value="HI">Hawaii</option>
					<option value="ID">Idaho</option>
					<option value="IL">Illinois</option>
					<option value="IN">Indiana</option>
					<option value="IA">Iowa</option>
					<option value="KS">Kansas</option>
					<option value="KY">Kentucky</option>
					<option value="LA">Louisiana</option>
					<option value="ME">Maine</option>
					<option value="MD">Maryland</option>
					<option value="MA">Massachusetts</option>
					<option value="MI">Michigan</option>
					<option value="MN">Minnesota</option>
					<option value="MS">Mississippi</option>
					<option value="MO">Missouri</option>
					<option value="MT">Montana</option>
					<option value="NE">Nebraska</option>
					<option value="NV">Nevada</option>
					<option value="NH">New Hampshire</option>
					<option value="NJ">New Jersey</option>
					<option value="NM">New Mexico</option>
					<option value="NY">New York</option>
					<option value="NC">North Carolina</option>
					<option value="ND">North Dakota</option>
					<option value="OH">Ohio</option>
					<option value="OK">Oklahoma</option>
					<option value="OR">Oregon</option>
					<option value="PA">Pennsylvania</option>
					<option value="RI">Rhode Island</option>
					<option value="SC">South Carolina</option>
					<option value="SD">South Dakota</option>
					<option value="TN">Tennessee</option>
					<option value="TX">Texas</option>
					<option value="UT">Utah</option>
					<option value="VT">Vermont</option>
					<option value="VA">Virginia</option>
					<option value="WA">Washington</option>
					<option value="WV">West Virginia</option>
					<option value="WI">Wisconsin</option>
					<option value="WY">Wyoming</option>
				</select>
			</div>

			<div>
				<label class="eventInfoLabel" for="zip">Zip Code: </label> <input
					class="eventInfoInput" type="text" name="zip" id="zip"
					value="${address.zip}" /> <span id="zip-error">&nbsp;</span>
			</div>
		

		
			<div class="eventInfoSubmitclass">
				<input type="button" value="Save" class="btn btnMargTop"
					id="info-submit" />
			</div>
		</div>
	</form>
	<c:url var="eventMenuURL" value="/eventMenu" />
	<form method="GET" action="${eventMenuURL}">
		<input type="button" value="Food Menu" class="btn btnMargTop event-info-btn" />
	</form>
	<c:url var="eventGuestsURL" value="/eventGuests" />
	<form method="GET" action="${eventGuestsURL}">
		<input type="button" value="Invite Guests" class="btn btnMargTop event-info-btn" />
	</form>
	<c:url var="eventURL" value="/test"/>
	<form method="POST" action="${eventURL}">
		<input type="button" value="Overview" class="btn btnMargTop event-info-btn" />
		<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />
	</form>
</section>
<c:import url="/WEB-INF/jsp/loginCommon/footer.jsp" />