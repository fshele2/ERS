package com.revature;

import com.revature.controllers.AuthController;
import com.revature.controllers.ReimbursementController;
import com.revature.daos.UserRolesDAO;
import com.revature.daos.UsersDAO;
import com.revature.models.Reimbursement;
import com.revature.utils.ConnectionUtil;
import io.javalin.Javalin;

import java.sql.Connection;
import java.sql.SQLException;

public class Launcher {
    public static void main(String[] args) {


        try (Connection conn = ConnectionUtil.getConnection()) {
            System.out.println("CONNECTION SUCCESSFUL :)");
        } catch (SQLException e) {
            System.out.println("Connection failed :(");
        }
        Javalin app = Javalin.create(
           javalinConfig -> {

               javalinConfig.enableCorsForAllOrigins();
           }

          ).start(3070);

        ReimbursementController rc = new ReimbursementController();
        AuthController ac = new AuthController();





        app.get("/reimbursement", rc.getReimbursementsByIdHandler);

        app.post("/login", ac.loginHandler);


        app.post("/insert", rc.insertReimbursementHandler);

        app.post("/pending", rc.viewPendingReimbursement);

        app.post("/register", ac.registerHandler);

        app.patch("/update/{reimbursementId}/{reimbursementStatusId}", rc.updateSTATUS);



        //UserRolesDAO m = new UserRolesDAO();
        //System.out.println(m.getUserRolesById(3));

        //UsersDAO n = new UsersDAO();
       // System.out.println(n.getUsers());



    }
}
