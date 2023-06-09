package com.example.SimpleCrud.controller;

import com.example.SimpleCrud.model.Employee;
import com.example.SimpleCrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping("/")
    public String viewHomePage(Model model){
        List<Employee> employeeList = service.listAll();
        model.addAttribute("employeeList", employeeList);
        System.out.println("Get / ");
        return "index";
    }

    @GetMapping("/new")
    public String add(Model model){
        model.addAttribute("employee", new Employee());
        return "new";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveEmployee(@ModelAttribute("employee") Employee emp){
        service.save(emp);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditEmployeePage(@PathVariable(name = "id") int id){
        ModelAndView mav = new ModelAndView("new");
        Employee emp = service.get(id);
        mav.addObject("employee",emp);
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable(name = "id") int id){
        service.delete(id);
        return "/redirect:/";
    }
}
