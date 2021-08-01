package cyberlogitec.training.project.ecommerce.security;

import cyberlogitec.training.project.ecommerce.user.model.Role;
import cyberlogitec.training.project.ecommerce.user.model.User;
import cyberlogitec.training.project.ecommerce.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);

        if(user.isEmpty())
            throw new UsernameNotFoundException("user Identification is not available");
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(getAuthorities(user.get().getRole()));

        return new UserDetailsImpl(user.get().getUsername(), user.get().getPassword(), authorities);
    }

    private GrantedAuthority getAuthorities(Role role) {

        GrantedAuthority authority = new SimpleGrantedAuthority(role.getName());

        return authority;
    }
}
