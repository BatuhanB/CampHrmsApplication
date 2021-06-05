package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import kodlamaio.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employees")
@Data
@PrimaryKeyJoinColumn(name="id",referencedColumnName = "id")
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends User {

	// @Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	// @Column(name = " id")
	// private int user_id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String last_name;

	public Employee(Integer id, String email, String password, String firstName, String last_name, LocalDate createdAt,
			boolean isActive, boolean isDeleted) {
		super(id, email, password, createdAt, isActive, isDeleted);
		this.firstName = firstName;
		this.last_name = last_name;
	}

}
