db = db.getSiblingDB('CBdb');

// Calendar collection
db.bDay.drop();
db.createCollection("bDay");
var file = cat('/data/db/2019-31.json');
var o = JSON.parse(file);
for (var i = 0; i < o.length; i++){
	o[i]._id = new Date(o[i]._id);
}
db.bDay.insert(o);

// Customer collection
db.bCustomer.drop();
db.createCollection("bCustomer");
file = cat('/data/db/customer.json');
o = JSON.parse(file); 
db.bCustomer.insert(o);