package com.bsuir.test.web;

import com.bsuir.test.model.Author;
import com.bsuir.test.model.Book;
import com.bsuir.test.service.author.AuthorService;
import com.bsuir.test.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String viewHomePage(Model model) {
        return findPaginated(1, "title", "asc", model);
    }

    @GetMapping("/showNewBookForm")
    public String showNewBookForm(Model model) {
        Book book = new Book();
        List<Author> authors = authorService.getAllAuthors();
        model.addAttribute("book", book);
        model.addAttribute("authorsList", authors)
        return "new_book";
    }

    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("book") Book book) {
        bookService.saveBook(book);
        return "redirect:/";
    }

    @GetMapping("/showBookFormForUpdate/{id}")
    public String showBookFormForUpdate(@PathVariable(value = "id") Long id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "update_book";
    }

    @GetMapping("/deleteBook/{id}")
    public String deleteEmployee(@PathVariable(value = "id") Long id) {
        bookService.deleteBookById(id);
        return "redirect:/";
    }

    @GetMapping("/pageBook/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;

        Page<Book> page = bookService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Book> listBooks = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listBooks", listBooks);
        return "index";
    }
}
