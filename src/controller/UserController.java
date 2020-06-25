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
            rsUser = this.dbService.getData("");
        } else {
            rsUser = this.dbService.getData("");
        }

        while (rsUser.next()) {

            Users u = new Users();

            RoleUser ru = new RoleUser();
            this.arrUser.add(u);
        }

        return this.arrUser;
    }

    public Users doLogin(Users user) {
        try {
            ResultSet rs = this.dbService.getData("SELECT * FROM FITRIARISQINA_07032.LOGIN_07032 WHERE USERNAME ='" + user.getUsername() + "' AND PASSWORD ='" + user.getPassword() + "'");
            System.out.println("LOGIN = " + this.dbService.getData("SELECT * FROM FITRIARISQINA_07032.LOGIN_07032 WHERE USERNAME ='" + user.getUsername() + "'"));
            rs.next();
            Users u = new Users();
            u.setIdUser(rs.getInt("id_user"));
            u.setUsername(rs.getString("username"));
            u.setPassword(rs.getString("password"));

            return user;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

}
