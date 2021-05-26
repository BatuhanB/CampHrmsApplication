package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import kodlamaio.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends User{

		// @Id
		// @GeneratedValue(strategy = GenerationType.IDENTITY)
		// @Column(name = " id")
		// private int user_id;
		
		@Column(name = "first_name")
		private String firstName;

		@Column(name = "last_name")
		private String last_name;

		public Employee(Integer id,String email,String password,String firstName, String last_name) {
			super(id,email,password);
			this.firstName = firstName;
			this.last_name = last_name;
		}

}
