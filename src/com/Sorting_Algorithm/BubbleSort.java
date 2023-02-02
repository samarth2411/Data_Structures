package com.Sorting_Algorithm;
import java .util.*;

// Time Complexity --> O(n^2)
// Space Complexity --> O(1)
// ALGORITHM OF BUBBLE SORT --> works by repeatedly swapping the adjacent elements if they are in the wrong order.
public class BubbleSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the Array");
        int size = sc.nextInt();
        int[] array = new int[size];
        System.out.println("Enter the Elements in Array");
        for(int i=0;i<size;i++){
            array[i] = sc.nextInt();
        }
        System.out.println("Array Before Sorting");
        for(int b : array){
            System.out.print(b+" ");
        }
        System.out.println();
        for(int i=0;i<size-1;i++){
            for(int j=0;j<(size-i-1);j++){
                if(array[j]>array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        System.out.println("Array After Sorting");
        for(int a : array){
            System.out.print(a+" ");
        }
        System.out.println();

    }
}
