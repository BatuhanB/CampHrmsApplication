package kodlamaio.hrms.entities.abstracts;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@JsonIgnore
	@Column(name = "created_date",columnDefinition = "Date defult CURRENT_DATE")
	private LocalDate createdAt = LocalDate.now();

	@JsonIgnore
	@Column(name = "is_active",columnDefinition = "boolean default true")
	private boolean isActive = true;

	@JsonIgnore
	@Column(name = "is_deleted", columnDefinition = "boolean default false")
	private boolean isDeleted = false;

}
