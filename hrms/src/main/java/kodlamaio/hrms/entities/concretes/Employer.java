package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import kodlamaio.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="employers")
@AllArgsConstructor
@NoArgsConstructor
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

	public Employer(Integer id,String email,String password,String companyName, String websiteName, String domainMail, String phoneNumber) {
		super(id,email,password);
		this.companyName = companyName;
		this.websiteName = websiteName;
		this.domainMail = domainMail;
		this.phoneNumber = phoneNumber;
	}

}
