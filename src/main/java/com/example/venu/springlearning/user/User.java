/**
 * 
 */
package com.example.venu.springlearning.user;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author venugopal
 *
 */
@ApiModel(description = "User Details")
@Entity
public class User {

	@Id
	@GeneratedValue
	private int id;
	@Size(min = 2, message = "Name should have atleast 2 chars")
	@ApiModelProperty(notes = "Name should have atleast 2 chars")
	private String name;
	@Past
	@ApiModelProperty(notes= "Date should be past")
	private Date dOB;
	
	@OneToMany(mappedBy = "user")
	private List<Post> posts;
	
	/**
	 * 
	 */
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param name
	 * @param dOB
	 */
	public User(int id, String name, Date dOB) {
		super();
		this.id = id;
		this.name = name;
		this.dOB = dOB;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the dOB
	 */
	public Date getdOB() {
		return dOB;
	}
	/**
	 * @param dOB the dOB to set
	 */
	public void setdOB(Date dOB) {
		this.dOB = dOB;
	}
	
	/**
	 * @return the posts
	 */
	public List<Post> getPosts() {
		return posts;
	}
	/**
	 * @param posts the posts to set
	 */
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", dOB=" + dOB + "]";
	}
	
	
}
