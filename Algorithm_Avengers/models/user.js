const mongoose = require('mongoose');
const Schema = mongoose.Schema;
const branchEnum = [
  'Computer Science Engineering',
  'Information Technology',
  'Electronics & Communication Engg',
  'Electrical Engineering',
  'Mechanical Engineering',
  'Metallurgical Engineering',
  'Civil Engineering',
  'Mining Engineering',
  'Chemical Engineering',
  'Production Engineering'
];

const userSchema = new Schema({
  name: String,
  email: {
    type: String,
    required: true,
    unique: true
  },
  mobile: {
    type: Number,
    required: true
  },
  reg: {
    type: Number,
    required: true,
  },
  branch: {
    type: String,
    enum: branchEnum,
    required: true,
  },
  password: {
    type: String,
    required: true,
  }
}, {
  timestamps: true
});

const User = mongoose.model('User', userSchema);

module.exports = User;
