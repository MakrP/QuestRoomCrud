package nulp.bd.questroom.controller;


import nulp.bd.questroom.entity.*;
import nulp.bd.questroom.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping("/institution/{institutionId}/room/{roomId}/reservation")
    public String showRooms(@PathVariable Integer institutionId,@PathVariable Integer roomId, Model model) {
        List<Reservation> reservations = service.getByInstitutionAndRoom(institutionService.get(institutionId),
                                                                         roomService.get(roomId));
        model.addAttribute("reservations", reservations);
        return "reservation/show";
    }


    @RequestMapping("/institution/{institutionId}/room/{roomId}/reservation/add")
    public String newRoomPage(@PathVariable Integer institutionId,@PathVariable Integer roomId,Model model) {
        Reservation reservation = new Reservation();
        reservation.setRoom(roomService.get(roomId));
        reservation.setInstitution(institutionService.get(institutionId));
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
        reservation.setStatus(statusService.getByTitle("NEED ACTORS"));
        service.save(reservation);
        return "institution/" + reservation.getInstitution().getId() +
                "/room/" + reservation.getRoom().getId() + "/reservation";
    }
}
