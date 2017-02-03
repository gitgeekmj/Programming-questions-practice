package com.program.part5;

public class string4 {
	public static void main(String[] args) {
		String a = "cdab";
		String b = "abcd";
		System.out.println(chkRotation(a,4,b,4));
	}
    public static boolean chkRotation(String A, int lena, String B, int lenb) {
    	if(lena != lenb){
    		return false;
    	}
    	A = A + A;
        return A.contains(B);
    }
}
