package com.cabanaban.desklo.repository;

import com.cabanaban.desklo.domain.User;
import com.cabanaban.desklo.domain.Support;
import java.util.List;

public interface UserRepository {

    public abstract List<User> findAllUsers();

    public abstract List<Support> findAllSupporters();

    public abstract void saveUser(User user);

}
