const express = require('express');
const router = express.Router();
const sosController = require('../controllers/sos');

router.get('/emerg', sosController.sosPage);


module.exports = router;