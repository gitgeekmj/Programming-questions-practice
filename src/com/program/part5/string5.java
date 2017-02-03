package com.program.part5;

public class string5 {
	public static void main(String[] args) {
		String a = "TUM MKIALI KVJUBEN VBSEWFT JAD AIZWEL CP LG PTB";
		System.out.println(reverseSentence(a,47));
	}
    public static String reverseSentence(String A, int n) {
        char[] ch = A.toCharArray();
        String result = "";
        backward(ch,0,ch.length-1);
        int blank = 0;
        int i = 0;
        while(i < ch.length){
        	if(ch[i] == ' '){
        		backward(ch,blank,i-1);
        		blank = i+1;
        	}else if(i == ch.length-1){
        		backward(ch,blank,i);
        	}
        	i++;
        }
        for(int j = 0;j < ch.length; j++){
        	result += ch[j];
        }
        return result;
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
}
