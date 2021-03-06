package com.user.user.Service;

import com.user.user.Model.User;
import com.user.user.Repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER=LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findUserById(int id) {
        try {
            return userRepository.findById(id);
        }catch(Exception exception){
            LOGGER.error("User not found with request id : {}", id);
            return null;
        }
    }
}
