package com.example.lfuryk.marketplace.model;

public class MessageEvent {

    public final String mMessage;

    public MessageEvent(String message) {
        this.mMessage = message;
    }

    public String getMessage() {
        return this.mMessage;
    }
}
