package com.program.part8;

public class rank02 {
    public int[] getWays(int n, int a, int b) {
        int[] res = new int[2];
        int result = 1;
        for(int i = n; i > 0; i--){
        	result = result * i;
        	if(i == 1){
        		res[1] = result / n;
        	}
        }
        res[0] = result / 2;
        return res;
    }
}
