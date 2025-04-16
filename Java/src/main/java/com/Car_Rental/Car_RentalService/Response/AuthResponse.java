package com.Car_Rental.Car_RentalService.Response;

public class AuthResponse {
    private String jwt;
    private String msg;
public AuthResponse(){};
    public AuthResponse(String jwt, String msg) {
        this.jwt = jwt;
        this.msg = msg;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
