package sbb.bidb.projectBase.service.Impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sbb.bidb.projectBase.entity.User;
import sbb.bidb.projectBase.repo.UserRepository;
import sbb.bidb.projectBase.service.IUserService;

@Service
public class UserService implements IUserService {
 private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getById(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public Page<User> getAllPageable(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User getByUsername(String userName) {
        return getByUsername(userName);
    }
}
