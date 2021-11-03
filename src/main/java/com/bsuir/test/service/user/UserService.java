package com.bsuir.test.service.user;

import com.bsuir.test.model.User;
import com.bsuir.test.web.dto.UserRegistrationDto;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);

    Page<User> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}