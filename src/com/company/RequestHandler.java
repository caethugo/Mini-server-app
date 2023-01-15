package com.company;
/* 1-a) */
abstract class RequestHandler {
    protected RequestHandler successor;

    public RequestHandler(RequestHandler successor) {
        this.successor = successor;
    }

    public abstract String handleRequest(WebRequest request);
}
