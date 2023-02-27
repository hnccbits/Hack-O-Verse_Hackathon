const accountSid = process.env.TWILIO_ACCOUNT_SID;
const authToken = process.env.TWILIO_AUTH_TOKEN;

var client = require('twilio')(accountSid, authToken);
client.calls.create({
    url : 'http://demo.twilio.com/docs/voice.xml',
    to: process.env.TWILIO_PHONE_NUMBER,
    from: +12766226550
}, function(err, call){
    if(err){
        console.log(err);
    }else{
        console.log(call.sid)
    }
})