package com.program.part5;

public class string1 {
	public static void main(String[] args) {
		String str = "hello world";
		StringBuffer sb = new StringBuffer(str);
		System.out.println(replaceSpace(sb));
	}
    public static String replaceSpace(StringBuffer str) {
    	String a = str.toString();
    	char[] arr = a.toCharArray();
    	int k = 0;
    	for(int i = 0; i < arr.length; i++){
    		if(arr[i] == ' '){
    			k++;
    		}
    	}
    	char[] newArr = new char[arr.length+k*2];
    	int j = newArr.length - 1;
    	for(int i = arr.length - 1; i >= 0; i--){
    		if(arr[i] != ' '){
    			newArr[j] = arr[i];
    			j--;
    		}else{
    			newArr[j] = '0';
    			newArr[j-1] = '2';
    			newArr[j-2] = '%';
    			j = j - 3;
    		}
    	}
    	return new String(newArr);
    }
}
