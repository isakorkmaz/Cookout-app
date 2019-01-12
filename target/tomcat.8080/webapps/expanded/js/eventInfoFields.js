var fields = {
    eventName: {
        required: "*required"
    },
    eventTime: {
        required: "*required"
    },
    eventDate: {
        required: "*required"
    },
    streetAddress: {
        required: "*required"
    },
    city: {
        required: "*required"
    },
    zip: {
        message: "*Use 5 or 9 digit zip code",
        required: "*required",
        isZip: "*Zip code is invalid"
    }
};