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
        arrCustomer=new ArrayList<>();
        
    }
    
    public ArrayList<Customer> getDataCustomer(Customer customer) throws SQLException{
        
        try {
            
            this.arrCustomer.clear();
            ResultSet sqlService;
            if(customer.getIdCustomer() != 0){
                sqlService = this.dbService.getData("select * from customer where id_customer ="+customer.getIdCustomer());
            }else{
                sqlService = this.dbService.getData("select * from customer");
            }
            while (sqlService.next()) {
                Customer _customer= new Customer();
                _customer.setIdCustomer(sqlService.getInt("id_customer"));
                _customer.setName(sqlService.getString("name"));
                _customer.setName(sqlService.getString("email"));
                _customer.setAddress(sqlService.getString("address"));
                _customer.setPhoneNumber(sqlService.getString("phone_number"));
                _customer.setNik(sqlService.getString("nik"));
                
                this.arrCustomer.add(_customer);
            }
            
            return this.arrCustomer;
            
        } catch (SQLException ex) {
            return null;
        }
        
    }
   
    
    public void insertDataCustomer(Customer customer){
        try{
            this.dbService.postData("insert into customer values(id_customer.nextval,"+customer.getName()+","+customer.getEmail()+","+customer.getPhoneNumber()+","+customer.getAddress()+","+customer.getName()+")");
            ResultSet sqlService = this.dbService.getData("select id_customer.currval from customer");
            sqlService.next();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }
    
    public void updateDataCustomer(Customer customer){
        this.dbService.postData("update customer set name =,"+customer.getName()+",email ="+customer.getEmail()+",phone_number="+customer.getPhoneNumber()+",address="+customer.getAddress()+",nik="+customer.getNik()+"where id_customer ="+customer.getIdCustomer());
    }
    
    public void deleteDataCustomer(Customer customer){
        this.dbService.postData("delete customer where id_customer ="+customer.getIdCustomer());
    }
    
    
    
}
