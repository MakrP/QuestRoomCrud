package nulp.bd.questroom.controller;


import nulp.bd.questroom.entity.Actor;
import nulp.bd.questroom.entity.Institution;
import nulp.bd.questroom.service.ActorService;
import nulp.bd.questroom.service.InstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ActorController {

    @Autowired
    private ActorService service;

    @Autowired
    private InstitutionService institutionService;

    @RequestMapping("/actor")
    public String showActors(Model model) {
        List<Actor> actors = service.getAll();
        model.addAttribute("actors", actors);
        return "actor/show";
    }

    @RequestMapping("/actor/add")
    public String newEmployeePage(Model model) {
        Actor actor = new Actor();
        List<Institution> institutions = institutionService.getAll();
        model.addAttribute("actor", actor);
        model.addAttribute("institutions", institutions);
        return "actor/add";
    }

    @RequestMapping(value = "/actor/save", method = RequestMethod.POST)
    public String saveInstitution(@ModelAttribute("actor") Actor actor) {
        service.save(actor);
        return "redirect:/actor";
    }
}
