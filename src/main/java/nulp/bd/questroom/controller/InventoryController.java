package nulp.bd.questroom.controller;

import nulp.bd.questroom.entity.Inventory;
import nulp.bd.questroom.entity.Personage;
import nulp.bd.questroom.entity.Room;
import nulp.bd.questroom.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class InventoryController {
    @Autowired
    private InventoryService service;

    @Autowired
    private RoomService roomService;

    @Autowired
    private InstitutionService institutionService;

    @Autowired
    private InventoryTypeService inventoryTypeService;


    @RequestMapping("/inventory")
    public String showCharacters(Model model) {
        List<Inventory> inventories = service.getAll();
        model.addAttribute("inventories", inventories);
        return "inventory/show";
    }

    @RequestMapping("/inventory/add")
    public String newCharacterPage(Model model) {
        Personage personage = new Personage();
        List<Room> rooms = roomService.getAll();
        model.addAttribute("personage", personage);
        model.addAttribute("rooms", rooms);
        return "inventory/add";
    }

    @RequestMapping(value = "/inventory/save", method = RequestMethod.POST)
    public String saveCharacter(@ModelAttribute("inventory") Inventory inventory) {
        service.save(inventory);
        return "redirect:/inventory";
    }
}
