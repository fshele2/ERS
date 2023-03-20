package com.revature.daos;


import com.revature.models.UserRoles;
import com.revature.models.Users;
import com.revature.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;

public class UsersDAO implements UsersDAOInterface{
    @Override
    public Users getUsers(int id) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "select * from Ers_Users where ers_id = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();



            while(rs.next()){

                Users u = new Users(
                        rs.getInt("ERS_id"),
                        rs.getString("ERS_Username"),
                        rs.getString("ERS_Password"),
                        rs.getString("ERS_Firstname"),
                        rs.getString("ERS_Lastname"),
                        null);

                //noinspection SpellCheckingInspection
                int UserrolesFK = rs.getInt("Users_id_fk");

                UserRolesDAO rDAO = new UserRolesDAO();
                UserRoles r = rDAO.getUserRolesById(UserrolesFK);
                u.setRoles(r);


                return u;
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Users insertUsers(Users use) {
        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "INSERT INTO Ers_Users(ERS_Username, ERS_Password, ERS_Firstname,ERS_Lastname,Users_id_fk) " + "VALUES (? , ?, ?, ?, 2); ";
            ;
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, use.getERS_Username());
            ps.setString(2, use.getERS_Password());
            ps.setString(3, use.getERS_Firstname());
            ps.setString(4, use.getERS_Lastname());

            ps.executeUpdate();

            return use;
        }

               catch(SQLException e){
                e.printStackTrace(); //tell us what went wrong
            }


            return null;
    }

    @Override
    public Users deleteUsers(Users use) {

        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "delete from Ers_Users where ERS_Username = ?, ERS_Password = ?, ERS_Firstname = ?, ERS_Lastname =?, Users_id_fk =?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, use.getERS_Username());
            ps.setString(2, use.getERS_Password());
            ps.setString(3, use.getERS_Firstname());
            ps.setString(4, use.getERS_Lastname());
            ps.setInt(5,use.getUsers_id_fk());

            ps.executeUpdate();

            return use;
        }

        catch(SQLException e){
            e.printStackTrace(); //tell us what went wrong
        }


        return null;
    }

    @Override
    public Users updateUsers(Users use) {
        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "update Ers_Users set ERS_Username = ?,ERS_Password = ?,ERS_Firstname = ? ,ERS_Lastname = ?  where Users_id_fk =?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, use.getERS_Username());
            ps.setString(2, use.getERS_Password());
            ps.setString(3, use.getERS_Firstname());
            ps.setString(4, use.getERS_Lastname());
            ps.setInt(5,use.getUsers_id_fk());

            ps.executeUpdate();

            return use;
        }

        catch(SQLException e){
            e.printStackTrace(); //tell us what went wrong
        }

        return null;
    }
}
