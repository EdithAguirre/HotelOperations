/*
This class creates a simple hotel object and checks if there are rooms available for the current day only
 */
package com.pluralsight;

public class Hotel {
    // Data members
    private String name;
    private int numberOfSuites;
    private int numberOfRooms;
    private int bookedSuites;
    private int bookedBasicRooms;
    private boolean isSuite;

    // Constructors
    Hotel(String name, int numberOfSuites, int numberOfRooms){
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = 0;
        this.bookedBasicRooms = 0;
    }

    public Hotel(String name, int numberOfSuites, int numberOfRooms, int bookedSuites, int bookedBasicRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = bookedSuites;
        this.bookedBasicRooms = bookedBasicRooms;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getNumberOfSuites() {
        return numberOfSuites;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public int getBookedSuites() {
        return bookedSuites;
    }

    public int getBookedBasicRooms() {
        return bookedBasicRooms;
    }

    // Methods

    // To book 1+ rooms (if available). User specifies number of rooms and whether it's a suit or basic room
    public boolean bookRoom(int numberOfRooms, boolean isSuite){
        // Determine if there are enough rooms available and update booked inventory if they are
        if(isSuite){
            if(getAvailableSuites() >= numberOfSuites){
                bookedSuites += numberOfSuites;
                return true;
            }
            else{
                System.out.println("The number of suite rooms you specified are not available.");
                return false;
            }
        }
        if(!isSuite && getAvailableRooms() >= numberOfRooms){
            bookedBasicRooms += numberOfRooms;
            return true;
        }
        else{
            System.out.println("The number of suite rooms you specified are not available.");
            return false;
        }
    }

    // Derived Getters
    public int getAvailableSuites(){
        return (numberOfSuites - bookedSuites);
    }

    public int getAvailableRooms(){
        return (numberOfRooms - bookedBasicRooms);
    }

}
