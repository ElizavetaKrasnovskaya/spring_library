package com.bsuir.test.web;

import com.bsuir.test.model.Book;
import com.bsuir.test.model.User;
import com.bsuir.test.repository.UserRepository;
import com.bsuir.test.service.book.BookService;
import com.bsuir.test.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class MyBooksController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookService bookService;

    @GetMapping("/myBooks")
    public String viewHomePage(Model model) {
        List<Book> myBooks = new ArrayList();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = "";
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }

        myBooks.addAll(userService.getBooks(username));
        model.addAttribute("myBooks", myBooks);
        return "user_books_list";
    }

    @GetMapping("/removeBookFromCabinet/{id}")
    public String removeBookToCabinet(@PathVariable(value = "id") int id) {
        Book book = bookService.getBookById(id);

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = "";
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        User user = userRepository.findByUsername(username).get();
        List<Book> books = new ArrayList(user.getBooks());
        Set<Book> myBooks = new HashSet<>(books);
        for (Book myBook: books){
            if (myBook.equals(book)){
                myBooks.remove(myBook);
            }
        }
        user.setBooks(myBooks);

        book.setFree(true);
        book.setUser(null);
        bookService.saveBook(book);
        return "redirect:/myBooks";
    }
}
