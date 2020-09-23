package com.springboot.iKub.Entity;

import javax.persistence.*;

@Entity
@Table(name="projects")
public class Project {

	@Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;
	
	@Column(name = "project_Name", length = 36, nullable = false)
    private String projectName;
	
	@Column(name = "date_Created", length = 36, nullable = false)
    private String dateCreated;
	
    @Column(name = "user_Creator_Email", nullable = false)
    private String userCreatorEmail;
    
    
    
	public Project() {
		super();
	}

	public Project(Long id, String projectName, String dateCreated, String userCreatorEmail) {
		super();
		this.id = id;
		this.projectName = projectName;
		this.dateCreated = dateCreated;
		this.userCreatorEmail = userCreatorEmail;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getUserCreatorEmail() {
		return userCreatorEmail;
	}

	public void setUserCreatorEmail(String userCreatorEmail) {
		this.userCreatorEmail = userCreatorEmail;
	}

	    
	
}
