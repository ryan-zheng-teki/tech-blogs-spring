package com.qiusuo.techblogs.domain.services.user;

import com.qiusuo.techblogs.domain.models.user.User;
import com.qiusuo.techblogs.domain.repositories.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> allUsers() {
        return userRepository.findAll();
    }
}
