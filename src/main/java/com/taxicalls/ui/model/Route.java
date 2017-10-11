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
public class Route implements Serializable {

    private Integer id;
    private Address addressFrom;
    private Address addressTo;

    public Route(Address addressFrom, Address addressTo) {
        this.addressFrom = addressFrom;
        this.addressTo = addressTo;
    }

    public Route() {
    }

    public Route(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Address getAddressFrom() {
        return addressFrom;
    }

    public Address getAddressTo() {
        return addressTo;
    }

    public void setAddressFrom(Address addressFrom) {
        this.addressFrom = addressFrom;
    }

    public void setAddressTo(Address addressTo) {
        this.addressTo = addressTo;
    }

}
