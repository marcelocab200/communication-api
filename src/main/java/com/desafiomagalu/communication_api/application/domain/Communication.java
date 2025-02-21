package com.desafiomagalu.communication_api.application.domain;

import java.util.Date;

public class Communication {
    private Long id;
    private Date dateHour;
    private String recipient;
    private String message;
    private CommunicationType type;
    private CommunicationStatus status;
    
    public Communication(Long id, Date dateHour, String recipient, String message, CommunicationType type, CommunicationStatus status) {
        this.id = id;
        this.dateHour = dateHour;
        this.recipient = recipient;
        this.message = message;
        this.type = type;
        this.status = status;

    }

    // Getters 

    public Long getId() {
        return id;
    }

    public Date getDateHour() {
        return dateHour;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getMessage() {
        return message;
    }

    public CommunicationType getType() {
        return type;
    }

    public CommunicationStatus getStatus() {
        return status;
    }

    // Setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setDateHour(Date dateHour) {
        this.dateHour = dateHour;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setType(CommunicationType type) {
        this.type = type;
    }

    public void setStatus(CommunicationStatus status) {
        this.status = status;
    }
}
