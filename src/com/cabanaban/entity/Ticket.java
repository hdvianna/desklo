package com.cabanaban.entity;

import java.util.Date;

public class Ticket {
    
    private final User user;

    private final String problem;

    private Status status;

    private Support support;

    private String solution;

    private Date openingDate;

    private long currentServiceTime;

    private double currentCost;

    private Date closeDate;

    public Ticket(User user, String problem) {
        this.currentCost = 0;
        this.user = user;
        this.problem = problem;
        this.status = Status.TODO;
    }
    
    public boolean isLate() {
        Date now = new Date();
        long totalTime = now.getTime() - openingDate.getTime();
        return totalTime >  (user.getSla() * 60 * 60 * 1000);
    }
    
    public void attend(Support support) {
        setSupport(support);
        setStatus(Status.DOING);
    }
    
    public void close(int serviceTime, String solution) {
        addServiceTime(serviceTime);
        setStatus(Status.DONE);
        setSolution(solution);
    }
    
    public void transfer(Support support, int serviceTime) {
        addServiceTime(serviceTime);
        setSupport(support);
    }

    public void addServiceTime(int serviceTime) {
        this.currentServiceTime += serviceTime;
        this.currentCost += (serviceTime * (support.getCostPerHour()/60));
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }

    public long getCurrentServiceTime() {
        return currentServiceTime;
    }

    public void setCurrentServiceTime(long currentServiceTime) {
        this.currentServiceTime = currentServiceTime;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public User getUser() {
        return user;
    }

    public String getProblem() {
        return problem;
    }

    public double getCurrentCost() {
        return currentCost;
    }


  
}
