package com.revature.models;

public class LoginDTO {

    //variables that will hold the first name and last name. again, this should be username/password in your P1
    private String ERS_Username;
    private String ERS_Password;

    public LoginDTO(String ERS_Username, String ERS_Password) {
        this.ERS_Username = ERS_Username;
        this.ERS_Password = ERS_Password;
    }

    public String getERS_Username() {
        return ERS_Username;
    }

    public void setERS_Username(String ERS_Username) {
        this.ERS_Username = ERS_Username;
    }

    public String getERS_Password() {
        return ERS_Password;
    }

    public void setERS_Password(String ERS_Password) {
        this.ERS_Password = ERS_Password;
    }
}
