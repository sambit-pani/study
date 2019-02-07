package com.java.hackerrank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.*;
import static java.util.stream.Collectors.*;
import java.util.stream.IntStream;
import java.io.*;

public class HCL_Test {

	 public static void main(String[] args) throws IOException {
	       /* BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

	        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

	        List<String> arrTemp = new ArrayList<>();

	        IntStream.range(0, arrCount).forEach(i -> {
	            try {
	                arrTemp.add(bufferedReader.readLine().replaceAll("\\s+$", ""));
	            } catch (IOException ex) {
	                throw new RuntimeException(ex);
	            }
	        });

	        List<Integer> arr = arrTemp.stream()
	            .map(String::trim)
	            .map(Integer::parseInt)
	            .collect(toList());

	        int k = Integer.parseInt(bufferedReader.readLine().trim());

	        String res = findNumber(arr, k);

	        bufferedWriter.write(res);
	        bufferedWriter.newLine();

	        bufferedReader.close();
	        bufferedWriter.close();*/
		 	List< Integer> aa = Arrays.asList(12,51,12,4124,412,111);
		 	System.out.println(findNumber(aa, 1));
		 	System.out.println(oddNumbers(11, 9));
	    }
	 
	 static String findNumber(List<Integer> arr, int k) {
		 	return arr.parallelStream().anyMatch(i -> i==k)?"YES":"NO";
	       // return arr.contains(k)?"YES":"NO";
	    }
	 static List<Integer> oddNumbers(int l, int r) {
		 return IntStream.range(l, r+1).parallel().filter(i -> i%2==1).boxed().collect(toList());
		 //return null;
	    }
}
