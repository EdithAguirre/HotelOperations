/*
The Reservation class is responsible for storing information related to a guest stay
 */
package com.pluralsight;

public class Reservation {
    // Data fields
    private String roomType;
    private double price;
    private int numberOfNights;
    private boolean isWeekend;

    // Constructor
    public Reservation(String roomType, double price, int numberOfNights, boolean isWeekend) {
        this.roomType = roomType;
        this.price = price;
        this.numberOfNights = numberOfNights;
        this.isWeekend = isWeekend;
    }

    // Getters and Setters
    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getPrice() {
        if(roomType.equalsIgnoreCase("king")){
            this.price = 139.00;
        }
        else if(roomType.equalsIgnoreCase("double")){
            this.price = 124.00;
        }
        if(isWeekend()){
            this.price += (price * 0.10);
        }
        return price;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public boolean isWeekend(){
        return isWeekend;
    }

    public void setWeekend(boolean isWeekend) {
        this.isWeekend = isWeekend;
    }

    public double getReservationTotal(){
        return numberOfNights * price;
    }
}
