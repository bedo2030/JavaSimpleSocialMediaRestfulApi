package com.abdullahhegazy.rest.webservices.restful_web_services.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
    private static int COUNT =0;

    private static List<User> users = new ArrayList<>();
    static {
	  users.add(new User(++COUNT, "Abdullah", LocalDate.now().minusYears(31)));
	  users.add(new User(++COUNT, "Mohamed", LocalDate.now().minusYears(30)));
	  users.add(new User(++COUNT, "Saad", LocalDate.now().minusYears(26)));
    }
    
    public User save(User user) {
	  user.setId(++COUNT);
	  users.add(user);
	  return user;
    }
    
    public List<User> findAll() {
	  return users;
    }

    public User findOne(int id) {
	  Predicate<? super User> predicate = user -> user.getId() == id;
	  return users.stream().filter(predicate).findFirst().orElse(null);
    }
    
    public void deleteById(int id) {
	  Predicate<? super User> predicate = user -> user.getId() == id;
	  users.removeIf(predicate);
    }
}
