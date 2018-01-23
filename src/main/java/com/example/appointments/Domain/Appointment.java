package com.example.appointments.Domain;

import java.util.Date;

public class Appointment {

    private int id;
    private String title;
    private String description;
    private Date time;
    private String location;
    private String patientName;
    private Date createdAt;

    public Appointment(){

    }

    public Appointment(int id, String title, String description, Date time, String location, String patientName, Date createdAt) {

        this.id = id;
        this.title = title;
        this.description = description;
        this.time = time;
        this.location = location;
        this.patientName = patientName;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }


}
