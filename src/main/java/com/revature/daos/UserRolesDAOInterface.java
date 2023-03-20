package com.revature.daos;

import com.revature.models.UserRoles;

public interface UserRolesDAOInterface {
    UserRoles getUserRolesById(int id);


    boolean updateUserRoles(String title);
}