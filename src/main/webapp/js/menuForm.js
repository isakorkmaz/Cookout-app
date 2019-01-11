var menuForm;

window.onload = function() {
    menuForm = new pageForm();

    menuForm.resetErrors();

    // go into jsps and add ids to buttons to act as submits
    selector("menu-submit").onclick = function () {
        menuForm.resetErrors();
        if (menuForm.validateForm()) {
            // give the form tags an id to act for the post
            selector("menu-form").submit();
        }
    }
}