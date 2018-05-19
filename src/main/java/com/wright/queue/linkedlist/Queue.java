package com.wright.queue.linkedlist;

import java.util.EmptyStackException;

import org.apache.log4j.Logger;

/**
 * 
 * @author christopherwright
 *
 */
public class Queue<T> {
    
    /**
     * Logger
     */
    private static final Logger ms_log = Logger.getLogger(Queue.class.getName());
    
    private int size = 0;
    private Node<T> list = null;
    private Node<T> tail = null; // we need the tail to update the GUI with item at end of queue
    
    /**
     * adds a node to the back of the queue.
     * @param data - the generic data to add.
     */
    public void enqueue(T data) {
        if (size == 0) {
            list = new Node<>(data);
            tail = list;
            size++;
            return;
        }
        
        Node<T> pointer = list;
        
        while (pointer.getNextNode() != null) {
            pointer = pointer.getNextNode();
        }
        
        pointer.setNextNode(new Node<T>(data));
        tail = pointer.getNextNode();
        size++;
    }
    
    /**
     * removes the first item from the queue.
     */
    public void dequeue() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        
        list = list.getNextNode();
        size--;
    }
    
    /**
     * prints the list in the correct order.
     */
    public void printList() {
        Node<T> pointer = list;
        
        while (pointer != null) {
            ms_log.info(pointer.getData());
            pointer = pointer.getNextNode();
        }
    }
    
    public T peek() {
        return list.getData();
    }
    
    public T getBack() {
        return tail.getData();
    }
    
    public int getSize() {
        return size;
    }

}
