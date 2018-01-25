package com.example.appointments.service;

import com.example.appointments.domain.Appointment;
import com.example.appointments.domain.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    AppointmentRepository appointmentRepository;

    public Appointment save(Appointment a) { return appointmentRepository.save(a);}
    public void delete(Appointment a) {  appointmentRepository.delete(a);}
    public List<Appointment> findAll() { return appointmentRepository.findAll();}
    //use the same keyword for title, description and patient name
    public List<Appointment> find(String keyword) {
        return appointmentRepository.findByTitleContainingOrDescriptionContainingOrPatientNameContaining(keyword, keyword, keyword);}
}
