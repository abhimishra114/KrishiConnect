package com.example.KrishiConnect.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PincodeResponse {

    @JsonProperty("Message")
    private String message;
    @JsonProperty("Status")
    private String status;
    @JsonProperty("PostOffice")
    private List<PostOffice> postOffices;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<PostOffice> getPostOffices() {
        return postOffices;
    }

    public void setPostOffices(List<PostOffice> postOffices) {
        this.postOffices = postOffices;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
