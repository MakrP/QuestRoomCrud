package nulp.bd.questroom.controller;

import nulp.bd.questroom.entity.Status;
import nulp.bd.questroom.entity.Type;
import nulp.bd.questroom.service.StatusService;
import nulp.bd.questroom.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class StatusController {
    @Autowired
    private StatusService service;

    @RequestMapping("/status")
    public String showStatuses(Model model) {
        List<Status> statuses = service.getAll();
        model.addAttribute("statuses",statuses);
        return "status/show";
    }

    @RequestMapping("/status/add")
    public String newStatusPage(Model model) {
        Status status = new Status();
        model.addAttribute("status",status);
        return "status/add";
    }


    @RequestMapping(value = "/status/save", method = RequestMethod.POST)
    public String saveStatus(@ModelAttribute("status") Status status) {
        service.save(status);
        return "redirect:/status";
    }
}
