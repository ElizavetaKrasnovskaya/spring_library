package com.bsuir.test.service.author;

import com.bsuir.test.model.Author;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AuthorService {
    List<Author> getAllAuthors();

    void saveAuthor(Author author);

    Author getAuthorById(int id);

    void deleteAuthorById(int id);

    Page<Author> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
