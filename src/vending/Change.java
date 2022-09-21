package vending;

import java.math.BigDecimal;

public class Change{
	Coins coin;
	
	
	public String giveChange(BigDecimal Amount) {
		int quarters = 0;
		int dimes=0;
		int nickels=0;

		while(Amount.compareTo(Coins.QUARTER.value) >= 0) {
			quarters+=1;
			Amount = Amount.subtract(Coins.QUARTER.value);
		}

		while(Amount.compareTo(Coins.DIME.value) >= 0) {
			dimes+=1;
			Amount =Amount.subtract(Coins.DIME.value);
		}

		while(Amount.compareTo(Coins.NICKEL.value) >= 0) {
			nickels+=1;
			Amount =Amount.subtract(Coins.NICKEL.value);
		}
		
		int pennies=Amount.intValue();
		return "Your Change: \n"+quarters+" Quarters\n"+dimes+" Dimes\n"+nickels+" Nickels\n"+pennies+" Pennies.";
	}
}