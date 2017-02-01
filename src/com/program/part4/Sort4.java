package com.program.part4;

import java.util.Arrays;

public class Sort4 {
    public int maxGap(int[] A, int n) {
        Arrays.sort(A);
        int max = A[1] - A[0];
        for(int i = 0; i < n-1; i++){
        	max = max > A[i+1] - A[i] ? max : A[i+1] - A[i];
        }
        return max;
    }
}
