package com.Sorting_Algorithm;

import java.util.Scanner;

// Time Complexity --> O(n log n)
// Space Complexity --> O(n)


/* ALGORITHM --> sorting algorithm that works by dividing an array into smaller subarrays,
               sorting each subarray, and then merging the sorted subarrays back together to form the final sorted array.
               It is also a stable sort, which means that the order of elements with equal values is preserved during the sort.
 Think of it as a recursive algorithm continuously splits the array in half until it cannot be further divided.
 This means that if the array becomes empty or has only one element left, the dividing will stop,i.e. it is the base case to stop the recursion.
 If the array has multiple elements, split the array into halves and recursively invoke the merge sort on each of the halves.
 Finally, when both halves are sorted, the merge operation is applied.
 Merge operation is the process of taking two smaller sorted arrays and combining them to eventually make a larger one. */

public class MergeSort {

    public static void main(String[] args){
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
        int[] a = mergeSort(array,0,size-1);
        System.out.println("Array After Sorting");
        for(int b : a){
            System.out.print(b+" ");
        }

    }
    private static int[] mergeSort(int[] array , int lo , int hi){
        if(lo==hi){
            int[] b = new int[1];
            b[0] = array[lo];
            return b;
        }
        int mi = (lo + ((hi-lo)/2));
        int[] fsh = mergeSort(array,lo,mi);
        int[] ssh = mergeSort(array,mi+1,hi);
        int[] ans = mergeTwoSortedArray(fsh , ssh);
        return ans;
    }
    private static int[] mergeTwoSortedArray(int[] arrayLeft , int[] arrayRight){
        int[] res = new int[arrayLeft.length + arrayRight.length];
        int firstPointer = 0;
        int secondPointer = 0;
        int resultPointer = 0;
        while(firstPointer < arrayLeft.length && secondPointer < arrayRight.length){
            if(arrayLeft[firstPointer]<arrayRight[secondPointer]){
                res[resultPointer] = arrayLeft[firstPointer];
                resultPointer++;
                firstPointer++;
            }
            else {
                res[resultPointer] = arrayRight[secondPointer];
                resultPointer++;
                secondPointer++;
            }
        }
        while(firstPointer < arrayLeft.length){
            res[resultPointer] = arrayLeft[firstPointer];
            resultPointer++;
            firstPointer++;
        }
        while(secondPointer < arrayRight.length){
            res[resultPointer] = arrayRight[secondPointer];
            resultPointer++;
            secondPointer++;
        }
        return res;
    }

}
