var Validate = function() { };

Validate.prototype.isBlank = function(text) {
    return (text === "");
};

Validate.prototype.isMatch = function(text1, text2) {
    return (text1 === text2);
};

Validate.prototype.isZip = function(text) {
    return /^\d{5}(-\d{4})?$/.test(text);
};

Validate.prototype.hasCapitals = function(text) {
    var hasCapitals = false;
    var capitals = ["A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"];
    capitals.forEach( (letter) => {
        if(text.includes(letter)) {
            hasCapitals = true;
        }
    });
    return hasCapitals;
};

Validate.prototype.hasNumbers = function(text) {
    var hasNumbers = false;
    var nums = ["1","2","3","4","5","6","7","8","9","0"];
    nums.forEach( (num) => {
        if(text.includes(num)) {
            hasNumbers = true;
        }
    });
    return hasNumbers;
}

Validate.prototype.isMinLength = function(text) {
    return text.length >= 8;
}