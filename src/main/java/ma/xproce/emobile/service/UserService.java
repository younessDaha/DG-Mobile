package ma.xproce.emobile.service;

import ma.xproce.emobile.dao.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User createUser(User user);

    Page<User> getAllUser(String keyword, Pageable pageable);

    User getUserById(Integer id);

    User updateUser(User user);

    void deleteById(Integer id);

    List<User> getAllUser2();
}
