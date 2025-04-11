package com.ahrendee.in28minutes.rest.webservices.rest_web_services.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class UserDaoService {

    private static int usersCount = 0;
    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(++usersCount, "Adam", LocalDate.now().minusYears(30)));
        users.add(new User(++usersCount, "Eve", LocalDate.now().minusYears(25)));
        users.add(new User(++usersCount, "Jack", LocalDate.now().minusYears(35)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findById(int id) {
        Predicate<User> foundUser = user -> user.getId().equals(id);
        return users.stream().filter(foundUser).findFirst().orElse(null);
    }

    public User save(User user) {
        user.setId(++usersCount);
        users.add(user);
        return user;
    }

    public boolean deleteById(int id) {
        Predicate<User> foundUser = user -> user.getId().equals(id);
        return users.removeIf(foundUser);
    }

    public User updateById(int id, User user) {
        Predicate<User> foundUser = _user -> _user.getId().equals(id);
        return users.stream()
                .filter(foundUser)
                .findFirst()
                .map(_user -> {
                    _user.setName(user.getName());
                    _user.setBirthDate(user.getBirthDate());
                    return _user;
                }).get();
    }
}
