package com.example.backend;


import java.util.Objects;

public class TodoElement {

    String description;
    String status;
    String id;

    public TodoElement(String id, String description, String status)  {
        this.description = description;
        this.status = status;
        this.id = id;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
}
