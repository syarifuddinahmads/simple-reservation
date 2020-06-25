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
public class RoomType {
    private int idRoomType;
    private String nameRoomType;
    private int roomRate;
    private RoomRate roomrate;

    public int getIdRoomType() {
        return idRoomType;
    }

    public void setIdRoomType(int idRoomType) {
        this.idRoomType = idRoomType;
    }

    public String getNameRoomType() {
        return nameRoomType;
    }

    public void setNameRoomType(String nameRoomType) {
        this.nameRoomType = nameRoomType;
    }

    public int getRoomRate() {
        return roomRate;
    }

    public void setRoomRate(int roomRate) {
        this.roomRate = roomRate;
    }

    public RoomRate getRoomrate() {
        return roomrate;
    }

    public void setRoomrate(RoomRate roomrate) {
        this.roomrate = roomrate;
    }
    
    
}
