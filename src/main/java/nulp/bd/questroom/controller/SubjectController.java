package nulp.bd.questroom.controller;


import nulp.bd.questroom.entity.Institution;
import nulp.bd.questroom.entity.Subject;
import nulp.bd.questroom.service.InstitutionService;
import nulp.bd.questroom.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class SubjectController {

    @Autowired
    SubjectService service;

    @RequestMapping("/subject")
    public String showSubjects(Model model) {
        List<Subject> listSubjects = service.getAll();
        model.addAttribute("subjects", listSubjects);
        return "subject/show";
    }

    @RequestMapping("/subject/add")
    public String newSubjectPage(Model model) {
        Subject subject = new Subject();
        model.addAttribute("subject", subject);
        return "subject/add";
    }

    @RequestMapping(value = "/subject/save", method = RequestMethod.POST)
    public String saveSubject(@ModelAttribute("subject") Subject subject) {
        service.save(subject);
        return "redirect:/subject";
    }
}
