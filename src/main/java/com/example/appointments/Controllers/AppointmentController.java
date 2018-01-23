package com.example.appointments.Controllers;

import com.example.appointments.Domain.Appointment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @RequestMapping(value="", method= RequestMethod.GET)
    public List<Appointment> hello() {
        Date date = new Date();
        Appointment app = new Appointment(1, "gfg", "gfgdfg",date, "fdsdf", "fdsgds", date);
        return Arrays.asList(app);
    }

}
