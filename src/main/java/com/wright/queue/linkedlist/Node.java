package com.wright.queue.linkedlist;

/**
 * 
 * @author christopherwright
 *
 * @param <T>
 */
public class Node<T extends Comparable<T>> {
    
    private T data;
    private Node<T> nextNode;
    private Node<T> prevNode;
    
    public Node(T data) {
        this(data, null);
    }
    
    public Node(T data, Node<T> nextNode) {
        this(data, nextNode, null);
    }
    
    public Node(T data, Node<T> nextNode, Node<T> prevNode) {
        this.data = data;
        this.nextNode = nextNode;
        this.prevNode = prevNode;
    }
    
    public T getData() {
        return data;
    }
    
    public void setData(T data) {
        this.data = data;
    }
    
    public Node<T> getNextNode() {
        return nextNode;
    }
    
    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }
    
    public Node<T> getPrevNode() {
        return prevNode;
    }
    
    public void setPrevNode(Node<T> prevNode) {
        this.prevNode = prevNode;
    }
}
