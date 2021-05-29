package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "job_adverts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvert {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	//@Column(name = "job_position_id")
	//private int jobPositionId;
	
	//@Column(name = "employer_id")
	//private int employerId;
	
	//@Column(name = "city_id")
	//private int cityId;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "salary_min")
	private int salaryMin;
	
	@Column(name = "salary_max")
	private int salaryMax;
	
	@Column(name = "open_job_counter")
	private int openJobCounter;
	
	@Column(name = "application_deadline")
	private LocalDate applicationDeadline;
	
	@Column(name = "publish_date")
	private LocalDate publishDate;
	
	@Column(name = "created_date")
	private LocalDate createdDate;
	
	@Column(name = "is_open")
	private boolean isOpen;
	
	@Column(name = "is_active")
	private boolean isActive;
	
	@Column(name = "is_deleted")
	private boolean isDeleted;
	
	@ManyToOne
	@JoinColumn(name = "job_titles_id")
	private Job job;
	
	@ManyToOne
	@JoinColumn(name = "employer_id")
	private Employer employer;
	
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;
	
}
