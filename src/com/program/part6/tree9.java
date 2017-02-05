package com.program.part6;

import java.util.ArrayList;

public class tree9 {
	/**
	 * 有关折纸
	 * @param args
	 */
	public static void main(String[] args) {
		tree9 tr = new tree9();
		tr.foldPaper(3);
	}
    public String[] foldPaper(int n) {
        ArrayList<String> arr = new ArrayList<String>();
        addList(0,n,arr,true);
        String[] str = new String[arr.size()];
        for(int i = 0; i < str.length; i++){
        	str[i] = arr.get(i);
        }
        return str;
    }
    public void addList(int i,int n,ArrayList<String> arr,boolean boo){
    	if(i >= n){
    		return;
    	}
    	addList(i+1,n,arr,true);
    	arr.add(boo ? "down" : "up");
    	addList(i+1,n,arr,false);
    }
}
