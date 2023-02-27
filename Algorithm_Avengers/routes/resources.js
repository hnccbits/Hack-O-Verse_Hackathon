const express = require('express');
const router = express.Router();
const resController = require('../controllers/res_controller');

router.get('/vids', resController.videosPage);
module.exports = router;