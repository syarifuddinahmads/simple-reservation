/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author syarifuddin
 */
public class Users {
    
    private int idUser;
    private String nameUser;
    private String emailUser;
    private String username;
    private String addressUser;
    private int roleUser;
    private String password;
    private int nikUser;
    private RoleUser userRole;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddressUser() {
        return addressUser;
    }

    public void setAddressUser(String addressUser) {
        this.addressUser = addressUser;
    }

    public int getRoleUser() {
        return roleUser;
    }

    public void setRoleUser(int roleUser) {
        this.roleUser = roleUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNikUser() {
        return nikUser;
    }

    public void setNikUser(int nikUser) {
        this.nikUser = nikUser;
    }

    public RoleUser getUserRole() {
        return userRole;
    }

    public void setUserRole(RoleUser userRole) {
        this.userRole = userRole;
    }
    
    
    
}
