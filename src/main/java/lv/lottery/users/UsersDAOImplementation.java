package lv.lottery.users;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Component
public class UsersDAOImplementation implements UsersDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<UsersRegistration> getAll() {
        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<UsersRegistration> query = builder.createQuery(UsersRegistration.class);
        query.select(query.from(UsersRegistration.class));

        List<UsersRegistration> tasks = session.createQuery(query).getResultList();
        session.close();
        return tasks;
    }

    @Override
    public Optional<UsersRegistration> getById(Long id) {
        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<UsersRegistration> query = builder.createQuery(UsersRegistration.class);
        Root<UsersRegistration> root = query.from(UsersRegistration.class);
        query.where(builder.equal(root.get("id"), id));
        query.select(root);

        Optional<UsersRegistration> task = Optional.ofNullable(session.createQuery(query).getSingleResult());
        session.close();
        return task;
    }

    @Override
    public Long insert(UsersRegistration usersRegistration) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(usersRegistration);

        tx.commit();
        session.close();

        return usersRegistration.getId();
    }

    @Override
    public void update(Long userID, UsersRegistration usersRegistration) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.update(usersRegistration);

        tx.commit();
        session.close();

    }
}
