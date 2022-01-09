package web.dao;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Component;
import web.models.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAO {
    private static long PEOPLE_COUNT;

    @PersistenceContext
    EntityManager entityManager;

    /*    public UserDAO(EntityManager em) {
            this.em = em;
        }*/
    private List<User> people;

    {
        people = new ArrayList<>();
        people.add(new User(++PEOPLE_COUNT, "Andrey1", "Kuimov1", "kuimov1@mail.ru"));
        people.add(new User(++PEOPLE_COUNT, "Andrey2", "Kuimov2", "kuimov2@mail.ru"));
        people.add(new User(++PEOPLE_COUNT, "Andrey3", "Kuimov3", "kuimov3@mail.ru"));
        people.add(new User(++PEOPLE_COUNT, "Andrey4", "Kuimov4", "kuimov4@mail.ru"));
    }


    public List<User> index() {
        return entityManager.createQuery("SELECT a FROM User a", User.class).getResultList();
    }

    public User show(int id) {
        return people.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    @Transactional
    public void save(User user) {
        entityManager.persist(user);
    }

    public void update(int id, User updateUser) {
        User personToBeUpdated = show(id);
        personToBeUpdated.setFirstName(updateUser.getFirstName());
        personToBeUpdated.setLastName(updateUser.getLastName());
        personToBeUpdated.setEmail(updateUser.getEmail());
    }

    @Transactional
    public void delete(int id) {
        entityManager.remove(id);
    }

}
