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
public class AdditionalCharge {
    private int idAdditionalCharge;
    private String nameCharge;
    private Double amountCharge;
    private int idReservation;

    public int getIdAdditionalCharge() {
        return idAdditionalCharge;
    }

    public void setIdAdditionalCharge(int idAdditionalCharge) {
        this.idAdditionalCharge = idAdditionalCharge;
    }

    public String getNameCharge() {
        return nameCharge;
    }

    public void setNameCharge(String nameCharge) {
        this.nameCharge = nameCharge;
    }

    public Double getAmountCharge() {
        return amountCharge;
    }

    public void setAmountCharge(Double amountCharge) {
        this.amountCharge = amountCharge;
    }

    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }
      
    
}
