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

    // Methods
    // Once a room has been checked in, it should be occupied and marked as dirty
    public void checkIn(){
        isOccupied = true;
        isDirty = true;
    }

    // When a guest checks out of a room it must first be cleaned by a housekeeper
    // before another guest can check into the room
    public void checkOut(){
        cleanRoom();
        isOccupied = false;
    }

    public void cleanRoom(){
        isDirty = false;
    }

}