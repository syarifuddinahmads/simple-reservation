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
import model.Customer;

/**
 *
 * @author syarifuddin
 */
public class CustomerController {

    DatabaseService dbService;
    ArrayList<Customer> arrCustomer;

    public CustomerController() {

        this.dbService = new DatabaseService();
        this.arrCustomer = new ArrayList<>();

    }

    public ArrayList<Customer> getDataCustomer(Customer customer) throws SQLException {

        this.arrCustomer.clear();
        ResultSet sqlService;
        if (customer != null) {
            sqlService = this.dbService.getData("select * from customer where id_customer =" + customer.getIdCustomer());
        } else {
            sqlService = this.dbService.getData("select * from customer");
        }
        while (sqlService.next()) {
            Customer _customer = new Customer();
            _customer.setIdCustomer(sqlService.getInt("id_customer"));
            _customer.setName(sqlService.getString("name"));
            _customer.setEmail(sqlService.getString("email"));
            _customer.setAddress(sqlService.getString("address"));
            _customer.setPhoneNumber(sqlService.getString("phone_number"));
            _customer.setNik(sqlService.getString("nik"));

            this.arrCustomer.add(_customer);
        }

        return this.arrCustomer;

    }

    public void insertDataCustomer(Customer customer) {
        try {
            if (customer.getIdCustomer() > 0) {
                System.out.println("UPDATE CUSTOMER");
                this.dbService.postData("UPDATE SYARIFUDDIN_06989.CUSTOMER SET NAME='"+customer.getName()+"', EMAIL='"+customer.getEmail()+"', PHONE_NUMBER='"+customer.getPhoneNumber()+"', ADDRESS='"+customer.getAddress()+"', NIK='"+customer.getNik()+"', CREATED_AT='', MODIFIED_AT='' WHERE ID_CUSTOMER="+customer.getIdCustomer());
            } else {
                System.out.println("INSERT CUSTOMER");
                this.dbService.postData("INSERT INTO SYARIFUDDIN_06989.CUSTOMER(ID_CUSTOMER, NAME, EMAIL, PHONE_NUMBER, ADDRESS, NIK, CREATED_AT, MODIFIED_AT)VALUES(SEQ_CUSTOMER.NEXTVAL, '"+customer.getName()+"', '"+customer.getEmail()+"', '"+customer.getPhoneNumber()+"', '"+customer.getAddress()+"', '"+customer.getNik()+"', '', '')");
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    public void deleteDataCustomer(int idCustomer) {
        this.dbService.postData("DELETE FROM SYARIFUDDIN_06989.CUSTOMER WHERE ID_CUSTOMER=" + idCustomer);
    }

}
