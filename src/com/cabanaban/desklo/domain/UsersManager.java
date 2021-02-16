
package com.cabanaban.desklo.domain;

import com.cabanaban.desklo.repository.UserRepository;
import com.cabanaban.entity.*;

import java.util.List;

public class UsersManager {
    private final UserRepository userRepository;

    public UsersManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }   

    public List<User> getUsers() {
        return this.userRepository.findAllUsers();
    }

    public User createUser(String name, NationalID nationalID, Phone phone, EMail email, int sla) {
        User user = new User(name, nationalID, phone, email, sla);
        userRepository.saveUser(user);
        return user;
    }

    public User createSupport(String name, NationalID nationalID, Phone phone, EMail email, int sla, double costPerHour) {
        User user = new Support(costPerHour,name, nationalID, phone, email, sla);
        userRepository.saveUser(user);
        return user;
    }

    public User editUser(String userID, String name, NationalID nationalID, Phone phone, EMail email, int sla) {
        User user = userRepository.findUserByID(userID);
        user.setName(name);
        user.setNationalID(nationalID);
        user.setPhone(phone);
        user.setEmail(email);
        user.setSla(sla);
        userRepository.saveUser(user);
        return user;
    }

    public User editSupport(String userID, String name, NationalID nationalID, Phone phone, EMail email, int sla, double costPerHour) {
        Support user = (Support) userRepository.findUserByID(userID);
        user.setName(name);
        user.setNationalID(nationalID);
        user.setPhone(phone);
        user.setEmail(email);
        user.setSla(sla);
        user.setCostPerHour(costPerHour);
        userRepository.saveUser(user);
        return user;
    }
    
}
