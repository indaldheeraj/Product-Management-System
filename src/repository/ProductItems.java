package repository;

import java.util.ArrayList;
import java.util.Iterator;


import entity.Product;

public class ProductItems {
	
	ArrayList<Product>productList = new ArrayList<>();
	
public void addProduct(Product product) {
	productList.add(product);
	}


	
	public boolean removeProduct(int id ) {
		for (int i=0;i<productList.size();i++) {
			Product product = productList.get(i);
			if(product.id==id) {
				productList.remove(product);
				return true;
			}
			
		}
		return false;
		
	
}
	public void displayProducts() {
		if(productList.size()==0) 
		{
			System.out.println("no products r added");
			return;
		}
		System.out.println("id\tname\tprice\tquantity\tInstock");
		for (int i=0;i<productList.size();i++) {
			Product product = productList.get(i);
			System.out.println(product.id+"\t"+product.name+"\t"+product.price+"\t"+product.quantity+"\t"+"\t");
		if(product.instock) 
			System.out.println("\tyes");
			else 
				System.out.println("\tno");
			
	
		
		}
	
	
}}
