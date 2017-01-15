package com.program.part2;

/**
 * 
 * @author 杰
 * 动态规划经典题型：
 * 有数组penny，penny中所有的值都为正数且不重复。每个值代表一种面值的货币，每种面值的货币可以使用任意张，再给定一个整数aim(小于等于1000)代表要找的钱数，求换钱有多少种方法。
 * 给定数组penny及它的大小(小于等于50)，同时给定一个整数aim，请返回有多少种方法可以凑成aim。
 *
 */
public class DPTest1 {

	public static void main(String[] args) {
		int[] penny = new int[3];
		penny[0] = 1;
		penny[1] = 3;
		penny[2] = 6;
		int res = countWays(penny,3,13);
		System.out.println(res);
	}
	
    public static int countWays(int[] penny, int n, int aim) {
        // write code here
        if(penny == null || n <= 0 || aim < 0){
            return 0;
        }
        return res1(penny,0,aim);
    }
    /**
     * 
     * @param penny
     * @param index
     * @param aim
     * @return
     * 动态规划经典题型的暴力求解法
     */
    public static int res1(int[] penny,int index,int aim){
        int result = 0;
        result = aim == 0 ? 1 : 0;
        for(int i = 0; index < penny.length && penny[index]*i<=aim && aim > 0; i++){
            result+=res1(penny,index+1,aim-penny[index]*i);
        }
        return result;
    }
}
