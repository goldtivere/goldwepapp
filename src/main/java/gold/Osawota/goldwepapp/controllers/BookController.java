package gold.Osawota.goldwepapp.controllers;

import gold.Osawota.goldwepapp.respositories.BookRespositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private BookRespositories book;

    public BookController(BookRespositories book) {
        this.book = book;
    }

    @RequestMapping("/books")
    public String getBooks(Model model)
    {
    model.addAttribute("books", book.findAll());

    return "books";
    }
}
