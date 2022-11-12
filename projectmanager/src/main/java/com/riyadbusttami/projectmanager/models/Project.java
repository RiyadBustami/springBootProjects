package com.riyadbusttami.projectmanager.models;

import java.text.SimpleDateFormat;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="projects")
public class Project {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="Title must be provided.")
	private String title;
	
	@NotBlank
	@Size(min=3,message="Description must be at least 3 characters.")
	private String description;
	
	@NotNull(message = "Due date must be provided")
	@FutureOrPresent(message="Due date must be in the future")
    @DateTimeFormat(pattern="yyyy-MM-dd")	
	private Date dueDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "leader_id",updatable = false)
	private User leader;
	
	@Column(updatable = false)
	@OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
	private List<Task> tasks;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "members_projects",
		joinColumns = @JoinColumn(name = "project_id"),
		inverseJoinColumns = @JoinColumn(name = "member_id")
	)
	private List<User> members;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public String getdueDateFormatted() {
		
		return new SimpleDateFormat("MMMM dd").format(this.dueDate);
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public User getLeader() {
		return leader;
	}
	public void setLeader(User leader) {
		this.leader = leader;
	}
	public List<Task> getTasks() {
		return tasks;
	}
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	public List<User> getMembers() {
		return members;
	}
	public void setMembers(List<User> members) {
		this.members = members;
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
