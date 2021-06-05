package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.dtos.JobSeekerResumeDto;

public interface JobSeekerService {

	Result add(JobSeeker jobSeeker);
	//Result update(JobSeeker jobseeker);
	//Result delete(JobSeeker jobseeker);
	
	DataResult<List<JobSeeker>> getAll();
	DataResult<JobSeeker> getByIdentityNumber(String identityNumber);
	DataResult<JobSeeker> getById(int id);
	DataResult<JobSeekerResumeDto> getJobseekerResumeById(int id);
}
