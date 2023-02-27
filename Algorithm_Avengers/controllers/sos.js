const InstantMessage = require('../models/sms');

module.exports.sosPage = function(req, res){
    res.render('sos',{
        title : "Emergency services"
    });
}

