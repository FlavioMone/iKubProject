package com.springboot.iKub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.iKub.Entity.ProjectModification;

@Repository
public interface ProjectModificationRepository extends JpaRepository<ProjectModification, Long>{

}
