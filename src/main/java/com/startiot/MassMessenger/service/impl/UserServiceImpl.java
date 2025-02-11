package com.startiot.MassMessenger.service.impl;

import com.startiot.MassMessenger.domain.User;
import com.startiot.MassMessenger.repository.UserRepository;
import com.startiot.MassMessenger.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service("userService")
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override public void saveUser(User user) { userRepository.save(user); }

}