/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author syarifuddin
 */
public class DatabaseService extends DatabaseConfig {

    public ResultSet getData(String sql) {
        try {

            db = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            return db.executeQuery(sql);

        } catch (SQLException e) {

            return null;

        }
    }

    public int postData(String sql) {
        try {

            db = connect.createStatement();
            return db.executeUpdate(sql);

        } catch (SQLException e) {

            return 0;
        }
    }

}
