package vending.controller;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;

import vending.Item;

public class VendingService {
	public ArrayList<Item> getItems(){
		try{
			FileInputStream fStream = new FileInputStream(new File("VendingItems.dat"));
			ObjectInputStream oStream = new ObjectInputStream(fStream);
			
			ArrayList<Item> itemList = new ArrayList<>();
			while (true) {
				try{
					itemList.add((Item) oStream.readObject());
				}
				catch(EOFException eof){ //Expecting, when there are no more object in the file
					fStream.close();
					oStream.close();
					break;
				}
				catch(Exception e) {e.printStackTrace();break;}
			}
			return itemList;
		}				
		catch (FileNotFoundException fnf) {
			File file = new File("Items.dat");
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return new ArrayList<Item>();}
		catch (EOFException eof) {System.out.println("There are currently 0 items in the inventory!\n");return new ArrayList<Item>();}
		catch(Exception e) {e.printStackTrace();return null;}
	}
	public void saveItems(ArrayList<Item> itemList) {
		try{
			FileOutputStream fStream = new FileOutputStream(new File("VendingItems.dat"));
			ObjectOutputStream oStream = new ObjectOutputStream(fStream);

			for (Item item : itemList) { //Add all items to file
				oStream.writeObject(item);
			}
			fStream.close();
			oStream.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void addItem(Long id, String name, String priceStr, int quantity)  {
		ArrayList<Item> itemList =  getItems(); //Get current file
		//Convert String to BigDecimal
		BigDecimal price = new BigDecimal(priceStr);
		Item item = new Item(id,price,name,quantity);
		itemList.add(item);
		saveItems(itemList);
	}
}
