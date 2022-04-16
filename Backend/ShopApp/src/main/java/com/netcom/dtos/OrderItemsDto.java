package com.netcom.dtos;

import com.netcom.entities.Cart;
import com.netcom.entities.Order;
import com.netcom.entities.Product;

public class OrderItemsDto
{
 private int id;
 private int quantity;
 private  Product product;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public Product getProduct() {
	return product;
}
public void setProduct(Product product) {
	this.product = product;
}
@Override
public String toString() {
	return "OrderItemsDto [id=" + id + ", quantity=" + quantity + ", product=" + product + "]";
}
public OrderItemsDto(int id, int quantity, Product product) {
	super();
	this.id = id;
	this.quantity = quantity;
	this.product = product;
}
public OrderItemsDto() {
	super();
}
	

public OrderItemsDto(Order order)
{
	this.id = order.getId();
	this.quantity = order.getQuantity();
	this.setProduct(order.getProduct());
}


}
