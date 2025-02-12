package com.tit.setinterface;

import java.util.*;

public class SetToSortedList {
    public static void main(String[] args) {
        //Creating a set using TreeSet class
        Set<Integer> item=new TreeSet<>();
        item.add(12);
        item.add(15);
        item.add(10);
        item.add(25);
        item.add(5);
        item.add(0);
        //converting the set into a list
        List<Integer> list=new ArrayList<>(item);
        //Printing the list
        System.out.println(list);

    }
}
