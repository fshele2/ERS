package com.revature.daos;

import com.revature.models.*;
import com.revature.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;

public class ReimbursementDAO implements ReimbursementDAOInterface {
    @Override
    public ArrayList<Reimbursement> getReimbursementById() {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "select * from ERS_Reimbursement;";

            Statement s = conn.createStatement();

            ResultSet rs = s.executeQuery(sql);

            ArrayList<Reimbursement> getReimbursementById = new ArrayList();

            while (rs.next()) {

                Reimbursement r = new Reimbursement(

                        rs.getInt("reimbursment_id"),
                        rs.getInt("reimbursment_amount"),
                        rs.getString("reimbursment_description"),
                        null,
                        null,
                        null
                );

                int useridfk = rs.getInt("ers_id_fk");

                UsersDAO UDAO = new UsersDAO();
                Users u = UDAO.getUsers(useridfk);
                r.setUser(u);


                int typefk = rs.getInt("Reimbursment_Type_id_fk");

                ReimbursementTypeDAO tDAO = new ReimbursementTypeDAO();
                ReimbursementType t = tDAO.getReimbursementTypeById(typefk);
                r.setRt(t);


                int statusid = rs.getInt("Reimbursment_Status_id_fk");

                ReimbursementStatusDAO sDAO = new ReimbursementStatusDAO();
                ReimbursementStatus g = sDAO.getReimbursementStatusById(statusid);
                r.setRs(g);

                getReimbursementById.add(r);
            }


            return getReimbursementById;

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }

    @Override
    public boolean updateReimbursement(int rId, int statusId) {
        try (Connection conn = ConnectionUtil.getConnection()) {

            String sql = "update ERS_Reimbursement" + " SET Reimbursment_Status_id_fk = ? " + "WHERE Reimbursment_id = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, statusId);
            ps.setInt(2,rId);

            //execute the update!
            ps.executeUpdate();

            return true;

        }

        catch (SQLException e){
            e.printStackTrace();
        }

        return false;
        }

    @Override
        public ArrayList<Reimbursement> viewPendingReimbursements(int statusId) {
            try (Connection conn = ConnectionUtil.getConnection()){
                String sql = "SELECT * FROM ERS_Reimbursement WHERE Reimbursment_Status_id_fk  = ?; ";
                PreparedStatement ps = conn.prepareStatement(sql);

                ps.setInt(1, statusId);

                ResultSet rs = ps.executeQuery();

                ArrayList<Reimbursement> viewPendingReimbursement = new ArrayList();

                while (rs.next()) {

                    Reimbursement r = new Reimbursement(

                            rs.getInt("reimbursment_id"),
                            rs.getInt("reimbursment_amount"),
                            rs.getString("reimbursment_description"),
                            null,
                            null,
                            null
                    );
                    int useridfk = rs.getInt("ers_id_fk");

                    UsersDAO UDAO = new UsersDAO();
                    Users u = UDAO.getUsers(useridfk);
                    r.setUser(u);

                    r.setERS_id_fk(useridfk);
                    int typefk = rs.getInt("Reimbursment_Type_id_fk");
                    ReimbursementTypeDAO tDAO = new ReimbursementTypeDAO();
                    ReimbursementType t = tDAO.getReimbursementTypeById(typefk);
                    r.setRt(t);

                    r.setReimbursment_Type_id_fk(typefk);
                    int statusid = rs.getInt("Reimbursment_Status_id_fk");
                    ReimbursementStatusDAO sDAO = new ReimbursementStatusDAO();
                    ReimbursementStatus g = sDAO.getReimbursementStatusById(statusid);
                    r.setRs(g);
                    r.setReimbursment_Status_id_fk(statusid);


                    viewPendingReimbursement.add(r);
                }
                return viewPendingReimbursement;

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;

        }

    @Override
    public Reimbursement insertReimbursement(Reimbursement remi) {
        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "insert into ERS_Reimbursement (Reimbursment_amount,Reimbursment_description,ERS_id_fk, Reimbursment_Type_id_fk, Reimbursment_Status_id_fk ) " +
                    "values (?, ?, ?,?,?);";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1,remi.getReimbursment_amount());
            ps.setString(2,remi.getReimbursment_description());
            ps.setInt(3,remi.getERS_id_fk());
            ps.setInt(4,remi.getReimbursment_Type_id_fk());
            ps.setInt(5,remi.getReimbursment_Status_id_fk());

            ps.executeUpdate();

            return remi;
        }

        catch(SQLException e){
            e.printStackTrace(); //tell us what went wrong
        }

        return null;
    }


    public Reimbursement getReimbursementById ( int id){
            try (Connection conn = ConnectionUtil.getConnection()) {

                String sql = "select * from ERS_Reimbursement where Reimbursment_id = ?;";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {

                    Reimbursement rem = new Reimbursement(
                            rs.getInt("reimbursment_id"),
                            rs.getInt("reimbursment_amount"),
                            rs.getString("reimbursment_description"),
                            null,
                            null,
                            null);

                    int useridfk = rs.getInt("ers_id_fk");

                    UsersDAO UDAO = new UsersDAO();
                    Users u = UDAO.getUsers(useridfk);
                    rem.setUser(u);

                    rem.setERS_id_fk(useridfk);
                    int typefk = rs.getInt("Reimbursment_Type_id_fk");
                    ReimbursementTypeDAO tDAO = new ReimbursementTypeDAO();
                    ReimbursementType t = tDAO.getReimbursementTypeById(typefk);
                    rem.setRt(t);

                    rem.setReimbursment_Type_id_fk(typefk);
                    int statusid = rs.getInt("Reimbursment_Status_id_fk");
                    ReimbursementStatusDAO sDAO = new ReimbursementStatusDAO();
                    ReimbursementStatus g = sDAO.getReimbursementStatusById(statusid);
                    rem.setRs(g);
                    rem.setReimbursment_Status_id_fk(statusid);

                    return rem;
                }
            } catch (SQLException e) {
                e.printStackTrace(); //if something goes wrong, this will display an error message
                //VERY important for debugging, so we know what went wrong and where
            }




            return null;
        }

}

