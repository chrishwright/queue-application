package com.wright.queue.linkedlist;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.wright.queue.exceptions.EmptyQueueException;
import com.wright.queue.exceptions.QueueIsFullException;

/**
 * 
 * @author christopherwright
 *
 */
public class Queue<T extends Comparable<T>> {
    
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
        else if (size >= 5) {
            throw new QueueIsFullException("The queue is full.");
        }
        
        Node<T> pointer = list;
        Node<T> prev = null;
        
        while (pointer != null) {
            
            if (pointer.getData().compareTo(data) < 0) {
                if (prev == null) {
                    addBefore(data, null, null);
                }
                else {
                    addBefore(data, prev, pointer); // here we pass in pointer to be set as next node
                }
                return;
            }
            
            prev = pointer;
            pointer = pointer.getNextNode();
        }
        
        addLast(prev, data);
    }
    
    /**
     * removes the first item from the queue.
     */
    public void dequeue() {
        if (size == 0) {
            throw new EmptyQueueException("The queue is empty.");
        }
        
        list = list.getNextNode();
        size--;
    }
    
    /**
     * 
     * @param newNode
     */
    public void addLast(Node<T> prev, T newValue) {
        final Node<T> tempNode = new Node<>(newValue);
        prev.setNextNode(tempNode);
        tempNode.setPrevNode(prev);
        tail = tempNode;
        size++;
    }
    
    /**
     * inserts the new item at the beginning of the list
     * @param data
     */
    public void addBefore(T data, Node<T> prev, Node<T> next) {
        final Node<T> temp = list; // maintain current list
        
        if (prev == null) {
            list = new Node<>(data, temp);
        }
        else {
            Node<T> newNode = new Node<>(data);
            prev.setNextNode(newNode);
            newNode.setPrevNode(prev);
            newNode.setNextNode(next);
        }
        size++;
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
    
    public List<T> getQueueAsList() {
        List<T> tempList = new ArrayList<>();
        Node<T> pointer = list;
        
        while (pointer != null) {
            tempList.add(pointer.getData());
            pointer = pointer.getNextNode();
        }
        
        return tempList;
    }
    
    /**
     * returns the first item in the list
     * @return the first item in the list
     */
    public T peek() {
        return list.getData();
    }
    
    /**
     * returns the item in the back of the list
     * @return the item in the back of the list
     */
    public T getBack() {
        return tail.getData();
    }
    
    /**
     * returns the size of the list
     * @return size of the list
     */
    public int getSize() {
        return size;
    }
}
