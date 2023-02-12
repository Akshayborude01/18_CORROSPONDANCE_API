package com.spring.user.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.user.entities.AppUser;

public interface AppUserRepo extends JpaRepository<AppUser, Serializable> {
	
	public AppUser findByCaseNum();
	public AppUser findByAppId(Integer appId);

}
