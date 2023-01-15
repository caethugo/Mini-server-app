package com.company;
/* 1-b) */
class ExistingContentCheckRequestHandler extends PolicyCheckRequestHandler {
    public ExistingContentCheckRequestHandler(PolicyCheckRequestHandler successor) {
        super(successor);
    }
    @Override
    public String handleRequest(WebRequest request) {
        if (!request.getPath().equals("/dashboard") && !request.getPath().equals("/home")) {
            return "Status 404 : Page missing";
        } else {
            return successor.handleRequest(request);
        }
    }
}
