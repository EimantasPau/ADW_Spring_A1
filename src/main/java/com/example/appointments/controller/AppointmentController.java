package com.example.appointments.controller;

import com.example.appointments.domain.Appointment;
import com.example.appointments.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.View;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/appointments")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {
        List<Appointment> appointments = appointmentService.findAll();
        model.addAttribute("appointments",appointments);
        return "index";
    }

    @RequestMapping(value="/create", method= RequestMethod.GET)
    public String createView(Model model) {
        Appointment appointment = new Appointment();
        model.addAttribute("appointment", appointment);
        System.out.println(new Date());
        return "create";
    }

    @RequestMapping(value="/create", method= RequestMethod.POST)
    public String create(Model model, @ModelAttribute("appointment") Appointment appointment) {
        appointmentService.save(appointment);
        return "redirect:/appointments";
    }
}
