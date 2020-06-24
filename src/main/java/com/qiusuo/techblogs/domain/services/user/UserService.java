package com.qiusuo.techblogs.domain.services.user;

import com.qiusuo.techblogs.authentication.config.CustomAuthenticationToken;
import com.qiusuo.techblogs.domain.models.user.User;
import com.qiusuo.techblogs.domain.repositories.user.UserRepository;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> allUsers() {
        return userRepository.findAll();
    }

    public User addUser(String name) {
        User newUser = new User();
        newUser.setName(name);
        userRepository.save(newUser);
        return newUser;
    }

    /**
     * Get the current username from the
     *
     * @return
     */
    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            CustomAuthenticationToken customAuthenticationToken = (CustomAuthenticationToken) authentication;
            return getUserById(customAuthenticationToken.getUserId());
        }
        return null;
    }

    public User getUserById(String id) {
        return userRepository.getOne(id);
    }
}
