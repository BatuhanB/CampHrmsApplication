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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "languages")
@NoArgsConstructor
@AllArgsConstructor
public class Language {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "language")
	private String language;

	@Min(value = 1)
	@Max(value = 5)
	@Column(name = "level")
	private int level;

	@JsonIgnore
	@Column(name = "created_date", nullable = true)
	private LocalDate createdDate = LocalDate.now();

	@JsonIgnore
	@Column(name = "is_active")
	private boolean isActive;

	@JsonIgnore
	@Column(name = "is_deleted")
	private boolean isDeleted;

	@ManyToOne
	@JoinColumn(name = "job_seeker_id")
	// @JsonIgnore
	private JobSeeker jobSeeker;
}
