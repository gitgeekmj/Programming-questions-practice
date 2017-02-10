package com.program.part8;

public class rank01 {
	/**
	 * 走方格
	 * @param args
	 */
	public static void main(String[] args) {
		rank01 rank1 = new rank01();
		System.out.println(rank1.countWays2(9, 15));
		System.out.println(rank1.countWays(9, 15));
	}
    public int countWays(int x, int y) {
        int[][] map = new int[x][y];
        cWays(map,0,0);
        return map[x-1][y-1];
    }
    public void cWays(int[][] map,int i,int j){
    	if(i == map.length - 1 && j == map[0].length - 1){
    		map[i][j]++;
    		return;
    	}
    	if(j < map[0].length - 1){
    		cWays(map,i,j+1);
    	}
    	if(i < map.length - 1){
    		cWays(map,i+1,j);
    	}
    	return;
    }
    public int countWays2(int x,int y){
    	if(x <= 0 || y <= 0){
    		return 0;
    	}
    	x--;
    	y--;
    	int res = 1;
    	for(int i = x + y; i > y; i--){
    		res = res * i;
    	}
    	for(int j = 2; j <= x; j++){
    		res = res / j;
    	}
    	return res;
    }
}
