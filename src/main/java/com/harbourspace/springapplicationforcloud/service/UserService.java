package com.harbourspace.springapplicationforcloud.service;

import com.harbourspace.springapplicationforcloud.entity.AppUser;
import com.harbourspace.springapplicationforcloud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public AppUser createNewUser(AppUser appUser) {
        return userRepository.save(appUser);
    }
}
