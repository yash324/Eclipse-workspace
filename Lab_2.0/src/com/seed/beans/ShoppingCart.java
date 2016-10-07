package com.seed.beans;

import java.util.HashSet;
import java.util.LinkedList;

public class ShoppingCart {
	private java.util.Collection<Integer> productIds;

	public ShoppingCart() {
		productIds = new LinkedList<Integer>();
	}

	public java.util.Set<Integer> getProductSet() {
		// TODO:2 return set of product ids stored in this shopping cart
		return new HashSet<Integer>(productIds);

	}

	public void setProductList(String[] newProductIds) {
		// TODO:3 add newProductIds into existing list of product ids
		for (int i = 0; i < newProductIds.length; i++)
			productIds.add(Integer.parseInt(newProductIds[i]));
	}
}
