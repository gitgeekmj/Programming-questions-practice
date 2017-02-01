package com.program.part4;

public class Sort3 {
	public static void main(String[] args) {
		int[] A = {1,2,10,1,8,9};
		int[] B = {1,5,4,3,2,6,7};
		int[] C = {1,2,3,3,8,9};
		System.out.println(shortestSubsequence(C, 6));
	}
    public static int shortestSubsequence(int[] A, int n) {
    	int max = 0;
    	int min = n-1;
    	n = n - 2;
    	int right = 0;
    	int left = 0;
    	for(int i = 1; i < A.length; i++){
    		if(A[max] > A[i]){
    			right = i;
    		}else{
    			max = i;
    		}
    		if(A[min] < A[n]){
    			left = n;
    			n--;
    		}else{
    			min = n;
    			n--;
    		}
    	}
    	if(left == 0 && right == 0){
    		return 0;
    	}else{
    		return right - left + 1;
    	}
    }
}
