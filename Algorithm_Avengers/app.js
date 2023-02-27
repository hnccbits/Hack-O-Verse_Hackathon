// ++++++++++++++++++ imports +++++++++++++++++++++++ //

require('dotenv').config({path : "./config/config.env"});
const cookieParser = require('cookie-parser');
const express = require('express');
const router = require('./routes/users');
const resRouter = require('./routes/resources');
const sosRouter = require('./routes/sos');
const app = express();
const {PORT,SESSION_COOKIE_KEY} = process.env;
const expressLayouts = require('express-ejs-layouts');
const {connectMongoose} = require('./config/mongoose');
const session = require('express-session');
const passport = require('passport');
const passportLocal = require('./config/passport-local-strategy');
const MongoStore = require('connect-mongo')(session);

//  +++++++++++++++ middlewares +++++++++++++++++ //

connectMongoose()
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static('./assets'));
app.use(expressLayouts);
app.set("layout extractStyles", true);
app.set("layout extractScripts", true);

app.set('view engine', 'ejs');
app.set('views', './views');

app.use(session({
    name: 'safetyapp',
    secret: SESSION_COOKIE_KEY,
    saveUninitialized: false,
    resave: false,
    cookie: {
        maxAge: (1000 * 60 * 100)
    }
}));

app.use(passport.initialize());
//using passport session
app.use(passport.session());

app.use(passport.setAuthenticatedUser);

app.use('/', router);
app.use('/res', resRouter);
app.use('/sos', sosRouter)


// ++++++++++++++++++++ server listen +++++++++++++++++++++++ //
app.listen(PORT, () => {
    console.log("Server Connection done ", PORT);
});