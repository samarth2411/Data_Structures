package com.PriorityQueue;

public class InPlaceHeapSort {

    public static void heapSort(int[] arr){
        int n = arr.length;
        // Building the heap firstly
        for(int i=n/2-1;i>=0;i--){ // as we have to perform downheapify only for the non leaf nodes
            downHeapify(arr,i,n);
        }
        // removing the element from starting one by one and putting them at respective last positions
        for(int i=n-1;i>=0;i--){
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            // after every exchange of elements process again build the heap and bring the min element in the start as it is minHeap
            downHeapify(arr,0,i);
        }


    }
    // DownHeapify Operation as done in minPriority Queue
    private static void downHeapify(int[] arr, int start, int end) {
        int parentIndex = start;
        int leftChildIndex = 2*parentIndex+1;
        int rightChildIndex = 2*parentIndex+2;
        int minIndex = parentIndex;

        while(leftChildIndex<end){
            if(arr[leftChildIndex] < arr[minIndex]){
                minIndex = leftChildIndex;
            }
            if(rightChildIndex < end && (arr[rightChildIndex] < arr[minIndex])){
                minIndex = rightChildIndex;
            }
            if(minIndex==parentIndex){
                return;
            }
            int temp = arr[parentIndex];
            arr[parentIndex] = arr[minIndex];
            arr[minIndex] = temp;
            parentIndex = minIndex;
            leftChildIndex = 2*parentIndex+1;
            rightChildIndex = 2*parentIndex+2;

        }

    }

    public static void main(String[] args) {
        int[] array = {4,7,5,2,1,8,9,6,3};
        heapSort(array);
        for(int i : array){
            // the given array will be sorted in decreasing order as it is a minHeap
            // if you want the array to be sorted in increasing order use maxHeap
            System.out.println(i);

        }
    }

}
