package com.revature.daos;

import com.revature.models.ReimbursementType;
import com.revature.models.UserRoles;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReimbursementTypeDAO implements ReimbursementTypeDAOInterface{
    @Override
    public ReimbursementType getReimbursementTypeById(int id) {

        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "select * from ERS_Reimbursment_Type where Reimbursment_Type_id  = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){

                ReimbursementType type = new ReimbursementType(
                        rs.getInt("Reimbursment_Type_id"),
                        rs.getString("Reimbursment_Type"));


                return type;

            }
        } catch(SQLException e){
            e.printStackTrace(); //if something goes wrong, this will display an error message
            //VERY important for debugging, so we know what went wrong and where
        }



        return null;
    }
}
