package ru.job4j;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.job4j.models.User;
import java.sql.Timestamp;
import java.util.List;

public class HibernateRun {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();

        User user1 = new User("First", "123", new Timestamp(System.currentTimeMillis()));
        User user2 = new User("Second", "43334", new Timestamp(System.currentTimeMillis()));
        session.save(user1);
        int id = (int) session.save(user2);

        System.out.println("Получаем все юзеров ");
        List users = session.createQuery("from User").list();
        users.stream().forEach(System.out::println);

        System.out.println("Получаем по id " + id);
        User foundUser = session.get(User.class, id);
        System.out.println(foundUser);

        System.out.println("Обновляем ");
        foundUser.setLogin("Update User");
        session.update(foundUser);
        id = foundUser.getId();
        User updatedUser = session.get(User.class, id);
        System.out.println("Обновленный юзер c id " + id + " " + updatedUser);

        System.out.println("Удаляем юзера с id " + id);
        session.delete(foundUser);

        System.out.println("Снова получаем все юзеров ");
        List all = session.createQuery("from User").list();
        all.stream().forEach(System.out::println);

        session.getTransaction().commit();
        session.close();
        factory.close();
    }
}
