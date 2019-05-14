# EcommerceProject

All PUT and Post API accepting 4 fields -

"id" - For time bieng is PK , Which is given by User (Not Auto Generated) while Creating a new Order.
"item" - Item Name
"count" - No.Of Item
"email" - Email id of the User.


Inventory API -

GET inventory/ - Fetch All the Orders.
GET inventory/{Id} -  Fetch order with given order id.
Post inventory/- Create a new Order.
Delete inventory/{Id} - Delete a particular oder with Given Id.
Put inventory/{Id} - Update the stock with Given User Id.

GET inventory/findall - retrun list of all the items availaible.


Order API -

GET order/ - Fetch all the orders.

Post order/ - Place a order.

Post order/bulk - Place a Bulk order. - Accept a Bulk order in an Json format in Arrays form example-

[{   "id": "mohitsharp",
	"item": "sharpner",
	"count": 20,
	"email":"mohit190392@gmail.com"
},
{   "id": "mohitpencil",
	"item": "pencil",
	"count": 700,
	"email":"mohit190392@gmail.com"
}
]





Didn't handle the API Security and Custom HTTP response as for now.
Manual Documantation , No Swagger.



