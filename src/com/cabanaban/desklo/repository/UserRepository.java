package com.cabanaban.desklo.repository;

import com.cabanaban.entity.User;
import com.cabanaban.entity.Support;
import java.util.List;

public interface UserRepository {

    public List<User> findAllUsers();

    public List<Support> findAllSupporters();

    public User findUserByID(String ID);

    public void saveUser(User user);

}
