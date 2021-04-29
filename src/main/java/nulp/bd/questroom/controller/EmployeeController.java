package nulp.bd.questroom.controller;


import nulp.bd.questroom.entity.Employee;
import nulp.bd.questroom.entity.Institution;
import nulp.bd.questroom.service.EmployeeService;
import nulp.bd.questroom.service.InstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @Autowired
    private InstitutionService institutionService;

    @RequestMapping("/employee")
    public String showEmployees(Model model) {
        List<Employee> employees = service.getAll();
        model.addAttribute("employees", employees);
        return "employee/show";
    }

    @RequestMapping("/employee/add")
    public String newEmployeePage(Model model) {
        Employee employee = new Employee();
        List<Institution> institutions = institutionService.getAll();
        model.addAttribute("employee", employee);
        model.addAttribute("institutions", institutions);
        return "employee/add";
    }

    @RequestMapping(value = "/employee/save", method = RequestMethod.POST)
    public String saveInstitution(@ModelAttribute("employee") Employee employee) {
        service.save(employee);
        return "redirect:/employee";
    }
}
