package nulp.bd.questroom.controller;


import nulp.bd.questroom.entity.Institution;
import nulp.bd.questroom.entity.Room;
import nulp.bd.questroom.entity.Subject;
import nulp.bd.questroom.entity.Type;
import nulp.bd.questroom.service.RoomService;
import nulp.bd.questroom.service.SubjectService;
import nulp.bd.questroom.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class RoomController {

    @Autowired
    private RoomService service;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private TypeService typeService;

    @RequestMapping("/room")
    public String showRooms(Model model) {
        List<Room> listRooms = service.getAll();
        model.addAttribute("rooms", listRooms);
        return "room/show";
    }

    @RequestMapping("/room/add")
    public String newRoomPage(Model model) {
        Room room = new Room();
        List<Subject> possibleSubjects = subjectService.getAll();
        List<Type> possibleTypes = typeService.getAll();
        model.addAttribute("room", room);
        model.addAttribute("subjects", possibleSubjects);
        model.addAttribute("types", possibleTypes);
        return "room/add";
    }

    @RequestMapping(value = "/room/save", method = RequestMethod.POST)
    public String saveRoom(@ModelAttribute("room") Room room) {
        service.save(room);
        return "redirect:/institution";
    }

}
