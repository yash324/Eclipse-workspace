package com.barclays;

public class Person implements Comparable{
	// DATA MEMBERS
	private String name;
	private int age;
	private static int count = 0;

	// MEMBER METHODS
	public Person() {
		name = "Not Available";
		age = 18;
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public static int getCount() {
		return Person.count;
	}
	
	@Override
	public String toString() {
		return name + "/" + age;
	}

	@Override
	public int compareTo(Object o)
	{
		return this.name.compareTo(((Person)o).name);
	}

}
