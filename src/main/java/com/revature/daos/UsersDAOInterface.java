package com.revature.daos;

import com.revature.models.Users;

import java.util.ArrayList;

public interface UsersDAOInterface {


    Users getUsers(int id);

    Users insertUsers(Users use);

    Users deleteUsers(Users use);

    Users updateUsers(Users use);
















}
