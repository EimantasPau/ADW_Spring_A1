package com.example.appointments.controller;

import com.example.appointments.domain.Appointment;
import com.example.appointments.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
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
    public String create(Model model, @Valid @ModelAttribute("appointment") Appointment appointment, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()){
            model.addAttribute("appointment", appointment);
            model.addAttribute("error", "Please fill out all of the fields.");
            return "create";
        }
        appointmentService.save(appointment);
        redirectAttributes.addFlashAttribute("successMessage", "You have successfully created an appointment.");
        return "redirect:/appointments";
    }
    @RequestMapping(value="/delete/{appointment}", method = RequestMethod.GET)
    public String delete(@PathVariable Appointment appointment, RedirectAttributes redirectAttributes) {
        appointmentService.delete(appointment);
        redirectAttributes.addFlashAttribute("successMessage", "Appointment deleted.");
        return "redirect:/appointments";
    }

    @RequestMapping(value = "/update/{appointment}", method = RequestMethod.GET)
    public String updateView(Model model, @PathVariable Appointment appointment){
        model.addAttribute(appointment);
        return "update";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Model model,@Valid @ModelAttribute("appointment") Appointment appointment, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        //check for validation errors
        if(bindingResult.hasErrors()){
            model.addAttribute("appointment", appointment);
            model.addAttribute("error", "Please fill out all of the fields.");
            return "update";
        }
        appointmentService.save(appointment);
        redirectAttributes.addFlashAttribute("successMessage", "You have successfully updated an appointment.");
        return "redirect:/appointments";
    }
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(@RequestParam (value = "searchKeyword", required = false) String keyword, Model model){
        //find matching appointments and add them to the view model.
        List<Appointment> appointments = appointmentService.find(keyword);
        model.addAttribute("appointments", appointments);
        return "index";
    }
}
