var pageForm = function() { };

pageForm.prototype = new Validate();

pageForm.prototype.validateField = function(fieldName, text) {

    var field = fields[fieldName]

    if(field.required) {
        if(this.isBlank(text)) {
            throw new Error(field.required);
        }
    }

    if(field.noMatch) {
        if(!this.isMatch(text, selector(field.noMatch[1]).value)) {
            throw new Error(field.noMatch[0]);
        }
    }

    if(field.isZip) {
        if(!this.isZip(text)) {
            throw new Error(field.isZip);
        }
    }

    if(field.capitals) {
        if(!this.hasCapitals(text)) {
            throw new Error(field.capitals);
        }
    }

    if(field.numbers) {
        if(!this.hasNumbers(text)) {
            throw new Error(field.numbers);
        }
    }
};

pageForm.prototype.setError = function(fieldName, message) {
    selector(fieldName + "-error").setAttribute("class", "error glyphicon glyphicon-remove-sign");
    selector(fieldName + "-error").firstChild.nodeValue = message;
};

pageForm.prototype.clearError = function(fieldName, message) {
    selector(fieldName + "-error").setAttribute("class", "");
    selector(fieldName + "-error").firstChild.nodeValue = message || "";
};

pageForm.prototype.resetErrors = function() {
    for (var fieldName in fields) {
        this.clearError(fieldName, fields[fieldName].message);
    }
};

pageForm.prototype.validateForm = function() {
    var isOk = true;
    for (var fieldName in fields) {
        this.clearError(fieldName);
        try {
            this.validateField(fieldName, selector(fieldName).value); 
        } catch (error) {
            isOk = false;
            this.setError(fieldName, error.message);
        }
    }
    return isOk;
};