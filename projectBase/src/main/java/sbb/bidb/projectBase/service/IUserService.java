package sbb.bidb.projectBase.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sbb.bidb.projectBase.entity.Issue;
import sbb.bidb.projectBase.entity.User;

public interface IUserService {
    User save (User user);
    User getById(Long id);
    Page <User> getAllPageable (Pageable pageable);
    User getByUsername(String userName);
}
