package CRM.service;

import CRM.repository.LoginRepository;
import CRM.domain.UserEntity;
import CRM.utils.TemplateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class LoginServiceBean implements UserDetailsService {

    private final LoginRepository loginRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UserEntity> optionalUserEntity = loginRepository.findByUsername(username);

        optionalUserEntity.orElseThrow(() -> new UsernameNotFoundException("user not found : "  +  username));

        UserEntity userEntity = new TemplateUtil<UserEntity>().get(optionalUserEntity);

        UserDetails user = User.withUsername(userEntity.getUsername())
                .password(userEntity.getPassword())
                .authorities("ADMIN").build();

        return user;
    }
}
