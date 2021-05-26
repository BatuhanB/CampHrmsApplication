package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "activation_email")
@AllArgsConstructor
@NoArgsConstructor
public class ActivationEmail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "company_id")
	private int companyId;
	
	@Column(name="activation_code")
	private String activationCode;
	
	@Column(name="is_confirmed")
	private boolean isConfirmed;

	public ActivationEmail(int companyId, String activationCode, boolean isConfirmed) {
		super();
		this.companyId = companyId;
		this.activationCode = activationCode;
		this.isConfirmed = isConfirmed;
	}
	
	
}
