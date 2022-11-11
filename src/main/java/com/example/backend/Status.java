package com.example.backend;

public enum Status {
    OPEN, DOING, DONE;

    Status(String status) {
        this.status = status;
    }

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
