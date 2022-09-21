package vending;

import vending.view.VendingView;

public class Main {

	public static void main(String[] args) {
		
		VendingView vendingView = new VendingView();
		while(true)
			vendingView.displayItems();
	}

}
