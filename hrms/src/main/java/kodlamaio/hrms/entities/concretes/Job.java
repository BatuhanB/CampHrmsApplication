package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "job_titles")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdd"})
public class Job {

	@Id
	@GeneratedValue
	@Column(name = "job_title_id")
	private int id;                                     
	
	@Column(name = "job_title_name")  
	private String jobTitle;
	
	@Column(name= "is_active", columnDefinition = "boolean default true")
	private boolean isActive = true;
	
	@Column(name= "is_deleted", columnDefinition = "boolean default false")
	private boolean isDeleted = false;

	@JsonIgnore
	@OneToMany(mappedBy = "job")
	private List<JobAdvert> jobAdd;

}
