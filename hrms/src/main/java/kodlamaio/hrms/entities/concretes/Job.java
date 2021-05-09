package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "job_titles")
public class Job {

	@Id
	@GeneratedValue
	@Column(name = "job_title_id")
	private int id;
	
	@Column(name = "job_title_name")
	private String jobTitles;

	public Job() {

	}

	public Job(int id, String jobTitles) {
		super();
		this.id = id;
		this.jobTitles = jobTitles;
	}
}
