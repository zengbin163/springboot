package com.cheguo.java8test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class People {
    private int no;
    private String name;
    private String sex;
    private float height;
    
    public People() {
	
    }

    public People(int no, String name, String sex, float height) {
	this.no = no;
	this.name = name;
	this.sex = sex;
	this.height = height;
    }

    public int getNo() {
	return no;
    }

    public void setNo(int no) {
	this.no = no;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getSex() {
	return sex;
    }

    public void setSex(String sex) {
	this.sex = sex;
    }

    public float getHeight() {
	return height;
    }

    public void setHeight(float height) {
	this.height = height;
    }
    
    @Override
    public String toString() {
        return this.getNo() + "-" + this.getName() + "-"  + this.getSex() + "-" + this.getHeight();
    }

    public static void main(String[] args) {
	People pA = new People(1, "A", "M", 184);
	People pB = new People(2, "B", "G", 163);
	People pC = new People(3, "C", "M", 175);
	People pD = new People(4, "D", "G", 158);
	People pE = new People(5, "E", "M", 170);
	List<People> list = new ArrayList<>();
	list.add(pA);
	list.add(pB);
	list.add(pC);
	list.add(pD);
	list.add(pE);

	Iterator<People> iterator = list.iterator();
	while (iterator.hasNext()) {
	    People p = iterator.next();
	    if (p.getSex().equals("G")) {
		System.out.println(p.toString());
	    }
	}
	System.out.println("-----------------------------------");
	list.stream().filter(people -> people.getSex().equals("G")).forEach(people -> System.out.println(people.toString()));
	System.out.println("-----------------------------------");
	long count = list.stream().filter(p -> {
	    System.out.println(p.getName());
	    return p.equals(new People());
	}).count();
	System.out.println(count);
    }
}