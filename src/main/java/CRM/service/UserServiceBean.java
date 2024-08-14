package CRM.service;

import CRM.domain.UserEntity;
import CRM.repository.UserRepository;
import CRM.utils.TemplateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceBean implements UserService {
    private final UserRepository userRepository;


    @Override
    public UserEntity get(Long id) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);
        return new TemplateUtil<UserEntity>().get(optionalUserEntity);
    }

    public UserEntity getUserByUsername(String username) {
        UserEntity userEntity = userRepository.findByUsername(username);
        return userEntity;
    }


    @Override
    public UserEntity edit(UserEntity entity) {
        return null;
    }

    @Override
    public List<UserEntity> list() {
        return null;
    }

    @Override
    public void delete(Long employeeId) {

    }


    @Override
    public UserEntity createNewUser(UserEntity user) {
        return userRepository.save(user);
    }

}
