package com.dns.service;


import com.dns.pojo.Login;
import com.dns.pojo.User;
import com.dns.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

//@Configuration
//@ComponentScan("com.dns.dao")
@Service
@Configuration
@ComponentScan(basePackages="com.dns.service")
public class UserServiceImpl implements UserService {

  @Autowired
  public UserDao userDao;
 

//  public int register(User user) {
//    return userDao.addUser(user);
//  }

  public User validateUser(Login login) {
    return userDao.validateUser(login);
  }

}
