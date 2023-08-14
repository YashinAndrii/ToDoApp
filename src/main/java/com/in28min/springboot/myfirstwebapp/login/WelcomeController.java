package com.in28min.springboot.myfirstwebapp.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("name")
public class WelcomeController {
    @RequestMapping (value = "/", method = RequestMethod.GET)
    public String welcomePage(ModelMap model) {
        model.put("name", getLoggedUserName());
        return "welcome";
    }

    private String getLoggedUserName(){
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
