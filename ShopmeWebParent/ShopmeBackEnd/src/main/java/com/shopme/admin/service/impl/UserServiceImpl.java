package com.shopme.admin.service.impl;


import com.shopme.admin.repository.UserRepository;
import com.shopme.admin.service.UserService;
import com.shopme.common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> listAll() {
        List<User> usersList = (List<User>) userRepository.findAll();
        return usersList;
    }
}
