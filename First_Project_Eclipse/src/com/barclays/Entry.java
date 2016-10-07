package com.barclays;

import java.util.ArrayList;
import java.util.TreeSet;

public class Entry {
	int x;

	public static void main(String[] args) {

		System.out.println("Hello, world!");
		Person p;
		p = null;
		p = new Person();
		System.out.println(p.getName());
		System.out.println(p.getAge());
		System.out.println(Person.getCount());
		p = null;

	}

}
