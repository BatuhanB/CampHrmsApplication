package kodlamaio.hrms.business.abstracts;

import org.springframework.stereotype.Component;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobSeeker;
@Component
public interface AuthenticationService {

	Result registerEmployer(Employer employer, String confirmPassword);
	Result registerJobseeker(JobSeeker jobseeker, String confirmPassword);
}
