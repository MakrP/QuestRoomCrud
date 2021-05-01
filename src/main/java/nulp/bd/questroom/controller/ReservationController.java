package nulp.bd.questroom.controller;


import nulp.bd.questroom.entity.*;
import nulp.bd.questroom.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.List;

@Controller
public class ReservationController {
    @Autowired
    private ReservationService service;

    @Autowired
    private RoomService roomService;

    @Autowired
    private InstitutionService institutionService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private StatusService statusService;

    @RequestMapping("/reservation")
    public String showRooms(Model model) {
        List<Reservation> reservations = service.getAll();
        model.addAttribute("reservations", reservations);
        return "reservation/show";
    }

    @RequestMapping("/reservation/add")
    public String newRoomPage(Model model) {
        Reservation reservation = new Reservation();
        List<Institution> institutions = institutionService.getAll();
        List<Room> rooms = roomService.getAll();
        List<Client> clients = clientService.getAll();
        model.addAttribute("reservation", reservation);
        model.addAttribute("institutions", institutions);
        model.addAttribute("rooms", rooms);
        model.addAttribute("clients", clients);
        return "reservation/add";
    }

    @RequestMapping(value = "/reservation/save", method = RequestMethod.POST)
    public String saveRoom(@ModelAttribute("reservation") Reservation reservation) {
        reservation.setRegistrationDate(new Date());
        reservation.setStatus(statusService.getByTitle("NOT COMPLETED"));
        service.save(reservation);
        return "redirect:/reservation";
    }
}
