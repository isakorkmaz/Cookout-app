
window.onload = function() {

    var eventDateTag = document.getElementById("event-date");
    var eventDateString = eventDateTag.innerText.toString();

    var eventDate = new Date(eventDateString);

    var year = eventDate.getFullYear();
    var month = eventDate.getMonth();
    var day = eventDate.getDate();

    eventDateTag.innerText = month + "-" + day + "-" + year;
    

    var eventTimeTag = document.getElementById("event-time");
    var eventTimeString = eventTimeTag.innerText.toString();
    var hour = parseInt(eventTimeString);
    var minutes;
    var amOrPm = "AM";

    console.log(hour);

    if(hour > 9) {
        minutes = eventTimeString.substring(3);
    } else {
        minutes = eventTimeString.substring(2);
    };

    if(hour > 12) {
        hour -= 12;
        amOrPm = "PM"; 
    };

    eventTimeTag.innerText = hour + ":" + minutes + " " + amOrPm;

}