package com.Sorting_Algorithm;

import java.util.Scanner;

// Time Complexity --> O(n^2)
// Space Complexity --> O(1)

/*  ALGORITHM -->  The algorithm repeatedly selects the smallest (or largest) element from the unsorted portion of the list
                and swaps it with the first element of the unsorted portion.
 One variation of selection sort is called "Bidirectional selection" sort that goes through the list of elements
 by alternating between the smallest and largest element, this way the algorithm can be faster in some cases.

 The algorithm maintains two subarrays in a given array -:
                      The subarray which already sorted.
                      The remaining subarray was unsorted.
 After every iteration sorted subarray size increase by one and unsorted subarray size decrease by one. */

public class SelectionSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the Array");
        int size = sc.nextInt();
        int[] array = new int[size];
        System.out.println("Enter the Elements in Array");
        for (int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println("Array Before Sorting");
        for (int b : array) {
            System.out.print(b + " ");
        }
        System.out.println();
        System.out.println("-----------------------------");
        selectionSort(array);
        System.out.println("-----------------------------");
        System.out.println("Array After Sorting");
        for (int b : array) {
            System.out.print(b + " ");
        }


    }
    private static void selectionSort(int[] array){
        int n = array.length;
        for(int i=0;i<n-1;i++){
            int minIndex = i;
            for(int j=i+1;j<n;j++){
                if(isSmaller(array,j,minIndex)){
                    minIndex = j;
                }
            }
            swapElements(array,i,minIndex);
        }
    }

    private static void swapElements(int[] array, int i, int minIndex) {
        System.out.println("Swapping element at "+i+" "+"with element at "+minIndex);
        int temp = array[i];
        array[i] = array[minIndex];
        array[minIndex] = temp;

    }

    private static boolean isSmaller(int[] array, int j, int minIndex) {
        System.out.println("Comparing element at "+ array[j] + " "+ array[minIndex]);
        if(array[j]<=array[minIndex]){
            return true;
        }
        else{
            return false;
        }
    }
}
