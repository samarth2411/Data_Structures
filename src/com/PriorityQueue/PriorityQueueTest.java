package com.PriorityQueue;

public class PriorityQueueTest {
    public static void main(String[] args) throws PriorityQueueException {
        MinPriorityQueue<String> q = new MinPriorityQueue<>();
        q.insert("abc",15);
        q.insert("def",30);
        q.insert("fafafa",90);
        q.insert("dsadadasd",150);
        q.insert("dlasmdfoawsk",120);

        while(!q.isEmpty()){
            System.out.print(q.getMin()+" ");
            q.removeMin();
        }

        System.out.println();

        MaxPriorityQueue<String> a = new MaxPriorityQueue<>();
        a.insert("abc",15);
        a.insert("def",30);
        a.insert("fafafa",90);
        a.insert("dsadadasd",150);
        a.insert("dlasmdfoawsk",120);

        while(!a.isEmpty()){
            System.out.print(a.getMax()+" ");
            a.removeMax();
        }

    }
}
