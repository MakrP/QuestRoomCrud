package nulp.bd.questroom.controller;


import nulp.bd.questroom.entity.FindOutMethod;
import nulp.bd.questroom.entity.Subject;
import nulp.bd.questroom.service.FindOutMethodService;
import nulp.bd.questroom.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class FindOutMethodController {
    @Autowired
    FindOutMethodService service;

    @RequestMapping("/fom")
    public String showFOM(Model model) {
        List<FindOutMethod> foMethods = service.getAll();
        model.addAttribute("methods", foMethods);
        return "fom/show";
    }

    @RequestMapping("/fom/add")
    public String newSubjectPage(Model model) {
        FindOutMethod findOutMethod = new FindOutMethod();
        model.addAttribute("fom", findOutMethod);
        return "fom/add";
    }

    @RequestMapping(value = "/fom/save", method = RequestMethod.POST)
    public String saveSubject(@ModelAttribute("fom") FindOutMethod findOutMethod) {
        service.save(findOutMethod);
        return "redirect:/fom";
    }
}
