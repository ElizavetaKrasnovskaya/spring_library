package com.bsuir.test.service.user;

import com.bsuir.test.model.Book;
import com.bsuir.test.model.User;
import com.bsuir.test.web.dto.UserRegistrationDto;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Set;

public interface UserService extends UserDetailsService {
    User update(User user);

    User save(UserRegistrationDto registrationDto);

    Set<Book> getBooks(String username);

    Page<User> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}