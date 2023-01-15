package com.company;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List; //using lists also


public class FileLogger implements WebRequestObserver {
    String filePath;
    List<WebRequestObserver> observers;

    public FileLogger(String filePath) {
        this.filePath = filePath;
        try {
            Files.deleteIfExists(Paths.get(this.filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // This is for question 2-b (or not 2-b)
    @Override
    public void update(WebRequest request) {
        String logMessage = "Request made to " + request.getPath() + " by " + (request.getLoggedUser().isAdmin() ? "admin" : "non admin") + " user";
        log(logMessage);
    }

    public void registerObserver(WebRequestObserver observer) {
        this.observers.add(observer);
    }

    public void removeObserver(WebRequestObserver observer) {
        this.observers.remove(observer);
    }

    public void notifyObservers(WebRequest request) {
        for (WebRequestObserver observer : this.observers) {
            observer.update(request);
        }
    }

    public synchronized void log(String msg) {
        try {
            PrintWriter out = new PrintWriter(new FileOutputStream(this.filePath, true));
            out.println(msg);
            out.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}

