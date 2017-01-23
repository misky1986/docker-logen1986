// Import dependencies
const express = require('express');
const router = express.Router();
let Member = require('../models/member');

/* GET api listing. */
router.get('/', (req, res) => {
    res.status(200).send('The api works!!!!');
});

/* GET all members. */
router.get('/members', (req, res) => {
    Member.find({}, (err, members) => {
        if (err) res.status(500).send(error);

        res.status(200).json(members);
    });
});

/* GET one members. */
router.get('/members/:id', (req, res) => {
    Member.findById(req.param.id, (err, members) => {
        if (err) res.status(500).send(error);

        res.status(200).json(members);
    });
});

/* Create a member. */
router.post('/members', (req, res) => {
    let member = new Member({
        name: req.body.name,
        age: req.body.age,
        nickname: req.body.nickname,
        role: req.body.role
    });

    member.save(error => {
        if (error) res.status(500).send(error);

        res.status(201).json({
            message: 'Member created successfully'
        });
    });
});

module.exports = router;