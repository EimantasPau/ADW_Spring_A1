package com.example.appointments.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByTitleContainingOrDescriptionContainingOrPatientName(String title, String description, String patientName);
}
