package com.cabanaban.desklo.domain;

import com.cabanaban.entity.EMail;
import com.cabanaban.entity.NationalID;
import com.cabanaban.entity.Phone;

public class Support extends User {

    private double costPerHour;

    public Support(double costPerHour, String name, NationalID nationalID, Phone phone, EMail email, int sla) {
        super(name, nationalID, phone, email, sla);
        this.setCostPerHour(costPerHour);
    }

    public double getCostPerHour() {
        return costPerHour;
    }

    public final void setCostPerHour(double costPerHour) {
        this.costPerHour = costPerHour;
    }

    public void attendTicket(Ticket ticket) {
        ticket.setSupport(this);
        ticket.setStatus(Status.DOING);
    }

    public void transferTicket(Ticket ticket, int serviceTime, Support support) {
        ticket.addServiceTime(serviceTime);
        ticket.setSupport(support);
    }

    public void closeTicket(Ticket ticket, int serviceTime, String solution) {
        ticket.addServiceTime(serviceTime);
        ticket.setStatus(Status.DONE);
        ticket.setSolution(solution);
    }

}
