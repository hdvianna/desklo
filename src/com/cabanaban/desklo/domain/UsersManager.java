
package com.cabanaban.desklo.domain;

import com.cabanaban.desklo.repository.UserRepository;
import com.cabanaban.entity.User;

public class UsersManager {
    private final UserRepository userRespository;

    public UsersManager(UserRepository userRespository) {
        this.userRespository = userRespository;
    }   
    
    public void saveUser(User user) {
        userRespository.saveUser(user);
    }
    
}
