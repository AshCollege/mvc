package com.dev.Objects.Entities;

import com.dev.Objects.General.BaseEntity;

import java.util.Date;

public class Ticket extends BaseEntity {

    private String name;
    private int ticketNumber;
    private Date dateOfDraw;
    private int totalTicket;
    private float price;

    public Ticket() {
    }

    public Ticket(String name, int ticketNumber, Date dateOfDraw, int totalTicket, float price) {
        this.name = name;
        this.ticketNumber = ticketNumber;
        this.dateOfDraw = dateOfDraw;
        this.totalTicket = totalTicket;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public Date getDateOfDraw() {
        return dateOfDraw;
    }

    public void setDateOfDraw(Date dateOfDraw) {
        this.dateOfDraw = dateOfDraw;
    }

    public int getTotalTicket() {
        return totalTicket;
    }

    public void setTotalTicket(int totalTicket) {
        this.totalTicket = totalTicket;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
