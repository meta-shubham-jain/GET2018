import java.util.ArrayList;
import java.util.Scanner;

/**
 * It contains details about product 
 * @author SHUBHAM JAIN
 *
 */
class Item {
	String item_name;
	int item_id;
	int quantity;
	float price;

	public Item(String item_name, int item_id, int quantity, float price) {
		this.item_name = item_name;
		this.item_id = item_id;
		this.quantity = quantity;
		this.price = price;
	}

	public String getItemName() {
		return item_name;
	}

	public int getItemId() {
		return item_id;
	}

	public String setItemName() {
		return item_name;
	}

	public int setItemId() {
		return item_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setItemPrice(float price) {
		this.price = price;
	}

	public void setItemQuantity(int quantity) {
		this.quantity = quantity;
	}
}

/**
 * It contains cart for a user
 * @author SHUBHAM JAIN
 *
 */
class Cart {
	ArrayList<Item> list = new ArrayList<Item>();
	ArrayList<Item> cart = new ArrayList<Item>();
	Promotion promotionOnOrder = new FixedOrderPromotion();
	Promotion promotionOnProduct = new FixedProductPromotion();

	/**
	 * It will initialize the products
	 */
	Cart() {
		list.add(new Item("Shoes", 1, 50, 500));
		list.add(new Item("Socks", 2, 50, 100));
		list.add(new Item("Shirts", 3, 40, 500));
		list.add(new Item("Jeans", 4, 100, 800));
		list.add(new Item("Pants", 5, 30, 900));

		promotionOnOrder.setMinimumPrice(2000);
		promotionOnOrder.setFixedDiscount(10);
		promotionOnProduct.setMinimumPrice(600);
		promotionOnProduct.setFixedDiscount(100);

	}

