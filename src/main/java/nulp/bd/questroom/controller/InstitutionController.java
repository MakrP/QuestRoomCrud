package nulp.bd.questroom.controller;


import nulp.bd.questroom.entity.Institution;
import nulp.bd.questroom.service.InstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class InstitutionController {

    @Autowired
    InstitutionService service;

    @RequestMapping("/institution")
    public String showInstitutions(Model model) {
        List<Institution> listProducts = service.getAll();
        model.addAttribute("institutions", listProducts);
        return "institution/show";
    }

    @RequestMapping("/institution/add")
    public String newInstitutionPage(Model model) {
        Institution institution = new Institution();
        model.addAttribute("institution", institution);
        return "institution/add";
    }

    @RequestMapping(value = "/institution/save", method = RequestMethod.POST)
    public String saveInstitution(@ModelAttribute("institution") Institution institution) {
        service.save(institution);
        return "redirect:/institution";
    }

}
