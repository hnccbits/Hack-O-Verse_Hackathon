const InstantMessage = require('../models/sms');

module.exports.createSMS = async (req, res) =>{
    await InstantMessage.create(req.body);

    res.redirect('back');
}