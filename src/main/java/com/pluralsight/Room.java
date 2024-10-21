/*
The Room class is responsible for knowing everything related to a hotel room.
 */
package com.pluralsight;

public class Room {
    // Data members
    private int numberOfBeds;
    private double price;
    private boolean isOccupied;
    private boolean isDirty;

    // Constructor
    public Room(int numberOfBeds, double price, boolean isOccupied, boolean isDirty) {
        this.numberOfBeds = numberOfBeds;
        this.price = price;
        this.isOccupied = isOccupied;
        this.isDirty = isDirty;
    }

    // Getters
    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public double getPrice() {
        return price;
    }

    // Boolean Getters
    public boolean isOccupied(){
        return isOccupied;
    }

    public boolean isDirty(){
        return isDirty;
    }
    // A room is only available if it is clean and not currently occupied
    public boolean isAvailable(){
        return !isDirty() && !isOccupied();
    }
}