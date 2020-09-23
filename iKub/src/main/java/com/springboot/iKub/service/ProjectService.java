package com.springboot.iKub.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.springboot.iKub.Entity.Project;
import com.springboot.iKub.Entity.ProjectModification;

public interface ProjectService {
	
	List<Project> getAllProjects();
	void saveProject(Project project);
	void updateProject(Project project);
	Project getProjectById(long id);
	void deleteProjectById(long id);
	Page<Project> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
	Page<ProjectModification> findPaginatedMod(int pageNo, int pageSize, String sortField, String sortDirection);
	
}
