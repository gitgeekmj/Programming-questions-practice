package com.program.part5;

import java.util.Arrays;
import java.util.Comparator;

public class string7 {
	public static void main(String[] args) {
		String[] str = {"b","a","v","r"};
		string7 string = new string7();
		System.out.println(string.findSmallest(str,4));
	}
    public String findSmallest(String[] strs, int n) {
        if(strs == null || n == 0){
        	return "";
        }
        Arrays.sort(strs,new myCompartor());
        String res = "";
        for(int i = 0; i < n; i++){
        	res += strs[i];
        }
        return res;
    }
    public class myCompartor implements Comparator<String>{
		@Override
		public int compare(String arg0, String arg1) {
			return (arg0 + arg1).compareTo(arg1 + arg0);
		}
    }
}
