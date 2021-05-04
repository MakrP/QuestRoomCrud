package nulp.bd.questroom.controller;


import nulp.bd.questroom.entity.Client;
import nulp.bd.questroom.entity.FindOutMethod;
import nulp.bd.questroom.service.ClientService;
import nulp.bd.questroom.service.FindOutMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ClientController {
    @Autowired
    private ClientService service;

    @Autowired
    private FindOutMethodService fomService;

    @RequestMapping("/admin/client")
    public String showEmployees(Model model) {
        List<Client> clients = service.getAll();
        model.addAttribute("clients", clients);
        return "/client/show";
    }

    @RequestMapping("/manager/client/add")
    public String newEmployeePage(Model model) {
        Client client = new Client();
        List<FindOutMethod> foMethods = fomService.getAll();
        model.addAttribute("foMethods", foMethods);
        model.addAttribute("client", client);
        return "/manager/client/add";
    }

    @RequestMapping(value = "/client/save", method = RequestMethod.POST)
    public String saveInstitution(@ModelAttribute("client") Client client) {
        client.setVisitsNumber(0);
        service.save(client);
        return "redirect:/manager/institution";
    }
}
