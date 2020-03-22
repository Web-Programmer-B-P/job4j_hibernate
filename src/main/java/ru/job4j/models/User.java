package ru.job4j.models;

import java.sql.Timestamp;
import java.util.Objects;

public class User {
    private int id;
    private String login;
    private String password;
    private Timestamp created;

    public User() {
    }

    public User(String login, String password, Timestamp created) {
        this.login = login;
        this.password = password;
        this.created = created;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User{id=" + id
                + ", login='" + login + '\''
                + ", password='" + password + '\''
                + ", created=" + created
                + '}';
    }
}
