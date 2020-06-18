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
public class ReservationPayment {
    private int idReservationPayment;
    private int idReservation;
    private int paymentType;
    private int paymentStatus;
    private Double amountPayment;
    private Double amountAdditionalCharge;
    private Double grandTotalPayment;
    private Date datePayment;
    private int createdBy;
    private int modifiedBy;

    public int getIdReservationPayment() {
        return idReservationPayment;
    }

    public void setIdReservationPayment(int idReservationPayment) {
        this.idReservationPayment = idReservationPayment;
    }

    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public int getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(int paymentType) {
        this.paymentType = paymentType;
    }

    public int getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(int paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Double getAmountPayment() {
        return amountPayment;
    }

    public void setAmountPayment(Double amountPayment) {
        this.amountPayment = amountPayment;
    }

    public Double getAmountAdditionalCharge() {
        return amountAdditionalCharge;
    }

    public void setAmountAdditionalCharge(Double amountAdditionalCharge) {
        this.amountAdditionalCharge = amountAdditionalCharge;
    }

    public Double getGrandTotalPayment() {
        return grandTotalPayment;
    }

    public void setGrandTotalPayment(Double grandTotalPayment) {
        this.grandTotalPayment = grandTotalPayment;
    }

    public Date getDatePayment() {
        return datePayment;
    }

    public void setDatePayment(Date datePayment) {
        this.datePayment = datePayment;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public int getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(int modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
    
    
}
