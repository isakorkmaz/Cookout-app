var guestForm;

window.onload = function() {
    guestForm = new pageForm();

    guestForm.resetErrors();

    // go into jsps and add ids to buttons to act as submits
    selector("guest-submit").onclick = function () {
        guestForm.resetErrors();
        if (guestForm.validateForm()) {
            // give the form tags an id to act for the post
            selector("guest-form").submit();
        }
    }
}