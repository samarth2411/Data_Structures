package com.PriorityQueue;

import java.util.ArrayList;

public class MaxPriorityQueue<T> {

    private ArrayList<Element<T>> heap;

    public MaxPriorityQueue(){
        heap = new ArrayList<>();
    }

    public void insert(T value,int priority){
        Element e = new Element(value,priority);
        heap.add(e); // adding the element to the arraylist at the last , to maintain the CBT(Complete Binary Tree) property
        int childIndex = heap.size()-1; // as priority queue is implemented using CBT so the index of the child will be the last index of the arraylist
        int parentIndex = (childIndex-1)/2;

        // now we have to check the heap Order property ; i.e. in case of min heap every node priority should be lesser than its child priority
        // if parent priority is grater than the child priority than swap the nodes
       while(childIndex>0) {
           if (heap.get(parentIndex).priority < heap.get(childIndex).priority) {
               Element<T> temp = heap.get(childIndex);
               heap.set(childIndex, heap.get(parentIndex));
               heap.set(parentIndex, temp);

               childIndex = parentIndex;    // now the child is at the parent position as the priority of parent was greater than the child priority
               parentIndex = (childIndex - 1) / 2;  // new parent index
           } else {
               return; // the parent priority has become more than the child priority
           }
       }
    }

    public T getMax() throws PriorityQueueException {
        if(isEmpty()){
            throw new PriorityQueueException();
        }
        return heap.get(0).value;
    }

    public T removeMax() throws PriorityQueueException {
        if(heap.isEmpty()){
            throw new PriorityQueueException();
        }
        Element<T> e = heap.get(0);
        T ans = e.value;
        heap.set(0,heap.get(heap.size()-1));
        heap.remove(heap.size()-1);

        int parentIndex = 0;
        int leftChildIndex = 2*parentIndex+1;
        int rightChildIndex = 2*parentIndex+2;
        while(leftChildIndex < heap.size()){
            int maxIndex = parentIndex;
            if(heap.get(maxIndex).priority<heap.get(leftChildIndex).priority){
                maxIndex = leftChildIndex;
            }
            if(rightChildIndex< heap.size() && heap.get(maxIndex).priority < heap.get(rightChildIndex).priority){
                maxIndex = rightChildIndex;
            }
            if(maxIndex==parentIndex){
                break;
            }

            Element<T> element = heap.get(maxIndex);
            heap.set(maxIndex,heap.get(parentIndex));
            heap.set(parentIndex,element);
            parentIndex = maxIndex;
            leftChildIndex = 2*parentIndex+1;
            rightChildIndex = 2*parentIndex+2;
        }
        return ans;
    }

    public int size(){
        return heap.size();
    }
    public boolean isEmpty(){
        return size()==0;
    }
}
