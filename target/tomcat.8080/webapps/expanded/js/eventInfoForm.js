var infoForm;

window.onload = function() {
    infoForm = new pageForm();

    infoForm.resetErrors();

    var navButtons =  document.querySelectorAll(".event-info-btn");

    // go into jsps and add ids to buttons to act as submits
    selector("info-submit").onclick = function () {
        infoForm.resetErrors();
        if (infoForm.validateForm()) {
            // give the form tags an id to act for the post
            selector("info-form").submit();
        }
    };

    navButtons.forEach( (button) => {
        button.onclick = function () {
            infoForm.resetErrors();
            if(infoForm.validateForm()) {
                selector("info-form").submit();
            }
        }
    });
}