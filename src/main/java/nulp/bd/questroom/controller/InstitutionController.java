package nulp.bd.questroom.controller;


import nulp.bd.questroom.entity.Institution;
import nulp.bd.questroom.entity.Room;
import nulp.bd.questroom.service.InstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class InstitutionController {

    @Autowired
    InstitutionService service;

    @RequestMapping("/manager/institution")
    public String showManagerInstitutions(Model model) {
        List<String> cities = service.getAllCities();
        model.addAttribute("cities", cities);
        model.addAttribute("service",service);
        return "manager/institution/show";
    }
    @RequestMapping("/admin/institution")
    public String showAdminInstitutions(Model model) {
        List<Institution> institutions = service.getAll();
        model.addAttribute("institutions", institutions);
        return "admin/institution/show";
    }

    @RequestMapping("/manager/institution/{id}/rooms")
    public String showInstitutionInfo(@PathVariable Integer id,Model model) {
        Institution institution = service.get(id);
        model.addAttribute("institution",institution);
        return "manager/room/show";
    }

    @RequestMapping("/institution/add")
    public String newInstitutionPage(Model model) {
        Institution institution = new Institution();
        model.addAttribute("institution", institution);
        return "/admin/institution/add";
    }

    @RequestMapping(value = "/institution/save", method = RequestMethod.POST)
    public String saveInstitution(@ModelAttribute("institution") Institution institution) {
        service.save(institution);
        return "redirect:/admin/institution";
    }

    @DeleteMapping("/institution/{institutionId}/delete")
    public String deleteInstitution(@PathVariable Integer institutionId) {
        service.delete(institutionId);
        return "redirect:/admin/institution";
    }
}
