package com.springboot.iKub;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.iKub.Entity.Project;
import com.springboot.iKub.service.ProjectServiceImpl;

@RunWith(SpringRunner.class)
class ProjectServiceTest {
	
	ProjectServiceImpl projecServiceImpl;

	@Test
	private void testGetAllProjects() {
		Project project = new Project(1L, "TestProject1", "2020-01-01", "flavio@test.com");
		Project project2 = new Project(2L, "TestProject2", "2020-01-01", "flavio@test.com");
		projecServiceImpl.saveProject(project);
		projecServiceImpl.saveProject(project2);
		
		List<Project> listOfProjects = projecServiceImpl.getAllProjects();
		assertTrue(listOfProjects != null);
	}
	
	@Test
	private void testSaveProject() {
		Project project = new Project(1L, "TestProject", "2020-01-01", "flavio@test.com");
		projecServiceImpl.saveProject(project);
		assertTrue(projecServiceImpl.getProjectById(1).getId() == 1L);
	}
	
	@Test
	private void testUpdateProject() {
		Project project = new Project(1L, "TestProject", "2020-01-01", "flavio@test.com");
		projecServiceImpl.saveProject(project);
		project.setProjectName("TestProjectUpdated");
		projecServiceImpl.updateProject(project);
		assertTrue(projecServiceImpl.getProjectById(1).getProjectName() == "TestProjectUpdated");
	}
	
	@Test
	private void testGetProjectById() {
		Project project = new Project(1L, "TestProject", "2020-01-01", "flavio@test.com");
		projecServiceImpl.saveProject(project);
		
		assertTrue(projecServiceImpl.getProjectById(1) != null);
		
	}
	
	@Test
	private void testDeleteProjectById() {
		Project project = new Project(1L, "TestProject", "2020-01-01", "flavio@test.com");
		projecServiceImpl.saveProject(project);
		
		projecServiceImpl.deleteProjectById(1);
		assertTrue(projecServiceImpl.getProjectById(1) == null);
	}

}
