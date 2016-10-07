package com.simulationdemo;

public class Cat extends Feline {

	public Cat(String type, String location) {
		super(type, location);
	}

	private int size;

	public int getSize() {
		return size;
	}

	public void roam() {
		// TODO Auto-generated method stub
		System.out.println("Inside Roam of CAT");
	}

}
