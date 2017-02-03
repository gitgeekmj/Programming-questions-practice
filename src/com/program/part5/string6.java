package com.program.part5;

public class string6 {
	public static void main(String[] args) {
		String A = "RJXJYA";
		System.out.println(stringTranslation1(A,6,1));
		System.out.println(stringTranslation2(A,6,1));
	}
    public static String stringTranslation1(String A, int n, int len) {
        if(A == null){
        	return null;
        }
    	char[] ch = A.toCharArray();
        backward(ch,0,n-1);
        backward(ch,0,n-len-1);
        backward(ch,n-len,n-1);
        A = "";
        for(int i = 0; i < ch.length; i++){
        	A += ch[i];
        }
        return A;
    }
    public static void backward(char[] arr, int begin, int end){
    	if(arr == null){
    		return;
    	}
    	while(begin != end){
    		char temp = arr[begin];
    		arr[begin] = arr[end];
    		arr[end] = temp;
    		begin++;
    		if(begin == end){
    			break;
    		}
    		end--;
    	}
    }
    public static String stringTranslation2(String A,int n,int len){
    	A = A + A;
    	char[] ch = A.toCharArray();
    	A = "";
    	for(int i = 0,j = len; i < n; i++,j++){
    		A += ch[j];
    	}
    	return A;
    }
}
