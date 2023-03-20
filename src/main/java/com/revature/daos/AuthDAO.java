package com.revature.daos;

import com.revature.models.UserRoles;
import com.revature.models.Users;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthDAO {

    public Users register(String ERS_Firstname, String ERS_Lastname, String ERS_Username,String ERS_Password, int Users_id_fk){
        UsersDAO userDAO = new UsersDAO();
        Users newUser = new Users(ERS_Firstname,ERS_Lastname,ERS_Username,ERS_Password, Users_id_fk);

        Users registeredUser = userDAO.insertUsers(newUser);

        return registeredUser;
    }


    public Users login(String ERS_Username, String ERS_Password) {

        try (Connection conn = ConnectionUtil.getConnection()) {

            String sql = "select * from Ers_Users where ERS_Username = ? and ERS_Password = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, ERS_Username);
            ps.setString(2, ERS_Password);

            ResultSet rs = ps.executeQuery();


            if (rs.next()) {

                Users u = new Users(
                        rs.getInt("ERS_id"),
                        rs.getString("ERS_Username"),
                        rs.getString("ERS_Password"),
                        rs.getString("ERS_Firstname"),
                        rs.getString("ERS_Lastname"),
                        null);

                int UserrolesFK = rs.getInt("Users_id_fk");

                UserRolesDAO rDAO = new UserRolesDAO();
                UserRoles r = rDAO.getUserRolesById(UserrolesFK);
                u.setRoles(r);
                u.setUsers_id_fk(UserrolesFK);

                return u;

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }
}



