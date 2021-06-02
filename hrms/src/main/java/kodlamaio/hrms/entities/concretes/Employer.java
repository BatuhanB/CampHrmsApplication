package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kodlamaio.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "employers")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdverts"})
public class Employer extends User {

	// @Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	// @Column(name = " id")
	// private int user_id;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "website_name")
	private String websiteName;

	@Column(name = "domain_email")
	private String domainMail;

	@Column(name = "phone_number")
	private String phoneNumber;

	@JsonIgnore
	@OneToMany(mappedBy = "employer")
	private List<JobAdvert> jobAdverts;


	public Employer(Integer id, String email, String password, String companyName, String websiteName,
			String domainMail, String phoneNumber, LocalDate createdAt, boolean isActive, boolean isDeleted) {
		super(id, email, password, createdAt, isActive, isDeleted);
		this.companyName = companyName;
		this.websiteName = websiteName;
		this.domainMail = domainMail;
		this.phoneNumber = phoneNumber;
	}
	
	
}
