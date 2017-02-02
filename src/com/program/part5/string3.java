package com.program.part5;

public class string3 {
	public static void main(String[] args) {
		String a = "abc";
		String b = "bcb";
		System.out.println(chkTransform(a,3,b,3));
	}
    public static boolean chkTransform(String A, int lena, String B, int lenb) {
        if(lena != lenb){
        	return false;
        }
        char[] chas1 = A.toCharArray();
        char[] chas2 = B.toCharArray();
        int[] map = new int[256];
        for (int i = 0; i < chas1.length; i++) {
            map[chas1[i]]++;
        }
        for (int i = 0; i < chas2.length; i++) {
            if (map[chas2[i]]-- == 0) {
                return false;
            }
        }
        return true;
    }
}
