const User = require('../models/user');
const { generateToken } = require('../utils/auth');
const jwt = require('jsonwebtoken');
const crypto = require('crypto');
// const twilio = require('twilio');



module.exports.signupPage = function (req, res) {
    if(req.isAuthenticated()){
        return res.redirect('/page/home');
    }

    res.render('signup', {
        title: "Sign Up to SafeBIT!"
    })
}

module.exports.loginPage = function (req, res) {
    if(req.isAuthenticated()){
        return res.redirect('/page/home');
    }

    res.render('login', {
        title: "Login"
    })
}

module.exports.homePage = function (req, res) {
    res.render('home', {
        title: "Safe BIT"
    })
}


module.exports.register = async (req, res) => {
    const user = await User.create(req.body);

    const token = generateToken(user);
    res.cookie('token', token, {
      httpOnly: true,
      maxAge: 3600000 
    });

    res.redirect('/page/signin');
  
};



module.exports.createSession = function(req, res) {
  // get the token from the cookie
  const token = req.cookies.token;

  try {
    const decoded = jwt.verify(token, process.env.JWT_SECRET);

    // set the user id in the session
    req.session.userId = decoded._id;

    return res.redirect('/page/home');
  } catch (error) {
    console.log('Error in creating session', error);
    return res.redirect('/page/signin');
  }
};

module.exports.destroySession = function(req, res) {
  // clear the user id from the session
  req.session.userId = null;

  // clear the token from the cookie
  res.clearCookie('token');

  return res.redirect('/page/signin');
};

module.exports.smsPage = (req,res)=>{
  res.render('sms',{
    title : "Instant SMS"
  })
}