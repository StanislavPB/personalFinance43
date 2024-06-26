package org.Backend.DTO;

public class ClientResponse <T>{
    private int responseCode;
    private T responseInfo;

    private String message;
    // запись данных произведена успешно
    // данные не найдены


    public ClientResponse(int responseCode, T responseInfo, String message) {
        this.responseCode = responseCode;
        this.responseInfo = responseInfo;
        this.message = message;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public T getResponseInfo() {
        return responseInfo;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ClientResponse{" +
                "responseCode=" + responseCode +
                ", responseInfo=" + responseInfo +
                ", message='" + message + '\'' +
                '}';
    }
}
