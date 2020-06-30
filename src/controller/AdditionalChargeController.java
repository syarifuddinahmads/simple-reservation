/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.DatabaseService;
import java.util.ArrayList;
import model.AdditionalCharge;

/**
 *
 * @author syarifuddin
 */
public class AdditionalChargeController {

    DatabaseService databaseService;
    ArrayList<AdditionalCharge> arrAddCharge;

    public AdditionalChargeController() {
        this.databaseService = new DatabaseService();
        this.arrAddCharge = new ArrayList<>();
    }
    
    public void insertAdditionalCharge(ArrayList<AdditionalCharge> additionalCharges){
        for (AdditionalCharge additionalCharge : additionalCharges) {
            this.databaseService.postData("INSERT INTO SYARIFUDDIN_06989.ADDITIONAL_CHARGE VALUES(SEQ_ADDITIONAL_CHARGE.NEXTVAL, '"+additionalCharge.getNameCharge()+"', "+additionalCharge.getAmountCharge()+", "+additionalCharge.getIdReservation()+", '', '')");
        }
    }

}
