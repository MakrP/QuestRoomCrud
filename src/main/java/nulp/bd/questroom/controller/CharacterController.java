package nulp.bd.questroom.controller;


import nulp.bd.questroom.entity.Character;
import nulp.bd.questroom.entity.Employee;
import nulp.bd.questroom.entity.Institution;
import nulp.bd.questroom.entity.Room;
import nulp.bd.questroom.service.CharacterService;

import nulp.bd.questroom.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CharacterController {
    @Autowired
    private CharacterService service;

    @Autowired
    private RoomService roomService;



    @RequestMapping("/character")
    public String showCharacters(Model model) {
        List<Character> characters = service.getAll();
        model.addAttribute("characters", characters);
        return "character/show";
    }

    @RequestMapping("/character/add")
    public String newCharacterPage(Model model) {
        Character character = new Character();
        List<Room> rooms = roomService.getAll();
        model.addAttribute("character", character);
        model.addAttribute("rooms", rooms);
        return "character/add";
    }

    @RequestMapping(value = "/character/save", method = RequestMethod.POST)
    public String saveCharacter(@ModelAttribute("character") Character character) {
        service.save(character);
        return "redirect:/character";
    }
}
