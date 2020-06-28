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
import model.Room;
import model.RoomRate;
import model.RoomType;

/**
 *
 * @author syarifuddin
 */
public class RoomController {

    private DatabaseService dbService;
    private ArrayList<RoomRate> arrRoomRate;
    private ArrayList<RoomType> arrRoomType;
    private ArrayList<Room> arrRoom;

    public RoomController() {
        this.dbService = new DatabaseService();
        this.arrRoomRate = new ArrayList<>();
        this.arrRoomType = new ArrayList<>();
        this.arrRoom = new ArrayList<>();
    }

    public ArrayList<RoomRate> getDataRoomRate(RoomRate rr) throws SQLException {
        this.arrRoomRate.clear();
        ResultSet rsRoomRate;
        if (rr != null) {
            rsRoomRate = this.dbService.getData("SELECT * FROM SYARIFUDDIN_06989.ROOM_RATE WHERE ID_ROOM_RATE=" + rr.getIdRoomRate());
        } else {
            rsRoomRate = this.dbService.getData("SELECT * FROM SYARIFUDDIN_06989.ROOM_RATE");
        }

        while (rsRoomRate.next()) {
            RoomRate rate = new RoomRate();
            rate.setIdRoomRate(rsRoomRate.getInt("ID_ROOM_RATE"));
            rate.setNameRoomRate(rsRoomRate.getString("NAME_ROOM_RATE"));
            rate.setPriceRoomRate(rsRoomRate.getDouble("PRICE_ROOM_RATE"));
            this.arrRoomRate.add(rate);
        }

        return this.arrRoomRate;
    }

    public ArrayList<RoomType> getDataRoomType(RoomType rt) throws SQLException {
        this.arrRoomType.clear();
        ResultSet rsRoomType;
        if (rt != null) {
            rsRoomType = this.dbService.getData("SELECT * FROM SYARIFUDDIN_06989.ROOM_TYPE JOIN ROOM_RATE ON ROOM_RATE.ID_ROOM_RATE = ROOM_TYPE.ROOM_RATE WHERE ROOM_TYPE.ID_ROOM_TYPE=" + rt.getIdRoomType());
        } else {
            rsRoomType = this.dbService.getData("SELECT * FROM SYARIFUDDIN_06989.ROOM_TYPE JOIN ROOM_RATE ON ROOM_RATE.ID_ROOM_RATE = ROOM_TYPE.ROOM_RATE");
        }

        while (rsRoomType.next()) {
            RoomType type = new RoomType();
            type.setIdRoomType(rsRoomType.getInt("ID_ROOM_TYPE"));
            type.setNameRoomType(rsRoomType.getString("NAME_ROOM_TYPE"));
            type.setRoomRate(rsRoomType.getInt("ROOM_RATE"));

            RoomRate rate = new RoomRate();
            rate.setIdRoomRate(rsRoomType.getInt("ID_ROOM_RATE"));
            rate.setNameRoomRate(rsRoomType.getString("NAME_ROOM_RATE"));
            rate.setPriceRoomRate(rsRoomType.getDouble("PRICE_ROOM_RATE"));

            type.setRoomrate(rate);
            this.arrRoomType.add(type);
        }

        return this.arrRoomType;
    }

    public ArrayList<RoomType> getDataRoomTypeByRate(int roomRate) throws SQLException {
        this.arrRoomType.clear();
        ResultSet rsRoomType = this.dbService.getData("SELECT * FROM SYARIFUDDIN_06989.ROOM_TYPE JOIN ROOM_RATE ON ROOM_RATE.ID_ROOM_RATE = ROOM_TYPE.ROOM_RATE WHERE ROOM_TYPE.ROOM_RATE=" + roomRate);

        while (rsRoomType.next()) {
            RoomType type = new RoomType();
            type.setIdRoomType(rsRoomType.getInt("ID_ROOM_TYPE"));
            type.setNameRoomType(rsRoomType.getString("NAME_ROOM_TYPE"));
            type.setRoomRate(rsRoomType.getInt("ROOM_RATE"));

            RoomRate rate = new RoomRate();
            rate.setIdRoomRate(rsRoomType.getInt("ID_ROOM_RATE"));
            rate.setNameRoomRate(rsRoomType.getString("NAME_ROOM_RATE"));
            rate.setPriceRoomRate(rsRoomType.getDouble("PRICE_ROOM_RATE"));

            type.setRoomrate(rate);
            this.arrRoomType.add(type);
        }

        return this.arrRoomType;
    }

    public ArrayList<Room> getDataRoom(Room r) throws SQLException {
        this.arrRoom.clear();
        ResultSet rsRoom;
        if (r != null) {
            rsRoom = this.dbService.getData("SELECT * FROM SYARIFUDDIN_06989.ROOM JOIN ROOM_TYPE ON ROOM_TYPE.ID_ROOM_TYPE = ROOM.ROOM_TYPE JOIN ROOM_RATE ON ROOM_RATE.ID_ROOM_RATE = ROOM_TYPE.ROOM_RATE WHERE ROOM.ID_ROOM=" + r.getIdRoom());
        } else {
            rsRoom = this.dbService.getData("SELECT * FROM SYARIFUDDIN_06989.ROOM JOIN ROOM_TYPE ON ROOM_TYPE.ID_ROOM_TYPE = ROOM.ROOM_TYPE JOIN ROOM_RATE ON ROOM_RATE.ID_ROOM_RATE = ROOM_TYPE.ROOM_RATE");
        }

        while (rsRoom.next()) {
            Room room = new Room();
            room.setIdRoom(rsRoom.getInt("ID_ROOM"));
            room.setRoomNumber(rsRoom.getInt("ROOM_NUMBER"));

            RoomType type = new RoomType();
            type.setIdRoomType(rsRoom.getInt("ID_ROOM_TYPE"));
            type.setNameRoomType(rsRoom.getString("NAME_ROOM_TYPE"));
            type.setRoomRate(rsRoom.getInt("ROOM_RATE"));

            RoomRate rate = new RoomRate();
            rate.setIdRoomRate(rsRoom.getInt("ID_ROOM_RATE"));
            rate.setNameRoomRate(rsRoom.getString("NAME_ROOM_RATE"));
            rate.setPriceRoomRate(rsRoom.getDouble("PRICE_ROOM_RATE"));

            type.setRoomrate(rate);

            room.setRoomtype(type);
            this.arrRoom.add(room);
        }

        return this.arrRoom;
    }

