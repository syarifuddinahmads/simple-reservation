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
import model.TravelAgent;

/**
 *
 * @author syarifuddin
 */
public class TravelAgentController {

    DatabaseService dbService;
    ArrayList<TravelAgent> arrTravelAgent;

    public TravelAgentController() {

        this.dbService = new DatabaseService();
        this.arrTravelAgent = new ArrayList<>();

    }

    public ArrayList<TravelAgent> getDataTravelAgent(TravelAgent ta) throws SQLException {

        this.arrTravelAgent.clear();
        ResultSet sqlService;
        if (ta != null) {
            sqlService = this.dbService.getData("SELECT * FROM SYARIFUDDIN_06989.TRAVEL_AGENT WHERE ID_TRAVEL_AGENT=" + ta.getIdTravelAgent());
        } else {
            sqlService = this.dbService.getData("SELECT * FROM SYARIFUDDIN_06989.TRAVEL_AGENT");
        }
        while (sqlService.next()) {
            TravelAgent agent = new TravelAgent();
            agent.setIdTravelAgent(sqlService.getInt("ID_TRAVEL_AGENT"));
            agent.setCodeTravelAgent(sqlService.getString("CODE_TRAVEL_AGENT"));
            agent.setNameTravelAgent(sqlService.getString("NAME_TRAVEL_AGENT"));
            this.arrTravelAgent.add(agent);
        }

        return this.arrTravelAgent;

    }

    public void insertDataTravelAgent(TravelAgent ta) {
        try {
            if (ta.getIdTravelAgent() > 0) {
                System.out.println("UPDATE TRAVEL AGENT");
                this.dbService.postData("UPDATE SYARIFUDDIN_06989.TRAVEL_AGENT SET CODE_TRAVEL_AGENT='"+ta.getCodeTravelAgent()+"', NAME_TRAVEL_AGENT='"+ta.getNameTravelAgent()+"', CREATED_AT='', MODIFIED_AT='' WHERE ID_TRAVEL_AGENT="+ta.getIdTravelAgent());
            } else {
                System.out.println("INSERT TRAVEL AGENT");
                this.dbService.postData("INSERT INTO SYARIFUDDIN_06989.TRAVEL_AGENT(ID_TRAVEL_AGENT, CODE_TRAVEL_AGENT, NAME_TRAVEL_AGENT, CREATED_AT, MODIFIED_AT) VALUES(SEQ_TRAVEL_AGENT.NEXTVAL, '"+ta.getCodeTravelAgent()+"', '"+ta.getNameTravelAgent()+"', '', '')");
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    public void deleteDataTravelAgent(int id) {
        this.dbService.postData("DELETE FROM SYARIFUDDIN_06989.TRAVEL_AGENT WHERE ID_TRAVEL_AGENT=" + id);
    }
}
