package com.bsuir.test.service.book;

import com.bsuir.test.model.Book;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    void saveBook(Book book);

    Book getBookById(int id);

    void deleteBookById(int id);

    Page<Book> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
