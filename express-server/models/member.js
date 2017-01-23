// Load required packages
let mongoose = require('mongoose');

let memberSchema = new mongoose.Schema({
    name: String,
    age: Number,
    nickname: String,
    role: String
});

// Export the mongoose model
module.exports = mongoose.model('Member', memberSchema);