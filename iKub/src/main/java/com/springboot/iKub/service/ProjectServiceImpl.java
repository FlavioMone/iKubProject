package com.springboot.iKub.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.springboot.iKub.repository.ProjectModificationRepository;
import com.springboot.iKub.repository.ProjectRepository;
import com.springboot.iKub.Entity.Project;
import com.springboot.iKub.Entity.ProjectModification;

@Service
@Component
public class ProjectServiceImpl implements ProjectService{

	private final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private ProjectModificationRepository projectModificationRepository;
	
	@Autowired
	private UserService userService;

	@Override
	public List<Project> getAllProjects() {
        LOGGER.info("Projects Uploaded");
		return projectRepository.findAll();
		
	}

	@Override
	public void saveProject(Project project) {
        LOGGER.info("Project saved: " + project);
		this.projectRepository.save(project);
		
	}
	
	@Override
	public void updateProject(Project project) {
		
		//saveProject(project);
		
		LocalDate dateModified = LocalDate.now();
		ProjectModification temp = new ProjectModification();
		temp.setProjectId(project.getId());
		temp.setDateModified(dateModified.toString());
		temp.setUserModifierEmail(userService.getLoggedUserEmail());
        LOGGER.info("Project Updated: " + project);

		this.projectModificationRepository.save(temp);
		
	}
	@Override
	public Project getProjectById(long id) {
		Optional<Project> optional = projectRepository.findById(id);
		Project project = null;
		if (optional.isPresent()) {
			project = optional.get();
		} else {
			throw new RuntimeException(" Project not found for id :: " + id);
		}
		return project;
	}
	
	
	

	@Override
	public void deleteProjectById(long id) {
        LOGGER.info("Id of Project deleted: " + id);
		this.projectRepository.deleteById(id);
	}

	@Override
	public Page<Project> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.projectRepository.findAll(pageable);
	}

	
	@Override
	public Page<ProjectModification> findPaginatedMod(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.projectModificationRepository.findAll(pageable);
	}
	
	

}
