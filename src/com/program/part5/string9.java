package com.program.part5;

import java.util.HashMap;

public class string9 {
	public static void main(String[] args) {
		String str = "kojypxtmcheuvhpkqapldlkxkdbbouclkqwpnivxquwimbexyuqlipqpnlaklsqjnhcqspegqswpwinmvaokwbzylyrctfiscjuweakmmiaqsuanrfxhaffeuaauafqkeksjxgdpspkzzzsawuyvrdbgdqhrnkspldkkqfmlsofadojwfdikwpzsafacxoktpxkzmzzihljiqlsnbygkstydeflbgjrzrtxryfcntduaadqyzxmsrrxqbgldcvmtmqwyqgjtda";
		System.out.println(longestSubstring(str, 5));
	}
    public static int longestSubstring(String A, int n) {
        char[] ch = A.toCharArray();
        HashMap<String,Integer> hm = new HashMap<String,Integer>();
        int pre = 0;
        int max = 0;
        for(int i = 0; i < ch.length; i++){
        	if(hm.get(String.valueOf(ch[i])) == null){
        		hm.put(String.valueOf(ch[i]), i);
        		pre++;
        	}else{
        		max = Math.max(max,pre);
        		pre = i - hm.get(String.valueOf(ch[i])) > pre ? pre+1 : i - hm.get(String.valueOf(ch[i]));
        		hm.put(String.valueOf(ch[i]), i);
        	}
        }
        return Math.max(pre, max);
    }
}
