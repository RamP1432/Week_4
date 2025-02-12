package com.tit.listinterface;

import java.util.*;

public class FindNthElement {
    public static void main(String[] args) {
        List<Integer> list=new LinkedList<>(Arrays.asList(12,13,14,15,16,17,18,19));
        int n=3;//Position of the element form end
        //calling findNthElementFromEnd method to find the element
        int nthElement=findNthElementFromEnd(list,n);
        //Printing the element
        System.out.println(n+"th Element in given list: "+nthElement);

    }

    private static <T>T findNthElementFromEnd(List<T> list, int n) {
        if(list==null || n<=0) return null;
        //Using the two-pointer approach
        var firstPointer=list.iterator();
        var secondPointer=list.iterator();
        for(int i=0;i<n;i++){
            if(firstPointer.hasNext())
                firstPointer.next();
            else
                return null;
        }
        while(firstPointer.hasNext()){
            firstPointer.next();
            secondPointer.next();
        }
        return secondPointer.next();
    }
}
