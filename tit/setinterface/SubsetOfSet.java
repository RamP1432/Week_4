package com.tit.setinterface;

import java.util.*;

public class SubsetOfSet {
    public static void main(String[] args) {
        //Creating a set and Initialize with a list
        Set<Integer> set1=new HashSet<>(Arrays.asList(1,2,3));
        //Creating another set and Initializing with a list
        Set<Integer> set2=new HashSet<>(Arrays.asList(1,2,3));
        //calling method checkIsSubset for checking a set is a subset of another subset.
        boolean isSubset=checkIsSubset(set1,set2);
        System.out.println("Is Subset : "+isSubset);
    }
   // Method for checking if one set is or not a subset of another
    private static <T>boolean checkIsSubset(Set<T> set1, Set<T> set2) {
        boolean flag=true;
        for(T t: set2){
            if(!set1.contains(t)){
                flag=false;
                break;}
        }
        if(!flag){
            flag=true;
            for(T t: set1){
                if(!set2.contains(t)){
                    flag=false;
                    break;}
            }
        }
        return flag;
    }
}
