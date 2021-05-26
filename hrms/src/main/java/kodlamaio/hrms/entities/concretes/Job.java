package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "job_titles")
@AllArgsConstructor
@NoArgsConstructor
public class Job {

	@Id
	@GeneratedValue
	@Column(name = "job_title_id")
	private int id;
	
	@Column(name = "job_title_name")
	private String jobTitle;

}
