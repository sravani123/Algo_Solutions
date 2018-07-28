package com.scheripa.solutions;

public class CheckUniqueString {
	
	private boolean checkUnique(String str){
		boolean[] char_set = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
			int  val = str.charAt(i) ;
			System.out.println("b value is "+val);
			System.out.println("char set  value is "+char_set[val]);

			if (char_set[val]) {
				return false;
			}
			 char_set[val] = true;
			
		}
		return true;
	}
	public static void main(String[] args) {
		CheckUniqueString check = new CheckUniqueString();
		check.checkUnique("Sravani");
		System.out.println("Hello"+check.checkUnique("Sravani"));
	}

}
