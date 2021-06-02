package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobAdvert;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer>{
	
	@Query("From JobAdvert where isOpen = true")
	List<JobAdvert> getAllOpen();

	@Query("From JobAdvert where isOpen = true Order By publishDate Asc")
	List<JobAdvert> getByOpenOrderByPublishDateAsc();
	
	@Query("From JobAdvert where isOpen = true and employer.id =:id ")
	List<JobAdvert> getOpenAndEmployer_Id(int id);

}
