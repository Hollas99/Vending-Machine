package vending;

import java.io.Serializable;
import java.math.BigDecimal;

public class Item implements Serializable{

	private static final long serialVersionUID = -2285014046531087435L;
	private Long itemId;
	private BigDecimal price;
	private String name;
	private int quantity;
	
	
	
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public Item(Long itemId, BigDecimal price, String name, int quantity) {
		super();
		this.itemId = itemId;
		this.price = price;
		this.name = name;
		this.quantity = quantity;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
