package nulp.bd.questroom.controller;


import nulp.bd.questroom.entity.*;
import nulp.bd.questroom.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private PersonageService personageService;

    @RequestMapping("/institution/{institutionId}/room/{roomId}/reservation")
    public String showRooms(@PathVariable Integer institutionId, @PathVariable Integer roomId, Model model) {
        List<Reservation> reservations = service.getByInstitutionAndRoom(institutionService.get(institutionId),
                roomService.get(roomId));
        model.addAttribute("reservations", reservations);
        return "reservation/show";
    }


    @RequestMapping("/institution/{institutionId}/room/{roomId}/reservation/add")
    public String newRoomPage(@PathVariable Integer institutionId, @PathVariable Integer roomId, Model model) {
        Reservation reservation = new Reservation();
        List<Client> clients = clientService.getAll();
        model.addAttribute("reservation", reservation);
        model.addAttribute("clients", clients);
        model.addAttribute("c_room", roomService.get(roomId));
        model.addAttribute("c_institution", institutionService.get(institutionId));
        return "reservation/add";
    }

    @GetMapping("/reservation/{reservationId}/actors")
    public String addActorPage(Model model, @PathVariable Integer reservationId) {
        Reservation reservation = service.get(reservationId);
        List<Personage> personages = reservation.getRoom().getPersonages();
        ActorPersonage actorPersonage = new ActorPersonage();
        personages.forEach(p -> {
            actorPersonage.getPersonageActorMap().put(p, null);
        });
        model.addAttribute("actorPersonage", actorPersonage);
        return "reservation/add_actors";
    }

    @GetMapping("/reservation/{reservationId}/status")
    public String changeStatusPage(Model model, @PathVariable Integer reservationId) {
        Status status = service.get(reservationId).getStatus();
        model.addAttribute("status",status);
        model.addAttribute("statuses",statusService.getAll());
        return "/reservation/status";
    }

    @PostMapping("/reservation/{reservationId}/status/change")
    public String changeStatus(@ModelAttribute("status") Status status, @PathVariable Integer reservationId) {
        Reservation reservation = service.get(reservationId);
        Status status1 = statusService.getByTitle(status.getTitle());
        reservation.setStatus(status1);
        service.save(reservation);
        return "redirect:/institution/" + reservation.getInstitution().getId() + "/room/"
                + reservation.getRoom().getId() + "/reservation";
    }
    @PostMapping("/reservation/{reservationId}/actor/save")
    public String save(@ModelAttribute("actorPersonage") ActorPersonage actorPersonage, @PathVariable Integer reservationId) {
        var map = actorPersonage.getPersonageActorMap();
        for (Personage personage : map.keySet()) {
            service.addPersonageAndActor(reservationId, map.get(personage).getId(), personage.getId());
        }
        Reservation reservation = service.get(reservationId);
        return "redirect:/institution/" + reservation.getInstitution().getId() + "/room/"
                + reservation.getRoom().getId() + "/reservation";
    }


    @RequestMapping(value = "/reservation/{iid}/{rid}/save", method = RequestMethod.POST)
    public String saveReservation(@ModelAttribute("reservation") Reservation reservation
            , @PathVariable Integer iid, @PathVariable Integer rid) {
        reservation.setRegistrationDate(new Date());
        reservation.setInstitution(institutionService.get(iid));
        reservation.setRoom(roomService.get(rid));
        reservation.setStatus(statusService.getByTitle("NEED ACTORS"));
        service.save(reservation);
        return "redirect:/institution/" + iid + "/room/" + rid + "/reservation";
    }


}
