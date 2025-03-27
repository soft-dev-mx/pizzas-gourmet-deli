package com.ampeliodev.pizzasgourmetdeliapirest.dto.dtoserverresponse;

public class DtoServerResponse {

    private String messageResponse;

    public DtoServerResponse() {
    }

    public DtoServerResponse(String messageResponse) {
        this.messageResponse = messageResponse;
    }

    public String getMessageResponse() {
        return messageResponse;
    }

    public void setMessageResponse(String messageResponse) {
        this.messageResponse = messageResponse;
    }
}
