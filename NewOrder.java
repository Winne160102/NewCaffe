package QA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class NewOrder {
	private String name;
	private String size;
	private String ice;
	private String sugar;
	private String topping;
	private String price;
	private String quantity;
	
	public NewOrder() {
		super();
	}
	
	public NewOrder(String name, String size, String ice, String sugar, String topping, String quantity, String price) {
		super();
		this.name = name;
		this.size = size;
		this.ice = ice;
		this.sugar = sugar;
		this.topping = topping;
		this.quantity = quantity;
		this.price = price;
	}
	
	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	public String getName() {
		return name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getIce() {
		return ice;
	}

	public void setIce(String ice) {
		this.ice = ice;
	}

	public String getSugar() {
		return sugar;
	}

	public void setSugar(String sugar) {
		this.sugar = sugar;
	}

	public String getTopping() {
		return topping;
	}

	public void setTopping(String topping) {
		this.topping = topping;
	}

	public static boolean check(Scanner sc) {
		boolean exit = false;
		while(!exit) {
		System.out.println("Do you want to order more? (Y/N)");
		String choice = sc.nextLine();
		if(!choice.equalsIgnoreCase("N") && !choice.equalsIgnoreCase("Y")) {
			System.out.println("Invalid Choice, Input Again!! ");
			choice = sc.nextLine();
		}
		return choice.equalsIgnoreCase("Y");
		}
		return exit;
	}
	
	public static ArrayList<NewOrder> inputOrder() {
		ArrayList<NewOrder> list = new ArrayList<NewOrder>();
		Scanner sc = new Scanner(System.in);
		boolean exit = false;
		while(!exit) {
		System.out.println("Input Name: ");
		String name = sc.nextLine();
		System.out.println("Input Size: ");
		String size = sc.nextLine();
		System.out.println("Input Ice: ");
		String ice = sc.nextLine();
		System.out.println("Input Sugar: ");
		String sugar = sc.nextLine();
		System.out.println("Input Topping: ");
		String topping = sc.nextLine();
		System.out.println("Input Quantity: ");
		String quantity = sc.nextLine();
		System.out.println("Input Price: ");
		String price = sc.nextLine();
		NewOrder order = new NewOrder(name, size, ice, sugar, topping, quantity, price);
	    list.add(order);
	    if (!check(sc)) {
	        exit = true;
			}
		}
		return list;
	}
	
	public void printBill(ArrayList<NewOrder> list) {
		System.out.println("3 THẰNG ĐẬP ĐÁ");
		System.out.println("Address: BỜ HỒ");
		System.out.println("Phone: 0123456789");
		for (NewOrder order : list) {
	        System.out.println("Name: " + order.getName());
	        System.out.println("Quantity: " + order.getQuantity());
	        System.out.println("Note: " + order.getIce() + ";" + order.getSize() + ";" + order.getSugar() + ";" + order.getTopping());
	        System.out.println("Price: " + order.getPrice());
	    }
	}
	
	public static void outputFileOrder(ArrayList<NewOrder> list) {
		try {
			FileWriter fWriter = new FileWriter("C:\\Users\\Admin\\Desktop\\lib java\\Order.txt");
			BufferedWriter bWriter = new BufferedWriter(fWriter);
		    for (NewOrder data : list) {
		    bWriter.write(data.name + ";" + data.size + ";" + data.ice + ";" + data.sugar + ";" + data.topping  + ";" + data.quantity + ";" + data.price);
		    bWriter.newLine();    	
		    }
			bWriter.close();
			fWriter.close();
			} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void choiceQA() {
		Scanner sc = new Scanner(System.in);
		ArrayList<NewOrder> list = new ArrayList<NewOrder>();
		boolean exit = false;
		System.out.println("Enter Your Choice: 1 - Order Your Drink And Print Bill, 2 - Complete The Purchase.");
		while (!exit) {
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				list = inputOrder();
				outputFileOrder(list);
				System.out.println("Order Has Been Completed");
				printBill(list);
				break;
			case 2:
				exit = true;
				System.out.println("Exit!");
				break;
			default:
				System.out.println("Invalid Choice!");
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		 NewOrder od = new NewOrder();
		 od.choiceQA();
	}
}
