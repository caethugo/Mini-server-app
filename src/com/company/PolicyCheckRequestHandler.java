package com.company;
class PolicyCheckRequestHandler extends RequestHandler {
    public PolicyCheckRequestHandler(RequestHandler successor) {
        super(successor);
    }
    @Override
    public String handleRequest(WebRequest request) {
        if (request.getPath().equals("/dashboard") && !request.getLoggedUser().isAdmin()) {
            return "Status 403 : user is not authorized to access this content";
        } else {
            return successor.handleRequest(request);
        }
    }
}
