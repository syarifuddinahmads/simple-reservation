/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.DatabaseService;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.RoleUser;
import model.Users;

/**
 *
 * @author syarifuddin
 */
public class UserController {

    private DatabaseService dbService;
    private ArrayList<Users> arrUser;

    public UserController() {
        this.dbService = new DatabaseService();
        this.arrUser = new ArrayList<>();

    }

    public ArrayList<Users> getDataUsers(Users user) throws SQLException {
        this.arrUser.clear();
        ResultSet rsUser;
        if (user != null) {
            rsUser = this.dbService.getData("SELECT * FROM SYARIFUDDIN_06989.USERS WHERE ID_USER="+user.getIdUser());
        } else {
            rsUser = this.dbService.getData("SELECT * FROM SYARIFUDDIN_06989.USERS");
        }

        while (rsUser.next()) {

            Users u = new Users();
            u.setIdUser(rsUser.getInt("ID_USER"));
            u.setAddressUser(rsUser.getString(string));
            u.setEmailUser(rsUser.getString(string));
            u.setNameUser(rsUser.getString(string));
            u.setNikUser(rsUser.getInt(string));
            u.setUsername(rsUser.getString(string));
            RoleUser ru = new RoleUser();
            
            this.arrUser.add(u);
        }

        return this.arrUser;
    }

    public Users doLogin(Users user) {
        try {
            ResultSet rs = this.dbService.getData("SELECT * FROM USERS JOIN ROLE_USER ON ROLE_USER.ID_ROLE = USERS.ROLE_USER WHERE USERS.USERNAME ='" + user.getUsername() + "' AND USERS.PASSWORD ='" + user.getPassword() + "'");
            rs.next();
            Users u = new Users();
            u.setIdUser(rs.getInt("id_user"));
            u.setUsername(rs.getString("username"));
            u.setPassword(rs.getString("password"));
            u.setAddressUser(rs.getString("address_user"));
            u.setEmailUser(rs.getString("email_user"));
            u.setNameUser(rs.getString("name_user"));
            u.setNikUser(rs.getInt("nik_user"));
            u.setRoleUser(rs.getInt("id_role"));
            
            RoleUser ru = new RoleUser();
            ru.setIdRole(rs.getInt("id_role"));
            ru.setNameRole(rs.getString("name_role"));
            u.setUserRole(ru);

            return u;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

}
