/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taxicalls.ui.model;

import java.io.Serializable;

/**
 *
 * @author romulo
 */
public class Coordinate implements Serializable {

    private long longitude;
    private long latitude;

    public Coordinate() {
    }

    public Coordinate(long latitude, long longitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public long getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

}
