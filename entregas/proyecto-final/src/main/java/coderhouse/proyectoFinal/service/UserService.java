package coderhouse.proyectoFinal.service;

import coderhouse.proyectoFinal.entity.UserModel;
import coderhouse.proyectoFinal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserModel> getUsers() {
        return userRepository.findAll();
    }

    public UserModel addUser(UserModel user) {
        return userRepository.save(user);
    }

    public Optional<UserModel> getUserByID(Long id) {
        return userRepository.findById(id);
    }

    public UserModel updateUser(UserModel existingUser, UserModel newUser) {
        existingUser.setName(newUser.getName());
        existingUser.setEmail(newUser.getEmail());
        return userRepository.save(existingUser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
