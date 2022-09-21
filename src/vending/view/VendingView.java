package vending.view;

import java.math.BigDecimal;
import java.util.ArrayList;

import vending.Item;
import vending.Money;
import vending.controller.VendingService;

public class VendingView {
	UserIO io = new UserIOImp();
	VendingService vendingService = new VendingService();
	
	public void displayItems(){
		System.out.println("______________________________________\n");
		ArrayList<Item> items = vendingService.getItems();
		int j=0;
		if (items.isEmpty())
			System.out.println("Out of service");
		else {
			for (Item i : items) {
				System.out.println("["+(j+1)+"] "+i.getName()+ " | Price: "+ i.getPrice());
				j++;
			}
		}
		System.out.println("["+(j+1)+"]"+" Exit");
		System.out.println("______________________________________");
		String response = io.readString("Please enter some money: ");
		if (response.contentEquals("add"))
			addItem();
		else if(response.contentEquals(String.valueOf(j+1)))
			System.exit(0);
		else {
			try {
				BigDecimal money = new BigDecimal(response);
				Money balance = new Money();
			}catch (NumberFormatException e){System.out.println("Invalid number.");}
		}	
	}
	
	public void addItem() {//Unlisted menu to add items to machine
		long id = io.readLong("ID: ");
		String name = io.readString("Name: ");
		String price = io.readString("Price: ");
		int quantity = io.readInt("Quantity: ");
		vendingService.addItem(id,name,price,quantity);
	} 
}
