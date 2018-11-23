package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dto.RegistrationFormDTO;
import pl.coderslab.services.RegistrationService;

import javax.validation.Valid;
@Controller
@RequestMapping(value = "/tweeger", produces = "text/html;charset=UTF-8")
public class RegistrationController {

    @Autowired
    RegistrationService registrationService;

    @GetMapping("/register")
    public String register(Model model) {
//        model.addAttribute("newUser", new User());
        model.addAttribute("registrationFormData", new RegistrationFormDTO());
        return "user/register";
    }
    @PostMapping("/register")
    public String register(@ModelAttribute("registrationFormData") @Valid RegistrationFormDTO form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/register";
        }
        if (!checkPasswords(form)){
            bindingResult.rejectValue("confirmedPassword", "","passwords must match");
            return "user/register";
        }
        boolean isLoginUnique = registrationService.checkUsername(form.getUsername());

        if (!isLoginUnique){
            bindingResult.rejectValue("username","","Login used");
            return "user/register";
        }
        boolean isEmailUnique = registrationService.checkEmail(form.getEmail());

        if (!isEmailUnique){
            bindingResult.rejectValue("email","","Email used");
            return "user/register";
        }
//        userDao.save(user);
        registrationService.registerUser(form);
        return "user/registered";
    }

    private boolean checkPasswords(RegistrationFormDTO form) {
        return form.getPassword().equals(form.getConfirmedPassword());
    }


}
