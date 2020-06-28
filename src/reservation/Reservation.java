/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation;

import java.sql.SQLException;
import view.CustomerView;
import view.LoginView;
import view.ReservationView;
import view.TravelAgenView;
import view.UserView;

/**
 *
 * @author syarifuddin
 */
public class Reservation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        new LoginView().show();
//        new ReservationView().show();
//        new CustomerView().show();
//        new TravelAgenView().show();
//        new UserView().show();
    }

}
