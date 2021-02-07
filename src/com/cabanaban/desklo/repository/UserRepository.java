package com.cabanaban.desklo.repository;


import com.cabanaban.desklo.domain.User;
import com.cabanaban.desklo.domain.Support;

public interface UserRepository {

	public abstract User[] findAllUsers();

	public abstract Support[] findAllSupporters();

	public abstract void saveUser(User user);

}
