package com.PriorityQueue;

import java.util.ArrayList;

public class MinPriorityQueue<T> {

    private ArrayList<Element<T>> heap;

    public MinPriorityQueue(){
        heap = new ArrayList<>();
    }

    public void insert(T value , int priority){

        Element e = new Element(value,priority);
        heap.add(e); // adding the element to the arraylist at the last , to maintain the CBT(Complete Binary Tree) property
        int childIndex = heap.size()-1; // as priority queue is implemented using CBT so the index of the child will be the last index of the arraylist
        int parentIndex = childIndex-1/2; // parent index of the above child index

        // now we have to check the heap Order property ; i.e. in case of min heap every node priority should be lesser than its child priority
        // if parent priority is grater than the child priority than swap the nodes

        while(childIndex>0) { // repeat this process until you reach the first element or the parent priority becomes less than the child priority

            if(heap.get(parentIndex).priority > heap.get(childIndex).priority){
                Element<T> temp = heap.get(childIndex);
                heap.set(childIndex,heap.get(parentIndex));
                heap.set(parentIndex,temp);
                childIndex = parentIndex; // now the child is at the parent position as the priority of parnet was greater than the child priority
                parentIndex = childIndex-1/2; // new parent index
            }
            else{
                return; // the parent priority has become less than the child priority
            }

        }
    }
    public T getMin() throws PriorityQueueException {
        if(isEmpty()){
            throw new PriorityQueueException();
        }
        return heap.get(0).value;  //as it is a min priority queue so the min element will be at the start of the array list

    }
    public T removeMin() throws PriorityQueueException {

        if(isEmpty()){
            throw new PriorityQueueException();
        }
        Element<T> removed = heap.get(0);
        T ans = removed.value; // as it is a min heap so the element at the start of the arraylist will be min
        heap.set(0,heap.get(heap.size()-1));
        heap.remove(heap.size()-1);

        int parentIndex = 0;
        int leftChildIndex = 2*parentIndex+1;
        int rightChildIndex = 2*parentIndex+2;

        while(leftChildIndex<heap.size()){  // if we reach at the leafmost node or say at the last element

            int minIndex = parentIndex; // currently we are assuming that the min element is at the parent index;

            // we have to check both the left and right child priorities as any of the priority can be smaller
            if(heap.get(minIndex).priority > heap.get(leftChildIndex).priority){
                minIndex = leftChildIndex;
            }
            // what if there is no right child , so we have to add a corner case of when right child is not present
            if(rightChildIndex < heap.size() && (heap.get(minIndex).priority > heap.get(rightChildIndex).priority) ){
                minIndex = rightChildIndex;
            }
            // suppose already the parent index is smaller than we dont need to swap or we can say that if the minIndex still remains the same as parnetIndex
            if(minIndex==parentIndex){
                break;
            }

            Element<T> element= heap.get(minIndex);
            heap.set(minIndex,heap.get(parentIndex)); //setting the value of minIndex element to the parent element as element at min index was greater
            heap.set(parentIndex,element); // seeting the parentIndex element with the element at the min index as the parentIndex element was larger than its lef or right child
            parentIndex = minIndex;
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
