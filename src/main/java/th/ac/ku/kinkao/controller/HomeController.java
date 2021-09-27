package th.ac.ku.kinkao.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String getHomePage(Model model , @AuthenticationPrincipal OAuth2User principal) {
        model.addAttribute("greeting", "Sawaddee");
        //ถ้า login แล้วจะทำใน if ถ้ายังไม่ login จะทำใน else
        if (principal != null)
            model.addAttribute("user", principal.getAttribute("name"));
        else
            model.addAttribute("user", "Guest");
        // return home.html
        return "home";
    }


}
