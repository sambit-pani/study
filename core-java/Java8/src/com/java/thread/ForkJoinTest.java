package com.java.thread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinTest {

	public static void main(String[] args) {
		Fibonacci f = new Fibonacci(4);
		ForkJoinPool pool = new ForkJoinPool();
		System.out.println(pool.invoke(f));
		
		Factorial fact = new Factorial(4);
		System.out.println(pool.invoke(fact));
		
		System.out.println(f.fib(4));
		System.out.println(fact.fact(4));
	}
}

class Fibonacci extends RecursiveTask<Integer>{
	
	int num;
	Fibonacci(int num){
		this.num=num;
	}
	@Override
	protected Integer compute() {
		if(num <0) {
			throw new IllegalArgumentException("Invalid Input");
		}
		if(num <=1) {
			return 1;
		}
		//System.out.println(num);
		Fibonacci f1 = new Fibonacci(num-1);
		f1.fork();
		Fibonacci f2 = new Fibonacci(num-2);
		f2.fork();
		return f1.join()+f2.join();
	}
	
	protected int fib(int num) {
		if(num <=1) {
			return 1;
		}
		return fib(num-1)+fib(num-2);
	}
}

class Factorial extends RecursiveTask<Integer>{
	
	int num;
	Factorial(int num){
		this.num=num;
	}
	@Override
	protected Integer compute() {
		if(num <0) {
			throw new IllegalArgumentException("Invalid Input");
		}
		if(num <=1) {
			return 1;
		}
		Factorial f1 = new Factorial(num-1);
		f1.fork();
		return f1.join()*num;
	}
	
	public int fact(int num) {
		if(num <=1) {
			return 1;
		}
		return num* fact(num-1);
	}
}
