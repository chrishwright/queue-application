package com.wright.queue.exceptions;

/**
 * 
 * @author christopherwright
 *
 */
public class QueueIsFullException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 1788104365990180283L;
    
    public QueueIsFullException(String msg) {
        super(msg);
    }
}
