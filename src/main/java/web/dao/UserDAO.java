package web.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Component;
import web.models.User;
import java.util.List;

@Component
public class UserDAO {

    @PersistenceContext
    EntityManager entityManager;

    public List<User> index() {
        return entityManager.createQuery("FROM User").getResultList();
    }

    public User getById(long id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    public void save(User user) {
        entityManager.persist(user);
    }
    @Transactional
    public void update(User user) {
        entityManager.merge(user);
    }

    @Transactional
    public void delete(User user) {
        entityManager.remove(entityManager.find(User.class, user.getId()));
    }

}
