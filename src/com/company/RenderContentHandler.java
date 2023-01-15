package com.company;

class RenderContentHandler extends ExistingContentCheckRequestHandler {
    public RenderContentHandler(ExistingContentCheckRequestHandler successor) {
        super(successor);
    }
    @Override
    public String handleRequest(WebRequest request) {
        if (request.getPath().equals("/dashboard")) {
            return "Status 200 : Dashboard content here";
        } else if (request.getPath().equals("/home")) {
            return "Status 200 : Home content here";
        }
        return "";
    }
}
