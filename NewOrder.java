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
		// TODO Auto-generated constructor stub
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
		System.out.println("Do you want to order more? (Y/N)");
	        String choice = sc.nextLine();  
	        if (choice.equalsIgnoreCase("N")) {
	            exit = true;
	        } else if (!choice.equalsIgnoreCase("Y")) {
	          System.out.println("Please choose again!");
	          choice = sc.nextLine();
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
		    bWriter.write(data.name + ";" + data.size + ";" + data.ice + ";" + data.sugar + ";" + data.topping  + ";" + data.quantity + data.price);
		    bWriter.newLine();    	
		    }
			bWriter.close();
			fWriter.close();
			} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static ArrayList<NewOrder> inputFileBill() {
		ArrayList<NewOrder> list = new ArrayList<NewOrder>();
		try {
			FileReader fReader = new FileReader("C:\\\\Users\\\\Admin\\\\Desktop\\\\lib java\\\\Order.txt");
			BufferedReader bReader = new BufferedReader(fReader);
			while(true) {
				String line = bReader.readLine();
				if(line == null || line == "") break;
				String[] temp = line.split("[;]");
				NewOrder data = new NewOrder(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6]);
				list.add(data);
			}
			bReader.close();
			fReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void outputFileBill(ArrayList<NewOrder> list){
		try {
			FileWriter fWriter = new FileWriter("C:\\Users\\Admin\\Desktop\\lib java\\bill.txt");
			BufferedWriter bWriter = new BufferedWriter(fWriter);
			for(NewOrder data : list) {
				bWriter.write(data.getName() + ";" + data.getSize() + ";" + data.getIce() + ";" + data.getSugar() + ";" + data.getTopping() + ";" + data.getQuantity() + ";" + data.getPrice());
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
		System.out.println("Enter Your Choice: 1 - Order Your Drink And Print Bill, 2 - Save Bill To Data, 3 - Complete The Purchase.");
		while (!exit) {
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				ArrayList<NewOrder> list1 = inputOrder();
				outputFileOrder(list1);
				System.out.println("Order Has Been Completed");
				printBill(list1);
				break;	
			case 2:
				list = inputFileBill();
				outputFileBill(list);
				System.out.println("Save Bill To Data Has Been Completed");
			case 3:
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
