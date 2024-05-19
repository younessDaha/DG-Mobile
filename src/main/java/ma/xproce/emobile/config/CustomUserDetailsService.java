package ma.xproce.emobile.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.xproce.emobile.dao.entities.Role;
import ma.xproce.emobile.dao.entities.User;
import ma.xproce.emobile.dao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    private final static String ROLE_PREFIX ="ROLE_";



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("nom {}", username);
        Optional<User> user = this.userRepository.findByNom(username);
        user.orElseThrow(()-> new UsernameNotFoundException("utilisateur non trouvable"));
        log.info("user {}", user);
        String mdps = user.get().getMdps();
        log.info("mdps {}",mdps);
        Role r =user.get().getRole();
        String role = r.getNom();
        role = ROLE_PREFIX+role;
        log.info("role {}",role);
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(role));
        log.info("roles {}",roles);
        return  new CustomUserDetails(username, roles, mdps);
    }
}
