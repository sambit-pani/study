package com.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Lambda {

	public static void main(String[] args) {
		List<String> stringList = Arrays.asList("firstname", "edward", "rahul", "rohit", "tom");
		List<Integer> intList = Arrays.asList(5, 6, 9, 1, 3, 10);
		/*
		 * Predicate Test
		 */
		
		List<String> resultStringList = FunctionTest.filter( str -> str.length() > 5, stringList);
		System.out.println(resultStringList);
		List<Integer> resultIntList = FunctionTest.filter(i -> i > 5, intList);
		System.out.println(resultIntList);
		
		/*
		 * Function test
		 */
		//resultIntList = FunctionTest.apply( s -> s.length(), stringList);
		resultIntList = FunctionTest.apply( String::length, stringList);
		System.out.println(resultIntList);

		resultStringList = FunctionTest.apply( i -> {
			StringBuilder ret = new StringBuilder();
			for (int j = 0; j < i; j++)
				ret.append("A");
			return ret.toString();
		}, intList);
		System.out.println(resultStringList);
		
		/*
		 * consumer test
		 */
		FunctionTest.accept((String str) ->{System.out.print(str.length());} , stringList);
		
		/*
		 * supplier test
		 */
		resultStringList = FunctionTest.get(String :: new, stringList.size());
		System.out.println(resultStringList);
		
		Fruit f = new Fruit("apple", 40, 11);
		List<Fruit> fruitList = Arrays.asList( new Fruit("apple", 40, 11),
				 new Fruit("grapes", 54, 2),
				 new Fruit("orange", 78, 18),
				 new Fruit("pineapple", 15, 9),
				 new Fruit("guava", 25, 8),
				 new Fruit("banana", 20, 25),
				 new Fruit("berry", 40, 5));
		
		List<Fruit> resultFruit = new ArrayList<>();
		fruitList.sort((Fruit f1,Fruit f2) -> f1.getName().compareTo(f2.getName()));
		//fruitList.sort((f1,f2) -> f1.getName().compareTo(f2.getName()));
		//fruitList.sort(Comparator.comparing(Fruit::getName));
		System.out.println(fruitList);
		
		fruitList.sort(Comparator.comparing(Fruit::getPrice).thenComparing(Fruit::getQuantity));
		System.out.println(fruitList);
		
		/*
		 * Composing Predicate
		 */
		Predicate<Fruit> quantityPredicate = fruit -> fruit.getQuantity() > 10;
		Predicate<Fruit> finalPredicate = quantityPredicate.and(fruit -> fruit.getPrice() > 20);
		resultFruit = FunctionTest.filter(finalPredicate, fruitList);
		System.out.println(resultFruit);
	}

}

class FunctionTest {
	public static <T> List<T> filter(Predicate<T> filter, List<T> list) {
		List<T> result = new ArrayList<>();
		for (T t : list) {
			if (filter.test(t)) {
				result.add(t);
			}
		}
		return result;
	}

	public static <T, R> List<R> apply(Function<T, R> function, List<T> list) {
		List<R> resultList = new ArrayList<>();
		for (T t : list) {
			resultList.add(function.apply(t));
		}
		return resultList;
	}
	
	public static <T> void accept(Consumer<T> consumer,List<T> list) {
		for(T t : list) {
			consumer.accept(t);
		}
	}
	
	public static <T> List<T> get(Supplier<T> supplier,int length) {
		List<T> resultList = new ArrayList<>();
		for(int i=0;i<length;i++) {
			resultList.add(supplier.get());
		}
		return resultList;
	}
}

class Fruit{
	private String name;
	private int price;
	private int quantity;
	
	Fruit(String name,int price, int quantity){
		this.name= name;
		this.price=price;
		this.quantity=quantity;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	@Override
	public String toString() {
		return "Fruit [name=" + name + "]";
	}
	
	
}