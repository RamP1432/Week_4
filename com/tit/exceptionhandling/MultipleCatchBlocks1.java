package com.tit.exceptionhandling;

public class MultipleCatchBlocks1 {

    // Method to print the value at a given index in an array
    public static void printIndexValue(int[] arr, int index) {
        // Check if the array is null and throw a NullPointerException if it is
        if (arr == null) {
            throw new NullPointerException("Array is null.");
        }
        // Check if the index is out of bounds and throw an ArrayIndexOutOfBoundsException
        if (index >= arr.length) {
            throw new ArrayIndexOutOfBoundsException("Please enter a valid index.");
        }
        // Print the value at the specified index
        System.out.println("Value at index " + index + " : " + arr[index]);
    }

    public static void main(String[] args) {
        // Initialize an array with values
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};

        try {
            // Attempt to access an index that is out of bounds
            printIndexValue(arr, 9);
        } catch (ArrayIndexOutOfBoundsException aie) {
            // Handle exception if index is out of bounds
            System.out.println(aie.getMessage());
        } catch (NullPointerException ne) {
            // Handle exception if the array is null
            System.out.println(ne.getMessage());
        }
    }
}
