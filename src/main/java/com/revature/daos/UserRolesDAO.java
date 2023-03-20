package com.revature.daos;

import com.revature.models.UserRoles;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRolesDAO implements UserRolesDAOInterface {


    @Override
    public UserRoles getUserRolesById(int id) {
        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "select * from Ers_Users_Roles where Users_id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){

                UserRoles role = new UserRoles(
                        rs.getInt("Users_id"),
                        rs.getString("user_role"));


                return role;

            }
        } catch(SQLException e){
            e.printStackTrace(); //if something goes wrong, this will display an error message
            //VERY important for debugging, so we know what went wrong and where
        }


        return null;
    }

    @Override
    public boolean updateUserRoles(String user_role) {

        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "update Ers_Users_Roles set user_role = ? where Users_id = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);


            ps.setString(2,user_role);

            //execute the update!
            ps.executeUpdate();


            return true;

        }

        catch (SQLException e){
            e.printStackTrace();
        }




        return false;
    }
}
