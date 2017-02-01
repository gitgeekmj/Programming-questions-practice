package com.program.part4;

public class Sort2 {
	public static void main(String[] args) {
		int[][] mat = {{109,204,260,270},{452,602,671,917},{1106,1343,1467,1585},{1627,1866,1948,1980},{2108,2164,2295,2577},{2681,2749,2915,3026},{3187,3250,3465,3518},{3562,3773,3966,4101}};
		System.out.println(findX(mat,8,4,2108));
	}
    public static boolean findX(int[][] mat, int n, int m, int x) {
        int r = 0;
    	while(r < n && m > 0){
        	if(mat[r][m-1] == x){
        		return true;
        	}else if(mat[r][m-1] > x){
        		m--;
        	}else if(mat[r][m-1] < x){
        		r++;
        	}
        }
        return false;
    }
    
}
