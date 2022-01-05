package com.fleta.employee.dto;

public class Message {
    private Status status;
    private String message;
    private Object data;

    public Message(Status status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
