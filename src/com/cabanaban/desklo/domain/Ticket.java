package com.cabanaban.desklo.domain;

import java.util.Date;

public class Ticket {

    private User user;

    private String problem;

    private Status status;

    private Support support;

    private String solution;

    private Date openingDate;

    private int currentServiceTime;

    private double currentCost;

    private Date closeDate;

    private int sla;


    public boolean isLate() {
        return false;
    }

    public void addServiceTime(int serviceTime) {

    }

    public void getCurrentCost() {

    }

    public int getDuration() {
        return 0;
    }

}
