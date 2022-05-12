package web.service;

import web.models.User;

import java.util.List;

public interface UserService {
    List<User> getUsersList();

    User getById(long id);

    void save(User user);

    void update(User user);

    void delete(long id);
}
