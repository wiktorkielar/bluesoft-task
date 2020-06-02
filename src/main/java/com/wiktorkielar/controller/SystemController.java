package com.wiktorkielar.controller;

import com.wiktorkielar.model.Customer;
import com.wiktorkielar.model.System;
import com.wiktorkielar.service.CustomerService;
import com.wiktorkielar.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/system")
public class SystemController {

    @Autowired
    private SystemService systemService;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String showSystemList(Model model) {

        List<System> systems = systemService.getSystems();

        model.addAttribute("systems", systems);

        return "system-list-def";
    }

    @GetMapping("/add")
    public String showSystemAdd(Model model) {

        System system = new System();
        List<Customer> customers = customerService.getCustomers();

        model.addAttribute("system", system);
        model.addAttribute("customers", customers);

        return "system-add-def";
    }

    @PostMapping("/save")
    public String saveSystem(@Valid @ModelAttribute System system, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {

            return "system-add-def";
        } else {

            Customer customer = customerService.getCustomerById(system.getCustomer().getId());
            system.setCustomer(customer);

            systemService.saveSystem(system);

            return "redirect:/system/list";
        }
    }
}