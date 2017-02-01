package com.program.part4;

public class Sort1 {
	public static void main(String[] args) {
		int[] A = {1,2,0,2};
		sortThreeColor(A,4);
	}
	public static int[] sortThreeColor(int[] A,int n){
		int p0 = 0;
		int pn = n-1;
		int temp = 0;
		while(temp <= pn){
			if(A[temp] == 1){
				temp++;
			}else if(A[temp] == 0){
				A[temp] = A[p0];
				A[p0] = 0;
				p0++;
				temp++;
			}else if(A[temp] == 2){
				if(A[pn] == 2){
					pn--;
				}else if(temp < pn){
					A[temp] = A[pn];
					A[pn] = 2;
					pn--;
				}else {
					pn--;
				}
				
			}
		}
		return A;
	}
    public int[] sortThreeColor2(int[] A, int n) {
        // write code here
        int i=0;
        int j=0;
        int k=n-1;
        while(j<=k){
            if(A[j]==0){
                swap(A, j, i++);
                j++;
            }
            else if(A[j]==1){
                j++;
            }
            else{
                swap(A, j, k--);
            }
        }
        return A;
    }
    void  swap(int[] A,int m,int n){
        if(m!=n){
            int temp = A[m];
            A[m] = A[n];
            A[n] = temp;
        }
         
    }
}