	/**
	 * It will add items in cart
	 */
	void addItem() {
		System.out.println("Enter the product Id:");
		Scanner sc = new Scanner(System.in);

		int input = sc.nextInt();
		int id = 0;
		boolean isItemAvailable = false;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getItemId() == input) {
				id = list.get(i).getItemId();
				isItemAvailable = true;
				break;
			}
		}
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).item_id == input) {
				System.out.println("Given item is already present");
				return;
			}
		}
		if (isItemAvailable) {
			System.out.println("Enter the product Quantity");
			int quantity = sc.nextInt();
			if (list.get(id - 1).getQuantity() >= quantity) {
				Item object;
				object = list.get(id - 1);
				Item item = new Item(object.getItemName(), object.getItemId(), quantity, object.getPrice());
				cart.add(item);
				object.setItemQuantity(object.getQuantity() - quantity);
			} else {
				System.out.println("Enter quantity is not Avalaible.");
			}
		} else {
			System.out.println("Given Item ID is not Correct");
		}
	}

	/**
	 * It will remove items from cart
	 */
	void removeItem() {
		System.out.println("Enter product Id to remove");
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		if (cart.isEmpty()) {
			System.out.println("Cart Is Empty");
			return;
		}

		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).item_id == input) {
				for (int j = 0; j < list.size(); j++) {
					if (list.get(j).item_id == input) {
						list.get(j).setItemQuantity(list.get(j).getQuantity() + cart.get(i).getQuantity());
						cart.remove(i);
						return;
					}
				}
			} else {
				System.out.println("Given Id is not in the Cart");
				return;
			}
		}
	}

	/**
	 * It will update items in cart
	 */
	void updateItem() {
		System.out.println("Enter product Id:");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		Item item = null;
		boolean isItemAvailable = false;
		if (cart.isEmpty()) {
			System.out.println("Cart Is Empty");
			return;
		}
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getItemId() == id) {
				item = cart.get(i);
				isItemAvailable = true;
				break;
			}
		}
		if (isItemAvailable) {
			System.out.println("Enter Option to select: \n1.Add\n2.Remove");
			int option = sc.nextInt();
			switch (option) {
			case 1:
				System.out.println("Enter product Quantity to add:");
				int quantity = sc.nextInt();
				if (list.get(id - 1).getQuantity() >= quantity) {
					Item object;
					object = list.get(id - 1);
					item.setItemQuantity(quantity + item.getQuantity());
					object.setItemQuantity(object.getQuantity() - quantity);
				} else {
					System.out.println("Enter quantity is not Avalaible.");
				}
				break;

			case 2:
				System.out.println("Enter product Quantity to add:");
				quantity = sc.nextInt();
				if (item.getQuantity() >= quantity) {
					Item object;
					object = list.get(id - 1);
					item.setItemQuantity(item.getQuantity() - quantity);
					object.setItemQuantity(object.getQuantity() + quantity);
				} else {
					System.out.println("Enter quantity is not Avalaible.");
				}
				break;

			default:
				System.out.println("Wrong Option:");
				break;
			}
		} else {
			System.out.println("Given Item Id is not in Cart:");
			return;
		}
	}

	/**
	 * It will display the Cart Details
	 */
	void displayItem() {
		System.out.println("\nYour Cart Item:");
		System.out.println("Product Id\tName\t\tQuantity\tPrice");
		if (!cart.isEmpty()) {
			for (int i = 0; i < cart.size(); i++) {
				System.out.print(cart.get(i).getItemId() + "\t\t");
				System.out.print(cart.get(i).getItemName() + "\t\t");
				System.out.print(cart.get(i).getQuantity() + "\t\t");
				System.out.println(cart.get(i).getPrice());
			}
		} else {
			System.out.println("Cart Is Empty\n");
		}
	}

	/**
	 * It will display items list that are available
	 */
	void displayOriginalList() {
		System.out.println("Product Id\tName\t\tQuantity\tPrice");
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).getItemId() + "\t\t");
			System.out.print(list.get(i).getItemName() + "\t\t");
			System.out.print(list.get(i).getQuantity() + "\t\t");
			System.out.println(list.get(i).getPrice());
		}
	}

	/**
	 * It will calculate total cost of cart with promocode discount
	 * @param promocode
	 * @return double total price
	 */
	double totalPrice(String promocode) {
				
		double totalCost = 0;
		for (int i = 0; i < cart.size(); i++) {
			if (promotionOnProduct.isPromotionApplicable(promocode) &&  cart.get(i).getPrice()>= promotionOnProduct.getMinimumPrice()) {		
				totalCost = totalCost + (cart.get(i).getPrice() - promotionOnProduct.getFixedDiscount()) * cart.get(i).getQuantity();	
			} else {
				totalCost = totalCost + (cart.get(i).getPrice() * cart.get(i).getQuantity());
	
			}		
		}
		
		if (promotionOnOrder.isPromotionApplicable(promocode) && totalCost >= promotionOnOrder.getMinimumPrice()) {
			totalCost = totalCost - (totalCost * promotionOnOrder.getFixedDiscount()/100);	
		}
		
		return totalCost;
	}
}

/**
 * It will contain main method which provides console for User
 * @author SHUBHAM JAIN
 *
 */
public class ShoppingCart {

	public static void main(String[] args) {
		Cart cart = new Cart();
		String promocode;

		while (true) {
			cart.displayOriginalList();
			cart.displayItem();
			System.out.println(
					"Operations:\n1.Add Item\n2.Remove Item\n3.Update Item\n4.Items in Cart\n5.Generate Bill\n6.Exit");
			Scanner sc = new Scanner(System.in);
			int option = sc.nextInt();
			switch (option) {
			case 1:
				cart.addItem();
				break;

			case 2:
				cart.removeItem();
				break;

			case 3:
				cart.updateItem();
				break;

			case 4:
				cart.displayItem();
				break;

			case 5:
				System.out.println("Enter promotion code");
				promocode = sc.next();
				System.out.println("Total Cost : " + cart.totalPrice(promocode));
				break;

			default:
				System.out.println("Wrong Choice:");
			}
		}
	}
}
