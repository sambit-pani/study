package com.java;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {

	public static void main(String[] args) {
		List<Fruit> fruitList = Arrays.asList( new Fruit("apple", 40, 11),
				 new Fruit("grapes", 54, 2),
				 new Fruit("orange", 78, 18),
				 new Fruit("pineapple", 15, 9),
				 new Fruit("guava", 25, 8),
				 new Fruit("banana", 20, 25),
				 new Fruit("berry", 40, 5));
		
		//fruitList.stream().collect(Collectors.)
		
	}
}
interface test{
	void a();
	default void b() {
		
	}
	default void c() {
		
	}
}