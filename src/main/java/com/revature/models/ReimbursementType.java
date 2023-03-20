package com.revature.models;

public class ReimbursementType {

    private int Reimbursement_Type_id;

    private String Reimbursement_Type;

    public ReimbursementType() {
    }

    public ReimbursementType(String reimbursement_Type) {
        Reimbursement_Type = reimbursement_Type;
    }

    public int getReimbursement_Type_id() {
        return Reimbursement_Type_id;
    }

    public void setReimbursement_Type_id(int reimbursement_Type_id) {
        Reimbursement_Type_id = reimbursement_Type_id;
    }

    public String getReimbursement_Type() {
        return Reimbursement_Type;
    }

    public void setReimbursement_Type(String reimbursement_Type) {
        Reimbursement_Type = reimbursement_Type;
    }

    public ReimbursementType(int reimbursement_Type_id, String reimbursement_Type) {
        Reimbursement_Type_id = reimbursement_Type_id;
        Reimbursement_Type = reimbursement_Type;



    }

    @Override
    public String toString() {
        return "ReimbursementType{" +
                "Reimbursement_Type_id=" + Reimbursement_Type_id +
                ", Reimbursement_Type='" + Reimbursement_Type + '\'' +
                '}';
    }
}
