package za.co.absa.nnw.library.services.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Map<String, User> users = new HashMap<>();

        User user = new User("lmanyange", "$2y$12$mv2r0f20vfzKsRGkcuzOfOiMlxz7f.aaPRyP/26cIkquiunrhzWFW",
                new ArrayList<>());
        users.put(user.getUsername(), user);

        User authenticatedUser = users.get(username);

        if (Objects.nonNull(authenticatedUser)) {
            return authenticatedUser;
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
