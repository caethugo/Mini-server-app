package com.company;

import java.util.List;
import java.util.ArrayList; /*I will use a list and a array list in my process */

public class WebServer {
    private RequestHandler firstHandler;
    private List<WebRequestObserver> observers;
    
    public WebServer(PolicyCheckRequestHandler firstHandler) {
        this.firstHandler = firstHandler; /*1-e) */
        this.observers = new ArrayList<>(); /*2-a */
    }
    
    public String getRequest(WebRequest request) {
        String response = firstHandler.handleRequest(request);
        notifyObservers(request);
        return response;
    }
    
    public void registerObserver(WebRequestObserver observer) {
        observers.add(observer);
    }
    
    public void removeObserver(WebRequestObserver observer) {
        observers.remove(observer);
    }
    
    public void notifyObservers(WebRequest request) {
        for (WebRequestObserver observer : observers) {
            observer.update(request);
        }
    }
}
