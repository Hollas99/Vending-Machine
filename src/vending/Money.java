package vending;

import java.math.BigDecimal;

public class Money {
	private BigDecimal balance = new BigDecimal(0);
	
	public void addMoney(BigDecimal amount) {
		this.balance=balance.add(amount);
	}
	public void spentMoney(BigDecimal amount) {
		this.balance = balance.subtract(amount);
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
	
}
