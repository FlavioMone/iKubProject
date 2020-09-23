package com.springboot.iKub.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="project_Modifications")
public class ProjectModification {
	
	@Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;
	
	
    @Column(name = "project_id", nullable = false)
    private Long projectId;
    
    @Column(name = "date_Modified", length = 36, nullable = false)
    private String dateModified;
    
    @Column(name = "user_Modifier_Email", nullable = false)
    private String userModifierEmail;
    
    public ProjectModification() {
		super();
	}

	public ProjectModification(Long id, Long projectId, String dateModified, String userModifierEmail) {
		super();
		this.id = id;
		this.projectId = projectId;
		this.dateModified = dateModified;
		this.userModifierEmail = userModifierEmail;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getDateModified() {
		return dateModified;
	}

	public void setDateModified(String dateModified) {
		this.dateModified = dateModified;
	}

	public String getUserModifierEmail() {
		return userModifierEmail;
	}

	public void setUserModifierEmail(String userModifierEmail) {
		this.userModifierEmail = userModifierEmail;
	}
    
}
