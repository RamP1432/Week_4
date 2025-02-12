package com.tit.listinterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveDuplicates {
    public static <T>List<T> removeDuplicate(List<T> list){
        List<T> temp=new ArrayList<>();
        //storing unique element in temp list
        for(T item : list){
            if(!temp.contains(item)){
                temp.add(item);
            }
        }
        //returning new list with unique elements.
        return temp;
    }

    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>(Arrays.asList(1,1,1,2,2,3,3,4,5,6,7,8,8,8));
        System.out.println("List Before Removing Duplicate: "+list);
        //calling method removeDuplicates method for find unique elements
        list=removeDuplicate(list);
        System.out.println("List After Removing Duplicate: "+list);
    }
}
