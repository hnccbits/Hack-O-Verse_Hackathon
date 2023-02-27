const jwt = require('jsonwebtoken')

function generateToken(user) {
    const payload = {
      _id: user._id,
      email: user.email
    };
  
    // const secret = process.env.JWT_SECRET;
    const options = {
      expiresIn: '1h'
    };
  
    return jwt.sign(payload, process.env.JWT_SECRET, options);
  }

  module.exports = {generateToken};