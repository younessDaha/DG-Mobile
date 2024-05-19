package ma.xproce.emobile.service.Implementation;

import ma.xproce.emobile.dao.entities.User;
import ma.xproce.emobile.dao.repository.UserRepository;
import ma.xproce.emobile.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserServiceImp implements UserService  {
    @Autowired
    private UserRepository userRepository;



    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Page<User> getAllUser(String keyword, Pageable pageable) {
        return userRepository.findByNomContaining(keyword,pageable);
    }

    @Override
    public User getUserById(Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElse(null);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAllUser2() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserByNom(String username) {
        return userRepository.findByNom(username);
    }

}
