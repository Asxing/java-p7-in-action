package com.holddie.design.pattern.p2structure.s06adapter.queue;

/**
 * 队列出栈
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/27 15:37
 */
public class QueueException extends RuntimeException{
    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public QueueException() {
        super();
    }

    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public QueueException(String message) {
        super(message);
    }
}
