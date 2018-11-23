package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import pl.coderslab.dto.UserDTO;

@Controller
@RequestMapping(value = "/tweeger", produces = "text/html;charset=UTF-8")
public class HomePageController {

    @RequestMapping
    public String homePage(){
        return "homepage/tweeger";
    }

    @GetMapping
    public String prepareHomePage(Model model, @SessionAttribute(value = LoginController.LOGGED_USER_KEY, required = false)UserDTO loggedUser){

        if(loggedUser != null){
            model.addAttribute("loggedUser",loggedUser);
        }
        return "homepage/tweeger";
    }


}
