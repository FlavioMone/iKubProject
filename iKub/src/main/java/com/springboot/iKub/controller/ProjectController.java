package com.springboot.iKub.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.iKub.Entity.Project;
import com.springboot.iKub.Entity.ProjectModification;
import com.springboot.iKub.service.ProjectService;
import com.springboot.iKub.service.UserService;

@Controller
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable(value="pageNo") int pageNo,
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		
		int pageSize = 5;
		
		Page<Project> page = this.projectService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Project> listProject = page.getContent();
				
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reserveSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("listProjects", listProject);
		
		return "projectsPage";
	}
	
	
	//display List of projects
	@GetMapping("/projects")
	public String viewProjectPage(Model model) {
		return findPaginated(1, "projectName", "asc", model);
	}
	
	
	@GetMapping("/showNewProjectForm")
	public String showNewProjectForm(Model model) {
		//create model attribute to bind form data
		Project project = new Project();
		model.addAttribute("project", project);
		return "newProject";
	}
	
	@PostMapping("/saveProject")
	public String saveProject(@ModelAttribute("project") Project project) {
		//save project to database
		
		LocalDate dateCreated = LocalDate.now();
		project.setUserCreatorEmail(userService.getLoggedUserEmail());
		project.setDateCreated(dateCreated.toString());
		projectService.saveProject(project);
		
		
		
		return "redirect:/projects";
	}
	
	
	@PostMapping("/updateProject")
	public String updateProject(@ModelAttribute("project") Project project) {
		//save project to database
		
		
		projectService.updateProject(project);
		
		Project p1 = projectService.getProjectById(project.getId());
		
		
		project.setUserCreatorEmail(p1.getUserCreatorEmail());
		project.setDateCreated(p1.getDateCreated());
		projectService.saveProject(project);
		
		return "redirect:/projects";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value="id") long id, Model model) {
		
		//get project from the service
		Project project = projectService.getProjectById(id);
		
		//set project as a model attribute to pre-populate the form
		model.addAttribute("project", project);
		return "updateProject";
	}
	
	@GetMapping("/deleteProject/{id}")
	public String deleteProject(@PathVariable(value="id") long id) {
		//call delete project method
		this.projectService.deleteProjectById(id);
		return "redirect:/projects"; 
	}
	
	@GetMapping("/showHistory/{id}")
	public String showHistory(@PathVariable(value="id") long id, Model model) {
		return findPaginatedMod(1, "projectId", "asc", model);
		
		
	}
	
	@GetMapping("/page2/{pageNo}")
	public String findPaginatedMod(@PathVariable(value="pageNo") int pageNo,
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		
		int pageSize = 5;
		
		Page<ProjectModification> page = this.projectService.findPaginatedMod(pageNo, pageSize, sortField, sortDir);
		List<ProjectModification> listProject = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reserveSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("listProjectsModificated", listProject);
		
		return "projectHistory";
	}
	
	
	
}
