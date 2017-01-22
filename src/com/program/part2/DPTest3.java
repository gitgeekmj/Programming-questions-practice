package com.program.part2;
/**
 * 
 * @author 杰
 * 最小路径和问题
 */
public class DPTest3 {
	public static void main(String[] args) {
		int[][] map = {{533,385,398,226},{59,529,215,203},{466,262,210,597},{32,359,616,194},{322,485,552,493}};
		System.out.println(getMin(map,5,4));
	}
    public static int getMin(int[][] map, int n, int m) {
        // write code here
    	if(map == null || n <= 0 || m <= 0){
    		return 0;
    	}
    	for(int i = 1; i < m ; i++){
    		map[0][i] = map[0][i-1] + map[0][i];
    	}
    	for(int i = 1; i < n ; i++){
    		map[i][0] = map[i-1][0] + map[i][0];
    	}
    	for(int i = 1; i < n ; i++){
    		for(int j = 1; j < m; j++){
    			map[i][j] += map[i][j-1] > map[i-1][j] ? map[i-1][j] : map[i][j-1];
    		}
    	}
    	return map[n-1][m-1];
    }
}
