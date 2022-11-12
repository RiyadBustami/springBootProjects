package com.riyadbusttami.projectmanager.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="users",uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Email is required!")
    @Email(message="Please enter a valid email!")
	private String email;
	
	@NotBlank(message="First name is required!")
    @Size(min=3, max=30, message="First name must be between 3 and 30 characters")
	private String firstName;
	
	@NotBlank(message="Last name is required!")
    @Size(min=3, max=30, message="Last name must be between 3 and 30 characters")
	private String lastName;
	
	@NotEmpty(message="Password is required!")
	@Size(min=8, max=128, message="Confirm Password must be between 8 and 128 chars")
	private String password;
	
	@Transient
	@NotEmpty(message="Confirm password is required!")
	@Size(min=8, max=128, message="Confirm Password must be between 8 and 128 chars")
	private String confirm;
	
	@OneToMany(mappedBy = "leader", fetch = FetchType.LAZY)
	private List<Project> leadingProjects;
	
	@OneToMany(mappedBy = "creator", fetch = FetchType.LAZY)
	private List<Task> tasks;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "members_projects",
		joinColumns = @JoinColumn(name = "member_id"),
		inverseJoinColumns = @JoinColumn(name = "project_id")
	)
	private List<Project> joinedProjects;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
	
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
	
	public User() {}
	
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	public List<Project> getLeadingProjects() {
		return leadingProjects;
	}

	public void setLeadingProjects(List<Project> leadingProjects) {
		this.leadingProjects = leadingProjects;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public List<Project> getJoinedProjects() {
		return joinedProjects;
	}

	public void setJoinedProjects(List<Project> joinedProjects) {
		this.joinedProjects = joinedProjects;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}
