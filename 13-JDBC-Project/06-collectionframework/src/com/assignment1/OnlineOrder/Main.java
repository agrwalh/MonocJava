package com.assignment1.OnlineOrder;

import java.util.*;

abstract class Order {
	int OrderId;
	String customerName;
	double amount;

	Order(int OrderId, String customerName, double amount) {
		if (OrderId <= 0)
			throw new IllegalArgumentException("ID must be +ve");
		if (customerName == null || customerName.trim().isEmpty())
			throw new IllegalArgumentException("Name cannot be empty");
		if (amount <= 0)
			throw new IllegalArgumentException("Amout cannot be negtive");
		this.OrderId = OrderId;
		this.customerName = customerName;
		this.amount = amount;
	}

	abstract String getType();
}

class RegularOrder extends Order {
	RegularOrder(int id, String name, double amt) {
		super(id, name, amt);
	}

	String getType() {
		return "Regular";
	}
}

class PriorityOrder extends Order {
	PriorityOrder(int id, String name, double amt) {
		super(id, name, amt);
	}

	String getType() {
		return "Priority";
	}
}

class SortByAmount implements Comparator<Order> {
	public int compare(Order a, Order b) {
		return Double.compare(a.amount, b.amount);
	}
}

class OrderManager {

	List<Order> orders = new ArrayList<>();
	Queue<Order> queue = new LinkedList<>();
	Set<Integer> processed = new HashSet<>();
	Map<String, List<Order>> customerOrders = new HashMap<>();

	void addOrder(Order o) {
		for (Order ord : orders) {
			if (ord.OrderId == o.OrderId) {
				System.out.println("Duplicate ID");
				return;
			}
		}

		if (!customerOrders.containsKey(o.customerName)) {
			customerOrders.put(o.customerName, new ArrayList<>());
		}

		customerOrders.get(o.customerName).add(o);
		orders.add(o);

		System.out.println("Order Added");
	}

	void display() {
		for (Order o : orders) {
			System.out.println(o.OrderId + " " + o.customerName + " " + o.amount + " " + o.getType());
		}
	}

	void requestDispatch(int id) {
		if (processed.contains(id)) {
			System.out.println("Already processed");
			return;
		}

		for (Order o : orders) {
			if (o.OrderId == id) {
				queue.add(o);
				System.out.println("Added to queue");
				return;
			}
		}

		System.out.println("Order not found");
	}

	void processDispatch() {
		if (queue.isEmpty()) {
			System.out.println("Queue empty");
			return;
		}

		Order o = queue.poll();
		processed.add(o.OrderId);

		System.out.println("Processed: " + o.OrderId);
	}

	void sortByAmount() {
		Collections.sort(orders, new SortByAmount());
		System.out.println("Sorted by Amount");
	}

	void removeOrder(int id) {
		Iterator<Order> it = orders.iterator();

		while (it.hasNext()) {
			Order o = it.next();

			if (o.OrderId == id) {
				it.remove();

				List<Order> list = customerOrders.get(o.customerName);
				if (list != null) {
					list.remove(o);
					if (list.isEmpty()) {
						customerOrders.remove(o.customerName);
					}
				}

				System.out.println("Removed");
				return;
			}
		}

		System.out.println("Not found");
	}

	void displayCustomerOrders() {
		if (customerOrders.isEmpty()) {
			System.out.println("No customer data");
			return;
		}

		for (String customer : customerOrders.keySet()) {
			System.out.println("Customer: " + customer);

			List<Order> list = customerOrders.get(customer);

			for (Order o : list) {
				System.out.println("  " + o.OrderId + " " + o.amount + " " + o.getType());
			}
		}
	}
}

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		OrderManager manager = new OrderManager();

		while (true) {

			System.out.println("\n==== ORDER MENU ====");
			System.out.println("1. Add Order");
			System.out.println("2. Display Orders");
			System.out.println("3. Request Dispatch");
			System.out.println("4. Process Dispatch");
			System.out.println("5. Sort by Amount");
			System.out.println("6. Remove Order");
			System.out.println("7. Display Customer Orders");
			System.out.println("8. Exit");

			System.out.print("Enter choice: ");
			int choice = scanner.nextInt();

			switch (choice) {

			case 1:
				System.out.print("Enter type (1-Regular, 2-Priority): ");
				int type = scanner.nextInt();

				System.out.print("Enter ID: ");
				int id = scanner.nextInt();
				scanner.nextLine();

				System.out.print("Enter Name: ");
				String name = scanner.nextLine();

				System.out.print("Enter Amount: ");
				double amt = scanner.nextDouble();

				if (type == 1) {
					manager.addOrder(new RegularOrder(id, name, amt));
				} else if (type == 2) {
					manager.addOrder(new PriorityOrder(id, name, amt));
				} else {
					System.out.println("Invalid type");
				}
				break;

			case 2:
				manager.display();
				break;

			case 3:
				System.out.print("Enter Order ID: ");
				manager.requestDispatch(scanner.nextInt());
				break;

			case 4:
				manager.processDispatch();
				break;

			case 5:
				manager.sortByAmount();
				break;

			case 6:
				System.out.print("Enter Order ID: ");
				manager.removeOrder(scanner.nextInt());
				break;

			case 7:
				manager.displayCustomerOrders();
				break;

			case 8:
				System.out.println("Exiting...");
				return;

			default:
				System.out.println("Invalid choice");
			}
		}
	}
}