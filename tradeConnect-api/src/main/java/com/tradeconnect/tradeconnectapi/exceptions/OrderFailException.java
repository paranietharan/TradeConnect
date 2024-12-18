package com.tradeconnect.tradeconnectapi.exceptions;

public class OrderFailException extends RuntimeException {
    public OrderFailException(String message) {
        super(message);
    }

    public OrderFailException(String message, Throwable cause) {
        super(message, cause);
    }
}
