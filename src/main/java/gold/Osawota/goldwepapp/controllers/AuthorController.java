package gold.Osawota.goldwepapp.controllers;

import gold.Osawota.goldwepapp.respositories.AuthorRespositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {
    private AuthorRespositories auth;

    public AuthorController(AuthorRespositories auth) {
        this.auth = auth;
    }

    @RequestMapping("/author")
    public String getAuthor(Model model)
    {
        model.addAttribute("author",auth.findAll());
        return "author";
    }
}
