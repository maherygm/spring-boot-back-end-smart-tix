package com.mahery.backendjavasmarttix.model;

public class Produitss {

    private String id ;
    private String name ;

    private long unitAmount ;

    private  String priceID;

    public String getPriceID() {
        return priceID;
    }

    public void setPriceID(String priceID) {
        this.priceID = priceID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getUnitAmount() {
        return unitAmount;
    }

    public void setUnitAmount(long unitAmount) {
        this.unitAmount = unitAmount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
