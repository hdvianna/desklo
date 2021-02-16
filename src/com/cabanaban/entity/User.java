package com.cabanaban.entity;

public class User {

    private String ID;

    private String name;

    private NationalID nationalID;

    private Phone phone;

    private EMail email;

    private int sla;
    
    public User(String name, NationalID nationalID, Phone phone, EMail email, int sla) {
        this.setName(name);
        this.setNationalID(nationalID);
        this.setPhone(phone);
        this.setEmail(email);
        this.setSla(sla);
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public NationalID getNationalID() {
        return nationalID;
    }

    public final void setNationalID(NationalID nationalID) {
        this.nationalID = nationalID;
    }

    public Phone getPhone() {
        return phone;
    }

    public final void setPhone(Phone phone) {
        this.phone = phone;
    }

    public EMail getEmail() {
        return email;
    }

    public final void setEmail(EMail email) {
        this.email = email;
    }

    public int getSla() {
        return sla;
    }

    public final void setSla(int sla) {
        this.sla = sla;
    }

    public boolean canAttendTicket(Ticket ticket) {
        return ticket != null && ticket.isServiceable();
    }

    public boolean canTransferTicket(Ticket ticket) {
        return ticket != null &&
                this.equals(ticket.getSupport()) &&
                ticket.isTransferable();
    }

    public boolean canCloseTicket(Ticket ticket) {
        return ticket != null &&
                this.equals(ticket.getSupport()) &&
                ticket.isCloseable();
    }
}
