package web.service;

import web.models.User;

import java.util.List;

public interface UserService {
    public List<User> index();

    public User getById(long id);

    public void save(User user);

    public void update(User user);

    public void delete(User user);
}
