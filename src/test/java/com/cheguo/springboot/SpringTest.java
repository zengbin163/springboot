package com.cheguo.springboot;

public class SpringTest {

    public static void main(String[] args) {
	long startNano = System.nanoTime();
	long startMillis = System.currentTimeMillis();
	try {
	    Thread.sleep(1000);
	}catch (Exception e) {
	}
	long endNano = System.nanoTime();
	long endMillis = System.currentTimeMillis();
	
	System.out.println(endNano - startNano);
	System.out.println(endMillis - startMillis);

    }

}
