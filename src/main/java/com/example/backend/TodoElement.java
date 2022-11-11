package com.example.backend;



public class TodoElement {

    String description;
    String status;
    int id;

    public TodoElement(String description, Status status, int id) {
        this.description = description;
        this.status = String.valueOf(status);
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
