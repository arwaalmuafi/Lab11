package com.example.blogsystem.ApiResponse;



public class ApiResponse {
    public ApiResponse(String massage) {
        this.massage = massage;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    private String massage;
}
