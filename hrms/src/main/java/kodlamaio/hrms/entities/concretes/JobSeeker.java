package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kodlamaio.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "job_seeker")
@Data
@PrimaryKeyJoinColumn(name="user_id",referencedColumnName = "id")
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class JobSeeker extends User {

	// @Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	// @Column(name = " id")
	// private int user_id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "identity_number")
	private String identityNumber;

	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;
	
	@Column(name = "verify_mernis")
	private boolean verifyMernis = false;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")
	private List<School> school;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")
	private List<Skill> skill;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")
	private List<Link> link;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")
	private List<Language> language;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")
	private List<Experience> experience;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")
	private List<CoverLetter> coverLetter;	

	@JsonIgnore
	@OneToOne(mappedBy = "jobSeeker", optional=false, fetch=FetchType.LAZY)
	private Image image;

	

	public JobSeeker(Integer id, String email, String password, String firstName, String last_name,
			String identityNumber, LocalDate dateOfBirth, boolean verifyMernis, LocalDate createdAt, boolean isActive,
			boolean isDeleted) {
		super(id, email, password, createdAt, isActive, isDeleted);
		this.firstName = firstName;
		this.lastName = last_name;
		this.identityNumber = identityNumber;
		this.dateOfBirth = dateOfBirth;
		this.verifyMernis = verifyMernis;
	}

}
