package com.spring.user.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.user.entities.PdfResponse;

public interface PdfResponseRepository extends JpaRepository<PdfResponse, Serializable>{

}
