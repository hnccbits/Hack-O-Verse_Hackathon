const express = require('express');
const router = express.Router();

const smsController = require('../controllers/sms_controller');
router.route('/createSMS').post(smsController.createSMS);

module.exports = router;