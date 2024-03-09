package com.komarov.restaraunt_order_management_system.services;

import com.komarov.restaraunt_order_management_system.data.User;
import com.komarov.restaraunt_order_management_system.data.enums.Role;
import com.komarov.restaraunt_order_management_system.data.repositories.UserRepository;
//import com.komarov.restaraunt_order_management_system.mappers.UserDbModelToMealDtoMapper;
//import com.komarov.restaraunt_order_management_system.mappers.UserDtoToUserDbModelMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

//    private final UserDtoToUserDbModelMapper userDtoToUserDbModelMapper;
//
//    private final UserDbModelToMealDtoMapper userDbModelToMealDtoMapper;

    @Autowired
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public boolean createUser(User user) {
        String login = user.getLogin();
        if (userRepository.findByLogin(login) != null) return false;
        user.setActive(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getRoles().add(Role.ROLE_CLIENT);
        log.info("Saving new User with new login: {}", login);
        userRepository.save(user);
        return true;
    }
}
