//var config = require('../.private/config.js');

var express = require('express');

var api = express.Router();

var request = require("request-promise");

var avalibleEquipment= ['Treadmill', 'Free Weights', 'Elliptical', 'Bench Press'];

var users = {
  'joe' : [0],
  'jane' : [0]
  }; 


// Returns static text
api.get('/health', function(req, res){
  res.send(JSON.stringify({health:"It's all good in the hood."}));
})

api.get('/getEquipment', function(req, res){
  res.send(JSON.stringify(avalibleEquipment));
})

api.get('/useEquipment', function(req, res){
    equipmentUsed = req.param('equipment');
    user = req.param('user');

    users[user][0] = equipmentUsed;

    res.send(JSON.stringify({status:"OK"}));
})

api.get('/getUsers', function(req, res){
  res.send(JSON.stringify(users));
})

// Add articles
// api.get('/add_article', function(req,res){
//   parsed_title = {
//     topic: req.param('topic'),
//     title: req.param('title'),
//     publisher: req.param('publisher'),
//     publisher_url: req.param('publisher_url') ,
//     image_url: req.param('content_html'),
//     type: req.param('type')
//   }

//   var topic_details = new ArticlesInfo(parsed_title);

//   topic_details.save(function (err) {
//       if (err) {
//           res.send(err)
//           return;
//       }
//       console.log({message: 'Article details been added to MongoDB'})
//   })
// })

module.exports = api;