    public ArrayList<Room> getDataRoomByType(int roomType) throws SQLException {
        this.arrRoom.clear();
        ResultSet rsRoom = this.dbService.getData("SELECT * FROM SYARIFUDDIN_06989.ROOM JOIN ROOM_TYPE ON ROOM_TYPE.ID_ROOM_TYPE = ROOM.ROOM_TYPE JOIN ROOM_RATE ON ROOM_RATE.ID_ROOM_RATE = ROOM_TYPE.ROOM_RATE WHERE ROOM.ROOM_TYPE=" + roomType);

        while (rsRoom.next()) {
            Room room = new Room();
            room.setIdRoom(rsRoom.getInt("ID_ROOM"));
            room.setRoomNumber(rsRoom.getInt("ROOM_NUMBER"));

            RoomType type = new RoomType();
            type.setIdRoomType(rsRoom.getInt("ID_ROOM_TYPE"));
            type.setNameRoomType(rsRoom.getString("NAME_ROOM_TYPE"));
            type.setRoomRate(rsRoom.getInt("ROOM_RATE"));

            RoomRate rate = new RoomRate();
            rate.setIdRoomRate(rsRoom.getInt("ID_ROOM_RATE"));
            rate.setNameRoomRate(rsRoom.getString("NAME_ROOM_RATE"));
            rate.setPriceRoomRate(rsRoom.getDouble("PRICE_ROOM_RATE"));

            type.setRoomrate(rate);

            room.setRoomtype(type);
            this.arrRoom.add(room);
        }

        return this.arrRoom;
    }

    public void insertDataRoom(Room room) {
        try {
            if (room.getIdRoom() > 0) {
                System.out.println("UPDATE ROOM");
                this.dbService.postData("UPDATE SYARIFUDDIN_06989.ROOM SET ROOM_NUMBER=" + room.getRoomNumber() + ", ROOM_TYPE=" + room.getRoomType() + ", CREATED_AT='', MODIFIED_AT='' WHERE ID_ROOM=" + room.getIdRoom());
            } else {
                System.out.println("INSERT ROOM");
                this.dbService.postData("INSERT INTO SYARIFUDDIN_06989.ROOM VALUES(SEQ_ROOM.NEXTVAL, " + room.getRoomNumber() + ", " + room.getRoomType() + ", '', '')");
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    public void insertDataRoomType(RoomType roomType) {
        try {
            if (roomType.getIdRoomType() > 0) {
                System.out.println("UPDATE ROOM TYPE");
                this.dbService.postData("UPDATE SYARIFUDDIN_06989.ROOM_TYPE SET NAME_ROOM_TYPE='"+roomType.getNameRoomType()+"', ROOM_RATE="+roomType.getRoomRate()+", CREATED_AT='', MODIFIED_AT='' WHERE ID_ROOM_TYPE="+roomType.getIdRoomType());
            } else {
                System.out.println("INSERT ROOM TYPE");
                this.dbService.postData("INSERT INTO SYARIFUDDIN_06989.ROOM_TYPE VALUES(SEQ_ROOM_TYPE.NEXTVAL, '"+roomType.getNameRoomType()+"', "+roomType.getRoomRate()+", '', '')");
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    public void insertDataRoomRate(RoomRate roomRate) {
        try {
            if (roomRate.getIdRoomRate()> 0) {
                System.out.println("UPDATE ROOM RATE");
                this.dbService.postData("UPDATE SYARIFUDDIN_06989.ROOM_RATE SET NAME_ROOM_RATE='"+roomRate.getNameRoomRate()+"', PRICE_ROOM_RATE="+roomRate.getPriceRoomRate()+", CREATED_AT='', MODIFIED_AT='' WHERE ID_ROOM_RATE=" + roomRate.getIdRoomRate());
            } else {
                System.out.println("INSERT ROOM RATE");
                this.dbService.postData("INSERT INTO SYARIFUDDIN_06989.ROOM_RATE VALUES(SEQ_ROOM_RATE.NEXTVAL, '"+roomRate.getNameRoomRate()+"', "+roomRate.getPriceRoomRate()+", '', '')");
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    public void deleteRoom(int idRoom) {
        this.dbService.postData("DELETE FROM SYARIFUDDIN_06989.ROOM WHERE ID_ROOM=" + idRoom);
    }

    public void deleteRoomType(int idRoomType) {
        this.dbService.postData("DELETE FROM SYARIFUDDIN_06989.ROOM_TYPE WHERE ID_ROOM_TYPE=" + idRoomType);
    }

    public void deleteRoomRate(int idRoomRate) {
        this.dbService.postData("DELETE FROM SYARIFUDDIN_06989.ROOM_RATE WHERE ID_ROOM_RATE=" + idRoomRate);
    }

}
