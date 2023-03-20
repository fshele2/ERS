package com.revature.daos;

import com.revature.models.Reimbursement;

import java.util.ArrayList;

public interface ReimbursementDAOInterface {
    ArrayList<Reimbursement> getReimbursementById();

    boolean updateReimbursement(int rId, int statusId);

    ArrayList<Reimbursement> viewPendingReimbursements(int statusId);

    Reimbursement insertReimbursement(Reimbursement remi);

    Reimbursement getReimbursementById(int rid);





}
