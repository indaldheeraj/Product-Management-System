package entity;

public class Product {
	public int id;
	public String name;
	public String type;
	public double price;
	public int quantity;
	boolean   inStock;
	public boolean instock;
	public Product(int id, String name, String type, double price, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;                //source -constructour -(alt+shift+s)
		this.price = price;
		this.quantity = quantity;
		inStock=true;
		
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", type=" + type + ", price=" + price + ", quantity=" + quantity
				+ ", inStock=" + inStock + "]";
	}
	

}
