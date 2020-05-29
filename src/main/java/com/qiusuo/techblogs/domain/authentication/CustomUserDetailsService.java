package com.qiusuo.techblogs.domain.authentication;

import com.qiusuo.techblogs.domain.models.user.Privilege;
import com.qiusuo.techblogs.domain.models.user.Role;
import com.qiusuo.techblogs.domain.models.user.User;
import com.qiusuo.techblogs.domain.repositories.user.PrivilegeRepository;
import com.qiusuo.techblogs.domain.repositories.user.RoleRepository;
import com.qiusuo.techblogs.domain.repositories.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service("userDetailsSearvice")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PrivilegeRepository privilegeRepository;


    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {

        User user = userRepository.getOne(id);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("user with %s does not exit", id));
        }

        return new org.springframework.security.core.userdetails.User(
                user.getName(), user.getEncryptedPassword(), user.getEnabled(), true, true,
                true, getAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles) {
        return getGrantedAuthorities(getPrivileges(roles));
    }

    private List<String> getPrivileges(Collection<Role> roles) {
        List<String> privileges = new ArrayList<>();
        List<Privilege> collection = new ArrayList<>();
        for (Role role : roles) {
            collection.addAll(role.getPrivileges());
        }
        for (Privilege item : collection) {
            privileges.add(item.getName());
        }
        return privileges;
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }
}
