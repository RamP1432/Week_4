package com.tit.setinterface;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CheckEqualityOfSet {
    //Method for checking sets are equal or not.
    public static <T>boolean checkEqualityOfSet(Set<T> set1, Set<T> set2){
        if(set1.size()!= set2.size()) return false;
        //Iterating the set1 and checking the availability of each element on set2
        for (T t : set1) {
            if (!set2.contains(t)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Set<Integer> set1=new HashSet<>(Arrays.asList(1,2,3,4,5,6));
        Set<Integer> set2=new HashSet<>(Arrays.asList(6,5,4,3,2,1));
         //output for set1 and set2 equality
        System.out.println("Both sets are equal: "+checkEqualityOfSet(set1,set2));


    }
}
