package web.dao;

import web.models.User;

import java.util.List;

public interface UserDao {
    public List<User> getUsersFromList();

    public User getById(long id);

    public void save(User user);

    public void update(User user);

    public void delete(long id);
}
