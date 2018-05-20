package com.wright.queue.exceptions;

/**
 * 
 * @author christopherwright
 *
 */
public class EmptyQueueException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = -7522687698979470741L;

    public EmptyQueueException(String msg) {
        super(msg);
    }
    
}
