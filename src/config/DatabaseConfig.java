/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author syarifuddin
 */
public class DatabaseConfig {

    protected Connection connect;
    protected Statement db;
    
    public DatabaseConfig() {
        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Class Driver Ditemukan !");
            
            try {
                
                connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","syarifuddin_06989","udin");
                System.out.println("Koneksi Database Sukses !");
                
            } catch (SQLException ex) {
                
                System.out.println("Koneksi Database Gagal : "+ex);
                
            }
            
        } catch (ClassNotFoundException e) {
            
            System.out.println("Class Driver Tidak Ditemukan, Terjadi Kesalahan Pada : "+e);
        }
    }
    
    
    
}
