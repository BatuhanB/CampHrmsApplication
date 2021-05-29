package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import kodlamaio.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "job_seeker")
@Data
@PrimaryKeyJoinColumn(name = "user_id")
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
