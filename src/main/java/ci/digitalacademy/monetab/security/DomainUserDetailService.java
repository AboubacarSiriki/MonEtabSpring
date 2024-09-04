package ci.digitalacademy.monetab.security;

import ci.digitalacademy.monetab.models.RoleUser;
import ci.digitalacademy.monetab.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.sql.ast.tree.expression.Collation;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import ci.digitalacademy.monetab.models.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class DomainUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

       final Optional<User> user = userRepository.findBySpeudo(username);

       if (user.isEmpty()){
           throw new IllegalArgumentException("User not found");
       }

       final List<GrantedAuthority> grantedAuthorities= user.get()
               .getRoleUsers()
               .stream()
               .map(RoleUser::getRole)
               .map(SimpleGrantedAuthority::new)
               .collect(Collectors.toList());


        return user.map(userRecover ->  org.springframework.security.core.userdetails.User.builder()
                .username(userRecover.getSpeudo())
                .password(userRecover.getPassword())
                .authorities(grantedAuthorities)
                .roles()
                .build()).orElseThrow(() -> new IllegalArgumentException("User not found"));
    }
}
