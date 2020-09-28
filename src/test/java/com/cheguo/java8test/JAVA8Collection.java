package com.cheguo.java8test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JAVA8Collection {

    public static void main(String[] args) {
	/** 测试1---- 3 apple, 2 banana, others 1 **/
	List<String> items = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");
	Map<String, Long> result = items.stream()
		.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	System.out.println(result);

	Map<String, Long> finalMap = new LinkedHashMap<>();
	/** 测试2---- reversed 反排序 **/
	result.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
		.forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));
	System.out.println(finalMap);

	/** 测试3---- 3 apple, 2 banana, others 1 **/
	List<User> items2 = Arrays.asList(new JAVA8Collection().new User("apple", 10, new BigDecimal("9.99")),
		new JAVA8Collection().new User("banana", 20, new BigDecimal("19.99")), new JAVA8Collection().new User("orang", 10, new BigDecimal("29.99")),
		new JAVA8Collection().new User("watermelon", 10, new BigDecimal("29.99")), new JAVA8Collection().new User("papaya", 20, new BigDecimal("9.99")),
		new JAVA8Collection().new User("apple", 10, new BigDecimal("9.99")), new JAVA8Collection().new User("banana", 10, new BigDecimal("19.99")),
		new JAVA8Collection().new User("apple", 20, new BigDecimal("9.99")));
	// 计算名字出现的次数
	Map<String, Long> counting = items2.stream()
		.collect(Collectors.groupingBy(User::getName, Collectors.counting()));
	System.out.println(counting);
	// 计算每个人金额是多少
	Map<String, Integer> sum = items2.stream()
		.collect(Collectors.groupingBy(User::getName, Collectors.summingInt(User::getPrice)));
	System.out.println(sum);

	/** 测试4---- 3 apple, 2 banana, others 1 **/
        List<User> items3 = Arrays.asList(
        	new JAVA8Collection().new User("apple", 10, new BigDecimal("9.99")),
        	new JAVA8Collection().new User("banana", 20, new BigDecimal("19.99")),
        	new JAVA8Collection().new User("orang", 10, new BigDecimal("29.99")),
        	new JAVA8Collection().new User("watermelon", 10, new BigDecimal("29.99")),
        	new JAVA8Collection().new User("papaya", 20, new BigDecimal("9.99")),
        	new JAVA8Collection().new User("apple", 10, new BigDecimal("9.99")),
                new JAVA8Collection().new User("banana", 10, new BigDecimal("19.99")),
                new JAVA8Collection().new User("apple", 20, new BigDecimal("9.99"))
        );
        //group by Salary
        Map<BigDecimal, List<User>> groupByPriceMap =
                items3.stream().collect(Collectors.groupingBy(User::getSalary));
        System.out.println(groupByPriceMap);
        // group by Salary, uses 'mapping' to convert List<Item> to Set<String>
        Map<BigDecimal, Set<String>> result2 =
                items3.stream().collect(
                        Collectors.groupingBy(User::getSalary,
                                Collectors.mapping(User::getName, Collectors.toSet())
                        )
                );
        System.out.println(result2);

    }

    class User {

	private String name;
	private int price;
	private BigDecimal salary;

	User() {

	}

	User(String name, int price, BigDecimal salary) {
	    this.name = name;
	    this.price = price;
	    this.salary = salary;
	}

	public String getName() {
	    return name;
	}

	public void setName(String name) {
	    this.name = name;
	}

	public int getPrice() {
	    return price;
	}

	public void setPrice(int price) {
	    this.price = price;
	}

	public BigDecimal getSalary() {
	    return salary;
	}

	public void setSalary(BigDecimal salary) {
	    this.salary = salary;
	}
    }
}
