package com.wright.queue;

import com.wright.queue.linkedlist.Queue;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Queue<Integer> list = new Queue<>();
        
        list.enqueue(1);
        list.enqueue(2);
        list.enqueue(3);
        list.enqueue(4);
        
        list.printList();
        
        list.dequeue();
        
        list.printList();
    }
}
