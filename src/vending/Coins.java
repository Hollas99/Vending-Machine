package vending;

import java.math.BigDecimal;

public enum Coins {
	QUARTER(new BigDecimal(25)),
	DIME(new BigDecimal(10)),
	NICKEL(new BigDecimal(5)),
	PENNY(new BigDecimal(1));
	
	BigDecimal value;
	Coins (BigDecimal value){
		this.value=value;
	}
}
