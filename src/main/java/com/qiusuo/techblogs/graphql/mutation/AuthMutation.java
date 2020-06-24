package com.qiusuo.techblogs.graphql.mutation;

import com.qiusuo.techblogs.authentication.config.CustomAuthenticationToken;
import com.qiusuo.techblogs.authentication.config.JwtUserDetailsService;
import com.qiusuo.techblogs.authentication.util.JwtRequest;
import com.qiusuo.techblogs.authentication.util.JwtResponse;
import com.qiusuo.techblogs.authentication.util.JwtTokenUtil;
import com.qiusuo.techblogs.domain.models.user.UserType;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Secured("ROLE_ANONYMOUS")
@Component
public class AuthMutation implements GraphQLMutationResolver {
    private AuthenticationManager authenticationManager;
    private JwtTokenUtil jwtTokenUtil;
    private JwtUserDetailsService userDetailsService;

    public JwtResponse createToken(JwtRequest authenticationRequest) throws Exception {
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getUserId(), authenticationRequest.getPassword(), authenticationRequest.getUsertype());
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return new JwtResponse(token);
    }


    private void authenticate(String username, String userId, String password, UserType usertype) throws Exception {
        try {
            authenticationManager.authenticate(new CustomAuthenticationToken(username, userId, password, usertype));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
