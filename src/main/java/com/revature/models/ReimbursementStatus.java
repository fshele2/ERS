package com.revature.models;

public class ReimbursementStatus {

    private int Reimbursement_Status_id;

    private String Reimbursement_Status;

    public ReimbursementStatus() {
    }

    public ReimbursementStatus(int reimbursement_Status_id, String reimbursement_Status) {
       Reimbursement_Status_id = reimbursement_Status_id;
        Reimbursement_Status = reimbursement_Status;
    }

    public ReimbursementStatus(String reimbursement_Status) {
        Reimbursement_Status = reimbursement_Status;
    }

    public int getReimbursement_Status_id() {
        return Reimbursement_Status_id;
    }

    public void setReimbursement_Status_id(int reimbursement_Status_id) {
        Reimbursement_Status_id = reimbursement_Status_id;
    }

    public String getReimbursement_Status() {
        return Reimbursement_Status;
    }



    public void setReimbursement_Status(String reimbursement_Status) {
        Reimbursement_Status = reimbursement_Status;
    }

    @Override
    public String toString() {
        return "ReimbursementStatus{" +
                "Reimbursement_Status_id=" + Reimbursement_Status_id +
                ", Reimbursement_Status='" + Reimbursement_Status + '\'' +
                '}';
    }
}



