package com.hostel.backend.model;
import jakarta.persistence.*;

@Entity
@Table(name = "hostels")
public class Hostel {

    // =========================
    // PRIMARY KEY
    // =========================

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // =========================
    // BASIC HOSTEL INFO
    // =========================

    private String name;

    private String location;

    private double price;

    // =========================
    // HOSTEL STRUCTURE
    // =========================

    private int floors;

    private int totalRooms;

    // =========================
    // BED INFORMATION
    // =========================

    private int totalBeds;

    private int bookedBeds;

    private int availableBeds;

    // =========================
    // OCCUPANCY
    // =========================

    private double occupancyPercentage;

    // =========================
    // COMPLEX ROOM DATA
    // STORED AS JSON STRING
    // =========================

    @Column(columnDefinition = "TEXT")
    private String rooms;

    @Column(columnDefinition = "TEXT")
    private String customBeds;

    // =========================
    // IMAGES
    // STORED AS JSON STRING
    // =========================

    @Column(columnDefinition = "TEXT")
    private String images;

    // =========================
    // GETTERS & SETTERS
    // =========================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // -------------------------

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // -------------------------

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // -------------------------

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // -------------------------

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    // -------------------------

    public int getTotalRooms() {
        return totalRooms;
    }

    public void setTotalRooms(int totalRooms) {
        this.totalRooms = totalRooms;
    }

    // -------------------------

    public int getTotalBeds() {
        return totalBeds;
    }

    public void setTotalBeds(int totalBeds) {
        this.totalBeds = totalBeds;
    }

    // -------------------------

    public int getBookedBeds() {
        return bookedBeds;
    }

    public void setBookedBeds(int bookedBeds) {
        this.bookedBeds = bookedBeds;
    }

    // -------------------------

    public int getAvailableBeds() {
        return availableBeds;
    }

    public void setAvailableBeds(int availableBeds) {
        this.availableBeds = availableBeds;
    }

    // -------------------------

    public double getOccupancyPercentage() {
        return occupancyPercentage;
    }

    public void setOccupancyPercentage(double occupancyPercentage) {
        this.occupancyPercentage = occupancyPercentage;
    }

    // -------------------------

    public String getRooms() {
        return rooms;
    }

    public void setRooms(String rooms) {
        this.rooms = rooms;
    }

    // -------------------------

    public String getCustomBeds() {
        return customBeds;
    }

    public void setCustomBeds(String customBeds) {
        this.customBeds = customBeds;
    }

    // -------------------------

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}