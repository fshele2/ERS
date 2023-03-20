package com.revature.models;

public class Users {
    private int ERS_id;

    private String ERS_Username;

    private String ERS_Password;
    private String ERS_Firstname;

    private String ERS_Lastname;

    private UserRoles roles;

    private int Users_id_fk;

    public Users() {
    }

    public Users(int ERS_id, String ERS_Username, String ERS_Password, String ERS_Firstname, String ERS_Lastname, UserRoles roles) {
        this.ERS_id = ERS_id;
        this.ERS_Username = ERS_Username;
        this.ERS_Password = ERS_Password;
        this.ERS_Firstname = ERS_Firstname;
        this.ERS_Lastname = ERS_Lastname;
        this.roles = roles;
    }

    public Users(String ERS_Username, String ERS_Password, String ERS_Firstname, String ERS_Lastname, UserRoles roles) {
        this.ERS_Username = ERS_Username;
        this.ERS_Password = ERS_Password;
        this.ERS_Firstname = ERS_Firstname;
        this.ERS_Lastname = ERS_Lastname;
        this.roles = roles;
    }

    public Users(String ERS_Username, String ERS_Password, String ERS_Firstname, String ERS_Lastname, int users_id_fk) {
        this.ERS_Username = ERS_Username;
        this.ERS_Password = ERS_Password;
        this.ERS_Firstname = ERS_Firstname;
        this.ERS_Lastname = ERS_Lastname;
        Users_id_fk = users_id_fk;
    }

    public int getERS_id() {
        return ERS_id;
    }

    public void setERS_id(int ERS_id) {
        this.ERS_id = ERS_id;
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

    public String getERS_Firstname() {
        return ERS_Firstname;
    }

    public void setERS_Firstname(String ERS_Firstname) {
        this.ERS_Firstname = ERS_Firstname;
    }

    public String getERS_Lastname() {
        return ERS_Lastname;
    }

    public void setERS_Lastname(String ERS_Lastname) {
        this.ERS_Lastname = ERS_Lastname;
    }

    public UserRoles getRoles() {
        return roles;
    }

    public void setRoles(UserRoles roles) {
        this.roles = roles;
    }

    public int getUsers_id_fk() {
        return Users_id_fk;
    }

    public void setUsers_id_fk(int users_id_fk) {
        Users_id_fk = users_id_fk;
    }

    @Override
    public String toString() {
        return "Users{" +
                "ERS_id=" + ERS_id +
                ", ERS_Username='" + ERS_Username + '\'' +
                ", ERS_Password='" + ERS_Password + '\'' +
                ", ERS_Firstname='" + ERS_Firstname + '\'' +
                ", ERS_Lastname='" + ERS_Lastname + '\'' +
                ", roles=" + roles +
                '}';
    }
}


