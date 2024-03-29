package com.codingdojo.studrost.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="dorms")
public class Dorm {

//----------------------------------------------------------------
//	Attributes
//----------------------------------------------------------------

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 @Size(min=2)
	 private String name;
	 @Column(updatable=false)
	 @DateTimeFormat(pattern="yyyy-MM-dd")
	 private Date createdAt;
	 @DateTimeFormat(pattern="yyyy-MM-dd")
	 private Date updatedAt;
	 @OneToMany(mappedBy="dorm", fetch = FetchType.LAZY)
	 private List<Student> student;
	 
	 
//----------------------------------------------------------------
//		Constructors
//----------------------------------------------------------------

	 public Dorm() {
	 }

	 public Dorm(Long id, String name, Date createdAt, Date updatedAt, List<Student> students) {
		 this.id = id;
		 this.name = name;
		 this.createdAt = createdAt;
		 this.updatedAt = updatedAt;
		 this.student = students;
	 }
	 
	 
//----------------------------------------------------------------
//		Getters and Setter
//----------------------------------------------------------------

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStudents() {
		return student;
	}

	public void setStudents(List<Student> students) {
		this.student = students;
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