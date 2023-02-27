const mongoose = require('mongoose');
const {MONGO_URI} = process.env;

exports.connectMongoose = () =>{
    mongoose
.connect(MONGO_URI)
.then(()=>{
    console.log("Database connection successful");
})
.catch((err) =>{
    console.log("Database connection error : ", err);
});
}
