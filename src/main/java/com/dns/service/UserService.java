package com.dns.service;

import com.dns.pojo.Login;
import com.dns.pojo.User;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;


public interface UserService {
//
//  int register(User user);

  User validateUser(Login login);
}
