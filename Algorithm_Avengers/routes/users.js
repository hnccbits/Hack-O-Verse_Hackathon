const express = require('express');
const router = express.Router();
const passport = require('../config/passport-local-strategy');
const userController = require('../controllers/user_controller');

router.get('/page/signup', userController.signupPage);
router.get('/page/signin', userController.loginPage);
router.get('/page/home', userController.homePage);


router.route('/register').post(userController.register);
router.route('/login').post(userController.createSession);
router.route('/logout').get(userController.destroySession);

// router.route('/otp')
// .post(userController.verifyOtp, userController.redirectHome);
// router.route('/page/otp').get(userController.otpPage);

router.route('/page/sms').get( userController.smsPage);


module.exports = router;



