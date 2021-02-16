package com.cabanaban.desklo.repository;

import com.cabanaban.entity.Support;
import com.cabanaban.entity.User;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FakeListUserRepository implements UserRepository {

    private final List<User> users;
    private long sequence;

    public FakeListUserRepository(List<User> users) {
        this.users = users;
        sequence = users.size();
    }

    @Override
    public List<User> findAllUsers() {
        return this.users;
    }

    @Override
    public List<Support> findAllSupporters() {
        return this.users
                .stream()
                .filter(user -> user.getClass() == Support.class)
                .map(user -> (Support) user)
                .collect(Collectors.toList());
    }

    @Override
    public void saveUser(User user) {
        long count = this.users
                .stream()
                .filter(listUser -> user.equals(listUser))
                .count();
        if (count == 0) {
            sequence++;
            user.setID(Long.toString(sequence));
            this.users.add(user);
        }
    }

    @Override
    public User findUserByID(String ID) {
        return null;
    }
}
