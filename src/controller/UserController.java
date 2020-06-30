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
    private ArrayList<RoleUser> arrRole;

    public UserController() {
        this.dbService = new DatabaseService();
        this.arrUser = new ArrayList<>();
        this.arrRole = new ArrayList<>();
    }

    public ArrayList<Users> getDataUsers(Users user) throws SQLException {
        this.arrUser.clear();
        ResultSet rsUser;
        if (user != null) {
            rsUser = this.dbService.getData("SELECT * FROM SYARIFUDDIN_06989.USERS JOIN ROLE_USER ON ROLE_USER.ID_ROLE = USERS.ROLE_USER WHERE ID_USER=" + user.getIdUser());
        } else {
            rsUser = this.dbService.getData("SELECT * FROM SYARIFUDDIN_06989.USERS JOIN ROLE_USER ON ROLE_USER.ID_ROLE = USERS.ROLE_USER");
        }

        while (rsUser.next()) {
            Users u = new Users();
            u.setIdUser(rsUser.getInt("ID_USER"));
            u.setAddressUser(rsUser.getString("ADDRESS_USER"));
            u.setEmailUser(rsUser.getString("EMAIL_USER"));
            u.setNameUser(rsUser.getString("NAME_USER"));
            u.setNikUser(rsUser.getInt("NIK_USER"));
            u.setUsername(rsUser.getString("USERNAME"));
            RoleUser ru = new RoleUser();
            ru.setIdRole(rsUser.getInt("ID_ROLE"));
            ru.setNameRole(rsUser.getString("NAME_ROLE"));
            u.setUserRole(ru);
            this.arrUser.add(u);
        }

        return this.arrUser;
    }

    public ArrayList<RoleUser> getDataRole(RoleUser ru) throws SQLException {
        this.arrUser.clear();
        ResultSet rsRole;
        if (ru != null) {
            rsRole = this.dbService.getData("SELECT * FROM SYARIFUDDIN_06989.ROLE_USER WHERE ID_ROLE=" + ru.getIdRole());
        } else {
            rsRole = this.dbService.getData("SELECT * FROM SYARIFUDDIN_06989.ROLE_USER");
        }

        while (rsRole.next()) {
            RoleUser role = new RoleUser();
            role.setIdRole(rsRole.getInt("ID_ROLE"));
            role.setNameRole(rsRole.getString("NAME_ROLE"));
            this.arrRole.add(role);
        }

        return this.arrRole;
    }

    public void insertDataUser(Users us) {
        try {
            if (us.getIdUser() > 0) {
                System.out.println("UPDATE USER");
                this.dbService.postData("UPDATE SYARIFUDDIN_06989.USERS SET NAME_USER='"+us.getNameUser()+"', EMAIL_USER='"+us.getEmailUser()+"', USERNAME='"+us.getUsername()+"', ADDRESS_USER='"+us.getAddressUser()+"', ROLE_USER="+us.getRoleUser()+", CREATED_AT='', MODIFIED_AT='', PASSWORD='"+us.getPassword()+"', NIK_USER='"+us.getNikUser()+"' WHERE ID_USER=" + us.getIdUser());
            } else {
                System.out.println("INSERT USER");
                this.dbService.postData("INSERT INTO SYARIFUDDIN_06989.USERS(ID_USER, NAME_USER, EMAIL_USER, USERNAME, ADDRESS_USER, ROLE_USER, CREATED_AT, MODIFIED_AT, PASSWORD, NIK_USER) VALUES(SEQ_USER.NEXTVAL, '"+us.getNameUser()+"', '"+us.getEmailUser()+"', '"+us.getUsername()+"', '"+us.getAddressUser()+"', "+us.getRoleUser()+", '', '', '"+us.getPassword()+"', '"+us.getNikUser()+"')");
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }

    }
    
    public void insertDataRoleUser(RoleUser ru){
        try {
            if (ru.getIdRole() > 0) {
                System.out.println("UPDATE ROLE");
                this.dbService.postData("UPDATE SYARIFUDDIN_06989.ROLE_USER SET NAME_ROLE='"+ru.getNameRole()+"', CREATED_AT='', MODIFIED_AT='' WHERE ID_ROLE="+ru.getIdRole());
            } else {
                System.out.println("INSERT ROLE");
                this.dbService.postData("INSERT INTO SYARIFUDDIN_06989.ROLE_USER VALUES(SEQ_ROLE_USER.NEXTVAL, '"+ru.getNameRole()+"', '', '')");
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void deleteDataUser(int id) {
        this.dbService.postData("DELETE FROM SYARIFUDDIN_06989.USERS WHERE ID_USER=" + id);
    }
    
    public void deleteDataRoleUser(int id) {
        this.dbService.postData("DELETE FROM SYARIFUDDIN_06989.ROLE_USER WHERE ID_ROLE_USER=" + id);
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
