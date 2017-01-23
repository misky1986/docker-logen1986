// Get dependencies ======================================================================
const express = require('express');
const mongoose = require('mongoose');
const bodyParser = require('body-parser');
const database  = require('./config/database');
const apiRoutes = require('./routes/api');          // Get our API routes

// Setup ================================================================================
const app = express();
const port = process.env.PORT || '3000';            // Get port from environment and store in Express.
mongoose.connect(database.dbHost); 	                // Connect to mongoDB database on modulus.io

// Parsers for POST data
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));

// Cross Origin middleware
app.use(function(req, res, next) {
    res.header("Access-Control-Allow-Origin", "*");
    res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
    next()
});

// routes ======================================================================
app.use('/', apiRoutes);                            // Register our api routes

// listen (start app with node server.js) ======================================
app.listen(port, () => console.log(`API running on localhost:${port}`));