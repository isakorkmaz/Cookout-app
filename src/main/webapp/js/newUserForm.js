var newUserForm;

window.onload = function() {
    newUserForm = new pageForm();

    newUserForm.resetErrors();

    // go into jsps and add ids to buttons to act as submits
    selector("new-user-submit").onclick = function () {
        if (newUserForm.validateForm()) {
            // give the form tags an id to act for the post
            selector("new-user-form").submit();
        }
    }
}