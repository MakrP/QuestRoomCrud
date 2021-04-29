package nulp.bd.questroom.controller;

import nulp.bd.questroom.entity.Type;
import nulp.bd.questroom.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class TypeController {

    @Autowired
    private TypeService service;

    @RequestMapping("/type")
    public String showTypes(Model model) {
        List<Type> types = service.getAll();
        model.addAttribute("types",types);
        return "type/show";
    }

    @RequestMapping("/type/add")
    public String newTypePage(Model model) {
        Type type = new Type();
        model.addAttribute("type",type);
        return "type/add";
    }



    @RequestMapping(value = "/type/save", method = RequestMethod.POST)
    public String saveType(@ModelAttribute("type") Type type) {
        service.save(type);
        return "redirect:/type";
    }

}
