package com.revature.models;

public class UserRoles {

    private int Usersrole;
    private String User_role;

    public UserRoles() {
    }

    public UserRoles(int usersrole, String user_role) {
        Usersrole = usersrole;
        User_role = user_role;
    }


    public UserRoles(String user_role) {
        User_role = user_role;
    }

    public int getUsersrole() {
        return Usersrole;
    }

    public void setUsersrole(int usersrole) {
        Usersrole = usersrole;
    }

    public String getUser_role() {
        return User_role;
    }

    public void setUser_role(String user_role) {
        User_role = user_role;
    }

    @Override
    public String toString() {
        return "UserRoles{" +
                "Usersrole=" + Usersrole +
                ", User_role='" + User_role + '\'' +
                '}';
    }
}
