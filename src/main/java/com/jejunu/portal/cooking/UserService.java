package com.jejunu.portal.cooking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface UserService {
//    @Autowired
//    private UserRepo userRepo;
//
//    public User addUser(String name, String email) {
//        User user = new User(name, email);
//        return userRepo.save(user);
//    }
//
//    public List<User> findAll() {
//        return userRepo.findAll();
//    }
//
//    public Optional<User> findById(long id) {
//        return userRepo.findById(id);
//    }
    public User findUserByEmail(String email);
    public void saveUser(User user);
}
