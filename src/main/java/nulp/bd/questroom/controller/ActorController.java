package nulp.bd.questroom.controller;


import net.sf.jasperreports.engine.JRException;
import nulp.bd.questroom.entity.Actor;
import nulp.bd.questroom.entity.Institution;
import nulp.bd.questroom.entity.Personage;
import nulp.bd.questroom.service.ActorService;
import nulp.bd.questroom.service.InstitutionService;
import nulp.bd.questroom.service.PersonageService;
import nulp.bd.questroom.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@Controller
public class ActorController {

    @Autowired
    private ActorService service;

    @Autowired
    private InstitutionService institutionService;

    @Autowired
    private ReportService reportService;

    @Autowired
    private PersonageService personageService;

    @RequestMapping("/actor")
    public String showActors(Model model) {
        List<Actor> actors = service.getAll();
        model.addAttribute("actors", actors);
        return "/admin/actor/show";
    }

    @RequestMapping("/actor/add")
    public String newEmployeePage(Model model) {
        Actor actor = new Actor();
        List<Institution> institutions = institutionService.getAll();
        model.addAttribute("actor", actor);
        model.addAttribute("institutions", institutions);
        return "/admin/actor/add";
    }
    @RequestMapping("/actor/report")
    public String makeReport(Model model) {
        try {
            reportService.exportReport();
        } catch (FileNotFoundException | JRException e) {
            e.printStackTrace();
        }
        return "admin/actor/show";
    }


    @GetMapping("/actor/{actorId}/personage")
    public String addPersonagePage(Model model, @PathVariable Integer actorId) {
        List<Personage> personages = personageService.getAll();
        Personage personage = new Personage();
        model.addAttribute("personages",personages);
        model.addAttribute("personage",personage);
        model.addAttribute("actorId",actorId);
         return "/admin/actor/add_personage";
    }

    @PostMapping("/actor/{actorId}/personage/add")
    public String addNewPersonageToActor(@ModelAttribute("personage") Personage personage, @PathVariable Integer actorId) {
        service.addNewPersonageToActor(actorId,personage.getId());
        return "redirect:/actor";
    }



    @RequestMapping(value = "/actor/save", method = RequestMethod.POST)
    public String saveInstitution(@ModelAttribute("actor") Actor actor) {
        service.save(actor);
        return "redirect:/actor";
    }

    @RequestMapping("/actor/{actorId}/delete")
    public String deleteActor(@PathVariable Integer actorId) {
        service.delete(actorId);
        return "redirect:/actor";
    }
}
