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
public class Address implements Serializable {

    private Coordinate coordinate;

    public Address() {
    }

    public Address(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

}
