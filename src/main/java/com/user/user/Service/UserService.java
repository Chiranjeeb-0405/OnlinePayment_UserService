package com.user.user.Service;


import com.user.user.Model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public List<User> getAllUsers();

    Optional<User> findUserById(int id);
}
