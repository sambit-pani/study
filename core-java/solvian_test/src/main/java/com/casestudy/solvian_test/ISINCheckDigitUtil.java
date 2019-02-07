package com.casestudy.solvian_test;

import java.util.Arrays;

import org.apache.commons.lang3.RandomStringUtils;

public class ISINCheckDigitUtil {

	public String getISIN() {
		String initialISIN = RandomStringUtils.randomAlphabetic(2).toUpperCase()
				+ RandomStringUtils.randomAlphanumeric(9);
		return getCheckDigit(initialISIN);
	}

	private String getCheckDigit(String isin) {
		/*
		 * String alphaNumeric = RandomStringUtils.randomAlphanumeric(9); String
		 * initialISIN = RandomStringUtils.randomAlphabetic(2).toUpperCase(); String
		 * isin = initialISIN + alphaNumeric;//isin= "DE123456789";
		 */
		String tempISIN = isin.toUpperCase();
		char[] charArray = tempISIN.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (char c : charArray) {
			if (Character.isLetter(c)) {
				sb.append(10 + c - 'A');
			} else {
				sb.append(c);
			}
		}
		tempISIN = new String(sb);

		/////////////////////
		String[] tempString = tempISIN.split("");
		StringBuilder ss = new StringBuilder();
		for (int i = tempString.length - 1; i >= 0; i--) {
			ss.append(Integer.parseInt(tempString[i]) * 2);
			if (i > 0)
				ss.append(tempString[--i]);
		}
		String aa = new String(ss);
		int total = Arrays.stream(aa.split("")).mapToInt(Integer::parseInt).sum();
		int num = total % 10 > 0 ? (total / 10) * 10 + 10 : total;
		return isin + (num - total);
	}

}
