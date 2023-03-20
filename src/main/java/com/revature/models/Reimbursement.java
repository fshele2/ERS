package com.revature.models;


public class Reimbursement {

    private int Reimbursment_id;
    private int Reimbursment_amount;
    private String Reimbursment_description;

    private Users user;
    private ReimbursementType rt;
    private ReimbursementStatus rs;

    private int ERS_id_fk;

    private int Reimbursment_Type_id_fk;

    private int Reimbursment_Status_id_fk;
    public Reimbursement(){

    }

    public Reimbursement(int reimbursment_id, int reimbursment_amount, String reimbursment_description, Users user, ReimbursementType rt, ReimbursementStatus rs) {
        Reimbursment_id = reimbursment_id;
        Reimbursment_amount = reimbursment_amount;
        Reimbursment_description = reimbursment_description;
        this.user = user;
        this.rt = rt;
        this.rs = rs;
    }

    public Reimbursement(int reimbursment_amount, String reimbursment_description, Users user, ReimbursementType rt, ReimbursementStatus rs) {
        Reimbursment_amount = reimbursment_amount;
        Reimbursment_description = reimbursment_description;
        this.user = user;
        this.rt = rt;
        this.rs = rs;
    }

    public Reimbursement(int reimbursment_amount, String reimbursment_description, int ERS_id_fk, int reimbursment_Status_id_fk, int reimbursment_Type_id_fk) {
        Reimbursment_amount = reimbursment_amount;
        Reimbursment_description = reimbursment_description;
        this.ERS_id_fk = ERS_id_fk;
        Reimbursment_Status_id_fk = reimbursment_Status_id_fk;
        Reimbursment_Type_id_fk = reimbursment_Type_id_fk;
    }

    public int getReimbursment_id() {
        return Reimbursment_id;
    }

    public void setReimbursment_id(int reimbursment_id) {
        Reimbursment_id = reimbursment_id;
    }

    public int getReimbursment_amount() {
        return Reimbursment_amount;
    }

    public void setReimbursment_amount(int reimbursment_amount) {
        Reimbursment_amount = reimbursment_amount;
    }

    public String getReimbursment_description() {
        return Reimbursment_description;
    }

    public void setReimbursment_description(String reimbursment_description) {
        Reimbursment_description = reimbursment_description;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public ReimbursementType getRt() {
        return rt;
    }

    public void setRt(ReimbursementType rt) {
        this.rt = rt;
    }

    public ReimbursementStatus getRs() {
        return rs;
    }

    public void setRs(ReimbursementStatus rs) {
        this.rs = rs;
    }

    public int getERS_id_fk() {
        return ERS_id_fk;
    }

    public void setERS_id_fk(int ERS_id_fk) {
        this.ERS_id_fk = ERS_id_fk;
    }

    public int getReimbursment_Status_id_fk() {
        return Reimbursment_Status_id_fk;
    }

    public void setReimbursment_Status_id_fk(int reimbursment_Status_id_fk) {
        Reimbursment_Status_id_fk = reimbursment_Status_id_fk;
    }

    public int getReimbursment_Type_id_fk() {
        return Reimbursment_Type_id_fk;
    }

    public void setReimbursment_Type_id_fk(int reimbursment_Type_id_fk) {
        Reimbursment_Type_id_fk = reimbursment_Type_id_fk;
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "Reimbursment_id=" + Reimbursment_id +
                ", Reimbursment_amount=" + Reimbursment_amount +
                ", Reimbursment_description='" + Reimbursment_description + '\'' +
                ", user=" + user +
                ", rt=" + rt +
                ", rs=" + rs +
                '}';
    }
}



