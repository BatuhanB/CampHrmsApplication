package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.ActivationEmail;

public interface ActivationEmailDao extends JpaRepository<ActivationEmail, Integer>{

}
