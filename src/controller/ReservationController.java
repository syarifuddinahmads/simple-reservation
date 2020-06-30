/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.Data;
import config.DatabaseService;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;
import model.Customer;
import model.Reservation;
import model.ReservationStatus;
import model.ReservationType;
import model.Room;
import model.TravelAgent;
import model.Users;

/**
 *
 * @author syarifuddin
 */
public class ReservationController {

    DatabaseService databaseService;
    ArrayList<Reservation> arrReservation;
    ArrayList<ReservationStatus> arrReservationStatus;
    ArrayList<ReservationType> arrReservationType;
    CustomerController customerController;
    UserController userController;
    TravelAgentController travelAgentController;
    RoomController roomController;

    public ReservationController() {
        this.databaseService = new DatabaseService();
        this.arrReservation = new ArrayList<>();
        this.arrReservationStatus = new ArrayList<>();
        this.arrReservationType = new ArrayList<>();
        this.customerController = new CustomerController();
        this.userController = new UserController();
        this.travelAgentController = new TravelAgentController();
        this.roomController = new RoomController();
    }

    public ArrayList<Reservation> getDataReservation(Reservation r) throws SQLException {
        this.arrReservation.clear();

        ResultSet rsRes;
        if (r != null) {
            System.out.println("============= " + r.getIdReservation() + r.getCodeReservation());
            rsRes = this.databaseService.getData("SELECT * FROM RESERVATION WHERE ID_RESERVATION =" + r.getIdReservation());
        } else {
            rsRes = this.databaseService.getData("SELECT * FROM RESERVATION");
        }

        while (rsRes.next()) {
            Reservation res = new Reservation();
            res.setIdReservation(rsRes.getInt("id_reservation"));
            res.setCodeReservation(rsRes.getString("code_reservation"));
            res.setDateReservation(rsRes.getDate("date_reservation"));
            res.setArrivalDate(rsRes.getDate("arrival_date"));
            res.setDepartureDate(rsRes.getDate("departure_date"));
            res.setLongStay(rsRes.getInt("long_stay"));
            res.setCheckinDate(rsRes.getDate("checkin_date"));
            res.setCheckoutDate(rsRes.getDate("checkout_date"));
            res.setCheckinBy(rsRes.getInt("checkin_by"));
            res.setCheckoutBy(rsRes.getInt("checkout_by"));
            res.setIdCustomer(rsRes.getInt("id_customer"));
            res.setReservationStatus(rsRes.getInt("reservation_status"));
            res.setReservationType(rsRes.getInt("reservation_type"));
            res.setTravelAgent(rsRes.getInt("travel_agent"));
            res.setIdRoom(rsRes.getInt("id_room"));

            Customer c = new Customer();
            c.setIdCustomer(res.getIdCustomer());
            Customer cust = this.customerController.getDataCustomer(c).get(0);
            res.setCustomer(cust);

            Users uci = new Users();
            uci.setIdUser(res.getCheckinBy());
            Users usci = this.userController.getDataUsers(uci).get(0);
            res.setUserCheckinBy(usci);

            Users uco = new Users();
            uco.setIdUser(res.getCheckoutBy());
            Users usco = this.userController.getDataUsers(uco).get(0);
            res.setUserCheckoutBy(usco);

            if (res.getTravelAgent() > 0) {
                TravelAgent rta = new TravelAgent();
                rta.setIdTravelAgent(res.getTravelAgent());
                TravelAgent ta = this.travelAgentController.getDataTravelAgent(rta).get(0);
                res.setTravelagent(ta);
            }

            Room ro = new Room();
            ro.setIdRoom(res.getIdRoom());
            Room room = this.roomController.getDataRoom(ro).get(0);
            res.setRoom(room);

            ReservationStatus rsStatus = new ReservationStatus();
            rsStatus.setIdReservationStatus(res.getReservationStatus());
            ReservationStatus rsstatus = this.getDataReservationStatus(rsStatus).get(0);
            res.setResStatus(rsstatus);

            ReservationType rsType = new ReservationType();
            rsType.setIdReseravationType(res.getReservationType());
            ReservationType rstype = this.getDataReservationType(rsType).get(0);
            res.setResType(rstype);

            this.arrReservation.add(res);
        }

        return this.arrReservation;
    }

