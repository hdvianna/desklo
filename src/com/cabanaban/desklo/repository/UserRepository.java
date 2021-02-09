package com.cabanaban.desklo.repository;

import com.cabanaban.entity.User;
import com.cabanaban.entity.Support;
import java.util.List;

public interface UserRepository {

    public abstract List<User> findAllUsers();

    public abstract List<Support> findAllSupporters();

    public abstract void saveUser(User user);

}
