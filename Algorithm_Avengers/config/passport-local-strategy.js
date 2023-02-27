const passport = require('passport');
const LocalStrategey = require('passport-local').Strategy;
const User = require('../models/user');

// authentication using passport
passport.use(new LocalStrategey({
    usernameField: 'email'
},
    function (email, password, done) {
        // find the user and established the identity
        User.findOne({ email: email }, (err, user) => {
            if (err) {
                console.log("Error in finding user --> passport");
                return done(err);
            }

            if (!user || user.password != password) {
                console.log("Invalid Username or Password Entered!");
                return done(null, false);
            }

            return done(null, user);
        });
    }
));

// serializing the user to decide which key is to be kept in cookies
// serializeUser() saves the user inside the session which was earlier created by express-session middleware.
passport.serializeUser(function (user, done) {
    done(null, user.id);  
});

// deserializing the user from the key in the cookies
// deserializeUser called everytime when a route is hit a backend server
passport.deserializeUser(function (id, done) {
    User.findById(id, (err, user) => {
        if (err) {
            console.log("Error in finding the user");
            return done(err);
        }

        return done(null, user);
    });
});


// check if the user is authenticated
passport.checkAuthentication = function(req, res, next){
    // if the user is singed in, then pass on the request on the next fucntion(controller's action)
    if(req.isAuthenticated()){
        return next();
    }

    // if the user is not singed in
    return res.redirect('/page/signin');
}


passport.setAuthenticatedUser = function(req, res, next){
    if(req.isAuthenticated()){
        // req.user contains the current singed in user from the session cookies and we are just sending this to locals for the views.
        res.locals.user = req.user;
    }
    next();
}

module.exports = passport;