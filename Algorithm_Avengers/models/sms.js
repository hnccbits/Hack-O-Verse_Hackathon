const mongoose = require('mongoose');

const instantMessageSchema = new mongoose.Schema({
  incidentLocation: {
    type: String,
    required: true,
    enum: [
      "Main Gate",
      "IT Building",
      "B-Zone",
      "Girls Hostel",
      "PMC Side",
      "OP Gate",
      "Club Ground (CG)",
      "Sindri Railway Station",
      "Library",
      "Mechanical Department",
      "MC Ground",
      "Canteen",
      "Aunty Maggi"
    ]
  },
  typeOfIncident: {
    type: String,
    required: true,
    enum : [
      "Medical Emergency",
      "Fire Breakout",
      "Women Harrassment",
      "Robbery"
    ]
  }
});

const InstantMessage = mongoose.model('InstantMessage', instantMessageSchema);

module.exports = InstantMessage;
