package nulp.bd.questroom.controller;


import nulp.bd.questroom.entity.Personage;
import nulp.bd.questroom.entity.Room;
import nulp.bd.questroom.service.PersonageService;

import nulp.bd.questroom.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PersonageController {

    @Autowired
    private PersonageService service;

    @Autowired
    private RoomService roomService;

    @RequestMapping("/personage")
    public String showCharacters(Model model) {
        List<Personage> personages = service.getAll();
        model.addAttribute("personages", personages);
        return "/admin/personage/show";
    }

    @RequestMapping("/personage/add")
    public String newCharacterPage(Model model) {
        Personage personage = new Personage();
        List<Room> rooms = roomService.getAll();
        model.addAttribute("personage", personage);
        model.addAttribute("rooms", rooms);
        return "/admin/personage/add";
    }

    @RequestMapping(value = "/personage/save", method = RequestMethod.POST)
    public String savePersonage(@ModelAttribute("personage") Personage personage) {
        service.save(personage);
        return "redirect:/personage";
    }

    @RequestMapping("/personage/{personageId}/delete")
    public String deletePersonage(@PathVariable Integer personageId) {
        service.delete(personageId);
        return "redirect:/personage";
    }
}
