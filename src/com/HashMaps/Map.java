package com.HashMaps;

import java.util.ArrayList;

public class Map<K,V> {

    ArrayList<MapNode<K,V>> buckets;  // map will have an array and every element of an array is a linked list i.e. we can say array of nodes
                                      // but in java we cannot make a generic array we have to specify the type of the array so we will use array list
                                     // and here we have to insert at an index so the initial size of the arraylist willbe 20 i.e. bucketsize = 20;

    int count;  // elements in list
    int numBuckets; // size of array list

    public Map(){
        buckets = new ArrayList<>();
        numBuckets = 20;
        for(int i =0;i<numBuckets;i++){
            buckets.add(null);  // setting the default values of each entry in the buckets to null
        }
    }

    private int getBucketIndex(K key){
        int hc = key.hashCode();  // internal fuction present in the object class
        int index = hc%numBuckets; // compression part
        return index;
    }
    public void insert(K key , V value){ // insert a key and its value
        int bucketIndex = getBucketIndex(key); // to insert the key we need to get the index at which we have to insert the key and value
        MapNode<K,V> head = buckets.get(bucketIndex); // head will be at this index

        // if element is already there ? just update its value
        while(head!=null){
            if(head.key.equals(key)){ // to compare the values we used .equals if we have to compare the address we have used ==
                head.value = value;
                return;
            }
            head = head.next;
        }

        // element is not there insert at 0th position of Linked List

        head = buckets.get(bucketIndex); // come back to the head again
        MapNode<K,V> newNode = new MapNode<>(key,value); // create a newNode with key and value
        newNode.next = head;
        buckets.set(bucketIndex,newNode); // seeting the newNode to the given bucketIndex
        count++; // increase the count as new element is inserted

        double loadFactor = (1.0*count)/numBuckets; // double / int gives double we need double value
        if(loadFactor > 0.7){
            reHash(); // rehash whenever load factor increase by 0.7
        }
    }

    private void reHash() {  // to maintain the load factor less than 0.7 always
        ArrayList<MapNode<K,V>> temp = buckets;  // old buckets is pointing to temp now
        buckets = new ArrayList<>(); // new bucket
        for (int i = 0; i < 2*numBuckets; i++) {
            buckets.add(null);
        }
        // note --> dont exactly copy the elements as the previous elements were placed according to the old bucket size
        // instead insert these elements again at the new bucket with bucket size increased by 2 times
        count = 0;
        numBuckets = numBuckets*2;
        for (int i = 0; i < temp.size(); i++) {
            MapNode<K,V> head = temp.get(i);
            while(head!=null){
                K key = head.key;
                V value = head.value;
                insert(key,value); // insert the given key and value as done before into the new buckets
                head = head.next;
            }
        }

    }

    public double loadFactor(){
        return (1.0*count)/numBuckets;
    }

    public int size(){
        return count;
    }

    public V getValue(K key){ // get the value at the particular key

        int bucketIndex = getBucketIndex(key); // getting the bucket index
        MapNode<K,V> head = buckets.get(bucketIndex); // getting to the head of that list present at that bucket index
        while(head!=null){
            if(head.key.equals(key)){
                return head.value;
            }
            head = head.next;
        }
        return null; // if key is not there
    }

    public V removeKey(K key){
        int bucketIndex = getBucketIndex(key); // find out the index
        MapNode<K,V> head = buckets.get(bucketIndex); // go to the head of the list present at that bucketindex
        MapNode<K,V> prev = null;

        while(head!=null){
            if(head.key.equals(key)) {
                if(prev!=null){
                    prev.next = head.next; // if prev is not null i.e. the key is not at the first index of the linkedlist
                                           // then just set prev next to the next of the element which is being deleted
                }
                else{
                    buckets.set(bucketIndex,head.next); // if the key is at the first index of the list only just move the index of that arraylist
                                                        // to the next of the head of the linked list present at that index
                }
                count--;
                return head.value;

            }
            prev = head;
            head = head.next;
        }

        return null;
    }

}
