class ShoppingCart:
    def __init__(self):
        self.items = []
        self.totalPrice = 0.0
 
    def addItem(self, item):
        self.items.append(item)
 
    def removeItem(self, item):
        if item in self.items:
            self.items.remove(item)
 
    def getTotalPrice(self):
        self.totalPrice = sum(item.price for item in self.items)
        return self.totalPrice
    
#main class
class Item:
    def __init__(self, name, price):
        self.name = name
        self.price = price
 
my_cart = ShoppingCart()
 
item1 = Item("margarine", 7.0)
item2 = Item("potato", 6.0)
item3 = Item("carrot", 10.0)
 
my_cart.addItem(item1)
my_cart.addItem(item2)
my_cart.addItem(item3)
 
my_cart.removeItem(item2)
 
print(f"Total price: {my_cart.getTotalPrice()}")
