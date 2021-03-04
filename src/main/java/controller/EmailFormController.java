package controller;

import model.EmailForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmailFormController {
    private static List<EmailForm> emailForms;
    static {
        emailForms = new ArrayList<>();
        emailForms.add(new EmailForm("English", 25,true, "sss"));
        emailForms.add(new EmailForm("Vietnamese", 10,false, "sss"));
        emailForms.add(new EmailForm("Japanese", 5,true, "sss"));
        emailForms.add(new EmailForm("Chinese", 100,true, "sss"));
    }

    @GetMapping("/index")
    public ModelAndView showForm(){
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("email", new EmailForm());
        return modelAndView;
    }

    @PostMapping("/info")
    public ModelAndView info(@ModelAttribute EmailForm emailForm){
        ModelAndView modelAndView = new ModelAndView("/info");
        emailForms.add(emailForm);
        modelAndView.addObject("list", emailForms);
        return modelAndView;
    }
}
