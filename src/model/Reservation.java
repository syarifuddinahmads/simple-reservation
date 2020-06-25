/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author syarifuddin
 */
public class Reservation {
    private int idReservation;
    private String codeReservation;
    private Date dateReservation;
    private Date arrivalDate;
    private Date departureDate;
    private int longStay;
    private Date checkinDate;
    private Date checkoutDate;
    private int idCustomer;
    private int idRoom;
    private int reservationStatus;
    private int reservationType;
    private int checkinBy;
    private int checkoutBy;
    private int travelAgent;
    private ReservationStatus resStatus;
    private ReservationType resType;
    private Users userCheckinBy;
    private Users userCheckoutBy;
    private TravelAgent travelagent;
    private Customer customer;
    private Room room;

    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public String getCodeReservation() {
        return codeReservation;
    }

    public void setCodeReservation(String codeReservation) {
        this.codeReservation = codeReservation;
    }

    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public int getLongStay() {
        return longStay;
    }

    public void setLongStay(int longStay) {
        this.longStay = longStay;
    }

    public Date getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(Date checkinDate) {
        this.checkinDate = checkinDate;
    }

    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public int getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(int reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public int getReservationType() {
        return reservationType;
    }

    public void setReservationType(int reservationType) {
        this.reservationType = reservationType;
    }

    public int getCheckinBy() {
        return checkinBy;
    }

    public void setCheckinBy(int checkinBy) {
        this.checkinBy = checkinBy;
    }

    public int getCheckoutBy() {
        return checkoutBy;
    }

    public void setCheckoutBy(int checkoutBy) {
        this.checkoutBy = checkoutBy;
    }

    public int getTravelAgent() {
        return travelAgent;
    }

    public void setTravelAgent(int travelAgent) {
        this.travelAgent = travelAgent;
    }

    public ReservationStatus getResStatus() {
        return resStatus;
    }

    public void setResStatus(ReservationStatus resStatus) {
        this.resStatus = resStatus;
    }

    public ReservationType getResType() {
        return resType;
    }

    public void setResType(ReservationType resType) {
        this.resType = resType;
    }

    public Users getUserCheckinBy() {
        return userCheckinBy;
    }

    public void setUserCheckinBy(Users userCheckinBy) {
        this.userCheckinBy = userCheckinBy;
    }

    public Users getUserCheckoutBy() {
        return userCheckoutBy;
    }

    public void setUserCheckoutBy(Users userCheckoutBy) {
        this.userCheckoutBy = userCheckoutBy;
    }

    public TravelAgent getTravelagent() {
        return travelagent;
    }

    public void setTravelagent(TravelAgent travelagent) {
        this.travelagent = travelagent;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
    
    
    
}
