package com.program.part2;

public class DPTest2 {
	public static void main(String[] args) {
		System.out.println(countWays2(500));
		int res1 = countWays1(500);
		System.out.println(res1);
	}


    public static int countWays1(int n){
    	return res1(n);
    }
    public static int res1(int n){
        if(n ==1 ){
            return 1;
        }else if(n == 2){
            return 2;
        }else if(n <= 0){
            return 0;
        }
        return (res1(n-1)+res1(n-2))%1000000007;
    }
    
    public static int countWays2(int n){
    	if(n <= 0){
    		return 0;
    	}
    	if(n == 1 || n== 2){
    		return n;
    	}
    	int result = 0;
    	int temp1 = 1;
    	int temp2 = 2;
    	for(int i = 2; i < n; i++){
    		result = (temp1 +temp2)%1000000007;
    		temp1 = temp2;
    		temp2 = result;
    	}
    	return result;
    }
}
