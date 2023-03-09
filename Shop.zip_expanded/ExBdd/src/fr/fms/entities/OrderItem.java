package fr.fms.entities;

public class OrderItem {
	private int idOrderItem;

	private int idArticle;
	private int quantity;
	private double unitaryPrice;
	
	private int idOrder;

	public OrderItem(int idOrderItem, int idArticle, int quantity, double unitaryPrice, int idOrder) {
		this.idOrderItem = idOrderItem;
		this.idArticle = idArticle;
		this.quantity = quantity;
		this.unitaryPrice = unitaryPrice;
		this.idOrder = idOrder;
	}

	public int getIdOrderItem() {
		return idOrderItem;
	}

	public void setIdOrderItem(int idOrderItem) {
		this.idOrderItem = idOrderItem;
	}

	public int getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getUnitaryPrice() {
		return unitaryPrice;
	}

	public void setUnitaryPrice(double unitaryPrice) {
		this.unitaryPrice = unitaryPrice;
	}

	public int getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}
}
