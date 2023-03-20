package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.daos.AuthDAO;
import com.revature.models.LoginDTO;
import com.revature.models.UserRoles;
import com.revature.models.Users;
import io.javalin.http.Handler;

import javax.servlet.http.HttpSession;

public class AuthController {


    AuthDAO aDAO = new AuthDAO();

    //empty HttpSession object that will be filled upon successful login
    public static HttpSession ses;
    public Handler loginHandler = (ctx) -> {

        String body = ctx.body();

        Gson gson = new Gson();

        //take the incoming data, instantiate a LoginDTO class
        LoginDTO lDTO = gson.fromJson(body, LoginDTO.class);

        Users loggedInEmployee = aDAO.login(lDTO.getERS_Username(), lDTO.getERS_Password());

        if (loggedInEmployee != null) {


            ses = ctx.req.getSession();

            ses.setAttribute("userID", loggedInEmployee.getERS_id());
            ses.setAttribute("roleID", loggedInEmployee.getUsers_id_fk());


            String userJSON = gson.toJson(loggedInEmployee);

            ctx.result(userJSON);
            ctx.status(202); //202 "accepted"
        } else {
            ctx.status(401); //401 "unauthorized"

        }
        ;
    };

    public Handler registerHandler = (ctx) -> {
        String body = ctx.body();

        Gson gson = new Gson();

        Users newUser = gson.fromJson(body, Users.class);

        if (aDAO.register(newUser.getERS_Firstname(), newUser.getERS_Lastname(), newUser.getERS_Username(), newUser.getERS_Password(), newUser.getUsers_id_fk())!= null){

            ctx.result(gson.toJson(newUser));
            ctx.status(202); //202 "accepted"
        } else {
            ctx.status(401); //401 "unauthorized"
            ctx.result("Username already exists, please try again.");
        }
    };

}