    public ArrayList<ReservationStatus> getDataReservationStatus(ReservationStatus rs) throws SQLException {
        ResultSet rsRes;
        if (rs != null) {
            rsRes = this.databaseService.getData("SELECT * FROM RESERVATION_STATUS WHERE ID_RESERVATION_STATUS=" + rs.getIdReservationStatus());
        } else {
            rsRes = this.databaseService.getData("SELECT * FROM RESERVATION_STATUS");
        }

        while (rsRes.next()) {
            ReservationStatus rstatus = new ReservationStatus();
            rstatus.setIdReservationStatus(rsRes.getInt("id_reservation_status"));
            rstatus.setNameReservationStatus(rsRes.getString("name_reservation_status"));

            this.arrReservationStatus.add(rstatus);
        }

        return this.arrReservationStatus;
    }

    public ArrayList<ReservationType> getDataReservationType(ReservationType rt) throws SQLException {
        ResultSet rsRes;
        if (rt != null) {
            rsRes = this.databaseService.getData("SELECT * FROM RESERVATION_TYPE WHERE ID_RESERVATION_TYPE=" + rt.getIdReseravationType());
        } else {
            rsRes = this.databaseService.getData("SELECT * FROM RESERVATION_TYPE");
        }

        while (rsRes.next()) {
            ReservationType rstype = new ReservationType();
            rstype.setIdReseravationType(rsRes.getInt("id_reservation_type"));
            rstype.setNameReservationType(rsRes.getString("name_reservation_type"));

            this.arrReservationType.add(rstype);
        }

        return this.arrReservationType;
    }

    public void insertReservation(Reservation r) throws SQLException {
        String codeReservation = "RES-" + this.generateCode();
        this.customerController.insertDataCustomer(r.getCustomer());
        ResultSet customer = this.databaseService.getData("SELECT MAX(ID_CUSTOMER) AS ID_CUSTOMER FROM CUSTOMER");
        customer.next();
        int idCustomer = customer.getInt("id_customer");
        int idUserLogin = Data.userLogin.getIdUser();

        System.out.println("ARRIVAL BEFORE = " + r.getArrivalDate());
        String arrivalDate = new SimpleDateFormat("YYYY-MM-d HH:MM:SS").format(r.getArrivalDate());
        System.out.println("ARRIVAL AFTER = " + arrivalDate);

        System.out.println("ARRIVAL BEFORE = " + r.getDepartureDate());
        String departureDate = new SimpleDateFormat("YYYY-MM-d HH:MM:SS").format(r.getDepartureDate());
        System.out.println("ARRIVAL AFTER = " + departureDate);

        this.databaseService.postData("INSERT INTO SYARIFUDDIN_06989.RESERVATION VALUES(SEQ_RESERVATION.NEXTVAL, '" + codeReservation + "', 'TO_TIMESTAMP(" + arrivalDate + ", 'YYYY-MM-d HH:MM:SS')', 'TO_TIMESTAMP(" + arrivalDate + ", 'YYYY-MM-d HH:MM:SS')', 'TO_TIMESTAMP(" + departureDate + ", 'YYYY-MM-d HH:MM:SS')', " + r.getLongStay() + ", 'TO_TIMESTAMP(" + arrivalDate + ", 'YYYY-MM-d HH:MM:SS')', 'TO_TIMESTAMP(" + arrivalDate + ", 'YYYY-MM-d HH:MM:SS')', " + idCustomer + ", " + r.getIdRoom() + ", " + r.getReservationStatus() + ", " + r.getReservationType() + ", '" + idUserLogin + "', '" + idUserLogin + "', " + r.getTravelAgent() + ", 'TO_TIMESTAMP(" + arrivalDate + ", 'YYYY-MM-d HH:MM:SS')', 'TO_TIMESTAMP(" + arrivalDate + ", 'YYYY-MM-d HH:MM:SS')')");
    }

    private int generateCode() {
        Random r = new Random(System.currentTimeMillis());
        return 10000 + r.nextInt(20000);
    }

    public void deleteReservation(int idRes) {
        this.databaseService.postData("DELETE FROM SYARIFUDDIN_06989.RESERVATION WHERE ID_RESERVATION=" + idRes);
    }

}
