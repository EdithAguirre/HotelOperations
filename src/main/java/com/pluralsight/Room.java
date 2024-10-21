/*
The Room class is responsible for knowing everything related to a hotel room.
 */
package com.pluralsight;

public class Room {
    // Data members
    private int numberOfBeds;
    private double price;
    private boolean occupied;

    // Constructor
    public Room(int numberOfBeds, double price, boolean occupied) {
        this.numberOfBeds = numberOfBeds;
        this.price = price;
        this.occupied = occupied;
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
        return occupied;
    }

    public boolean isDirty(){
        return false;
    }
    // A room is only available if it is clean and not currently occupied
    public boolean isAvailable(){
        return !isDirty() && !isOccupied();
    }
}
