package com.revature.daos;

import com.revature.models.ReimbursementStatus;
import com.revature.models.ReimbursementType;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReimbursementStatusDAO implements ReimbursementStatusDAOInterface {


    @Override
    public ReimbursementStatus getReimbursementStatusById(int id) {
        try (Connection conn = ConnectionUtil.getConnection()) {

            String sql = "select * from ERS_Reimbursment_Status where Reimbursment_Status_id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                ReimbursementStatus status = new ReimbursementStatus(
                        rs.getInt("Reimbursment_Status_id"),
                        rs.getString("Reimbursment_Status"));


                return status;

            }
        } catch (SQLException e) {
            e.printStackTrace(); //if something goes wrong, this will display an error message
            //VERY important for debugging, so we know what went wrong and where
        }


        return null;
    }
}
