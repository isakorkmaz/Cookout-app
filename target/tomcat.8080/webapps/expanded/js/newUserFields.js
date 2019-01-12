var fields = {
		userName: {
			required: "Must enter a User Name"
		},
		password: {
			required: "Must enter a Password",
			capitals: "Must contain a capital letter",
			numbers: "Must contain a number",
			minLength: "Must be at least 8 characters"
			// can add more validation constraints here
		},
		confirmPassword: {
			required: "Must retype Password",
			noMatch: ["Passwords must match", "password"]
		},
		firstName: {
			required: "Must enter your First Name"
		},
		lastName: {
			required: "Must enter your Last Name"
		},
		email: {
			required: "Must enter your Email address"
		}
}