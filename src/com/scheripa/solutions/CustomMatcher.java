package com.scheripa.solutions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomMatcher {

	public static void main(String[] args) {

		String input = "smallphotourl";

		String output = "photoUrl";

		Pattern pattern = Pattern.compile(output.toLowerCase());
		Matcher matcher = pattern.matcher(input.toLowerCase());

//		while (matcher.find()) {
			System.out.println("found: " +matcher.find());
//		}else {
//			
//		}

	}

}
