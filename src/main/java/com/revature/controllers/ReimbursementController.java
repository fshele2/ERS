package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.daos.ReimbursementDAO;
import com.revature.models.Reimbursement;
import io.javalin.http.Handler;

import java.util.ArrayList;

public class ReimbursementController {

    ReimbursementDAO reimDAO = new ReimbursementDAO();
    public Handler getReimbursementsByIdHandler = (ctx) -> {


        if (AuthController.ses != null) {
            //int ERSId = (Integer) AuthController.ses.getAttribute("ERSId");
            ArrayList<Reimbursement> Reimbursement = reimDAO.getReimbursementById();

            Gson gson = new Gson();

            String JSONReimbursements = gson.toJson(Reimbursement);

            ctx.result(JSONReimbursements);
            ctx.status(200);

        } else {
            ctx.result("YOU MUST LOG IN TO DO THIS");
            ctx.status(401); //401 "unauthorized"
        }

    };


    public Handler insertReimbursementHandler = (ctx) -> {

        String body = ctx.body();

        Gson gson = new Gson();

        Reimbursement newrem = gson.fromJson(body, Reimbursement.class);
        System.out.println(newrem.toString());

        if (reimDAO.insertReimbursement(newrem) != null) { //if insert was successful (which we set to return an Employee)
            ctx.status(201); //201 "created"
            ctx.result(body); //send back the employee
        } else {
            ctx.status(406); //406 "not acceptable"
            ctx.result("Please try again, Reimbursement amount and Description are required.");
        }

    };

    public Handler viewPendingReimbursement = (ctx) -> {

        if (AuthController.ses != null) {

            int userID = (Integer) AuthController.ses.getAttribute("userID");

            if (userID == 1) {

                ArrayList<Reimbursement> pending = reimDAO.viewPendingReimbursements(3);

                Gson gson = new Gson();

                String JSONUsers = gson.toJson(pending);

                ctx.result(JSONUsers);
                ctx.status(200);

            } else {
                ctx.status(406); //406 "not acceptable"
                ctx.result("Sorry,Only managers can view this");

            }
        } else {
            ctx.result("YOU MUST LOG IN TO DO THIS");
            ctx.status(401); //401 "unauthorized"
        }

    };


    public Handler updateSTATUS = (ctx) -> {
        if (AuthController.ses != null) {

            int roleID = (Integer) AuthController.ses.getAttribute("roleID");
            if (roleID == 1) {

                String ReimbursementId = ctx.pathParam("reimbursementId");
                String Reimbursement_Status = ctx.pathParam("reimbursementStatusId");
                System.out.println(Integer.parseInt(ReimbursementId));
                Reimbursement rem = reimDAO.getReimbursementById(Integer.parseInt(ReimbursementId));
                if (rem.getReimbursment_Status_id_fk() == 3) {
                    if (reimDAO.updateReimbursement(Integer.parseInt(ReimbursementId), Integer.parseInt(Reimbursement_Status))) {
                        ctx.result("Update successful");
                        ctx.status(202);
                    }
                    else {
                        ctx.result("Failed Update");
                        ctx.status(406);
                    }
                }
                else {
                    ctx.result("non pending status can not be changes");
                    ctx.status(401);
                }
            }
            else {
                ctx.result("only Managers allowed");
                ctx.status(401);
            }
        }
        else {
            ctx.result("Log in required");
            ctx.status(401);

        }
    };
}







