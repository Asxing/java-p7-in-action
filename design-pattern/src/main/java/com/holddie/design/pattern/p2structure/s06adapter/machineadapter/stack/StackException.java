package com.holddie.design.pattern.p2structure.s06adapter.machineadapter.stack;

/**
 * Stack异常处理
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/27 11:49
 */
public class StackException extends RuntimeException {

    /**
     * Constructs a new runtime exception with {@code null} as its detail message. The cause is not
     * initialized, and may subsequently be initialized by a call to {@link #initCause}.
     */
    public StackException() {
        super();
    }

    /**
     * Constructs a new runtime exception with the specified detail message. The cause is not
     * initialized, and may subsequently be initialized by a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for later retrieval by the
     *     {@link #getMessage()} method.
     */
    public StackException(String message) {
        super(message);
    }
}
