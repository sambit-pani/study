package com.java.hackerrank;


	import java.io.*;
	import java.math.*;
	import java.security.*;
	import java.text.*;
	import java.util.*;
	import java.util.concurrent.*;
	import java.util.function.*;
	import java.util.regex.*;
	import java.util.stream.*;
	import static java.util.stream.Collectors.joining;
	import static java.util.stream.Collectors.toList;



	class Result {

	    /*
	     * Complete the 'numberOfPaths' function below.
	     *
	     * The function is expected to return an INTEGER.
	     * The function accepts 2D_INTEGER_ARRAY a as parameter.
	     */

	    public static int numberOfPaths(List<List<Integer>> a) {
	    // Write your code here
	    	int totalPaths = 0;
	    	if(a.get(0).get(0) == 0) {
	    		return 0;
	    	}else if(a.size()==1 && a.get(0).size()==1){
	    		return 1;
	    	}
	    	if(a.get(0).size()>1) {
	    		List<List<Integer>> temp = new ArrayList<>();
	    		for(List<Integer> i:a) {
	    			List<Integer> o = i.subList(1, a.get(0).size());
	    			temp.add(o);
	    		}
	    		totalPaths = totalPaths + numberOfPaths(temp);
	    	}
	    	if(a.size()>1) {
	    		List<List<Integer>> temp = new ArrayList<>();
	    		temp = a.subList(1, a.size());
	    		totalPaths = totalPaths+numberOfPaths(temp);
	    	}
	    	return totalPaths;
	    }

	}

	public class Solution {
	    public static void main(String[] args) throws IOException {
	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("test.txt"));

	        int aRows = Integer.parseInt(bufferedReader.readLine().trim());
	        int aColumns = Integer.parseInt(bufferedReader.readLine().trim());

	        List<List<Integer>> a = new ArrayList<>();

	        IntStream.range(0, aRows).forEach(i -> {
	            try {
	                a.add(
	                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
	                        .map(Integer::parseInt)
	                        .collect(toList())
	                );
	            } catch (IOException ex) {
	                throw new RuntimeException(ex);
	            }
	        });

	        int result = Result.numberOfPaths(a);

	        bufferedWriter.write(String.valueOf(result));
	        bufferedWriter.newLine();

	        bufferedReader.close();
	        bufferedWriter.close();
	    }
	}
