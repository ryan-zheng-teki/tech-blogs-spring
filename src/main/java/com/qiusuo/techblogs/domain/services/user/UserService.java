package com.qiusuo.techblogs.domain.services.user;

import com.qiusuo.techblogs.domain.models.user.User;
import com.qiusuo.techblogs.domain.repositories.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> allUsers() {
        return userRepository.findAll();
    }

    public User addUser(String name) {
        User newUser = new User();
        newUser.setName(name);
        userRepository.save(newUser);
        return newUser;
    }

    public User getUserById(String id) {
        return userRepository.getOne(id);
    }
}
