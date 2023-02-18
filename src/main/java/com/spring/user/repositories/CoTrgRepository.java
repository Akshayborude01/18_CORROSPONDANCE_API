package com.spring.user.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.user.entities.CoTrgEntity;

public interface CoTrgRepository extends JpaRepository<CoTrgEntity, Serializable> {

	public List<CoTrgEntity> findByTrgStatus(String status);

	
}
