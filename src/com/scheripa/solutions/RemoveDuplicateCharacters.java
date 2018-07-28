package com.scheripa.solutions;

public class RemoveDuplicateCharacters {

	private String removeDuplicates(String val) {
			
			int[] bit=new int [256];
			System.out.println("bit is ===>>"+bit.toString());
			String res = "";
			for (int i = 0; i < val.length(); i++) {
				System.out.println("bit value"+bit[0]);
				System.out.println("val.charAt(i)==="+val.charAt(i));
				
				if(bit[val.charAt(i)]==0){
				res+=(""+val.charAt(i));
				bit[val.charAt(i)]=1;
				}
			}
			return res;
			

	}

	public static void main(String[] args) {
		RemoveDuplicateCharacters removeDuplicates = new RemoveDuplicateCharacters();
		String output = removeDuplicates.removeDuplicates("geeksforgeeks");
		System.out.println("output=====>>>"+output);

	}

}
