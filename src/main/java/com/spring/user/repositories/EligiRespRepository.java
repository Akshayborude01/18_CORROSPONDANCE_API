package com.spring.user.repositories;

import java.io.Serializable;


import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.user.entities.EligibilityResponse;

public interface EligiRespRepository extends JpaRepository<EligibilityResponse, Serializable> {

	public EligibilityResponse findByCaseNum(long caseNum);
}
