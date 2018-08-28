package com.epam.tat.framework.runner;

public class CommonTestRuntimeException extends RuntimeException {
    public CommonTestRuntimeException(String message){super(message);}
    public CommonTestRuntimeException(String message,Throwable cause){super(message,cause);}
}
