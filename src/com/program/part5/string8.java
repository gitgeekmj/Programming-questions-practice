package com.program.part5;

public class string8 {
    public boolean chkParenthesis(String A, int n) {
        if(A == null || n < 0){
        	return false;
        }
        char[] ch = A.toCharArray();
        int temp = 0;
        for(int i = 0; i < n; i++){
        	if(ch[i] != ')' && ch[i] != '('){
        		return false;
        	}else if(ch[i] == ')' && --temp < 0){
        		return false;
        	}else if(ch[i] == '('){
        		temp++;
        	}
        }
        return temp == 0;
    }
}
