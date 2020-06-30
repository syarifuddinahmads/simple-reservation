/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation;

import java.sql.SQLException;
import view.FormReservationView;
import view.LoginView;

/**
 *
 * @author syarifuddin
 */
public class Reservation {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        new LoginView().show();
    }

}
