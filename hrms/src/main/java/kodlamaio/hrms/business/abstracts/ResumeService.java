package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.JobSeekerResumeDto;

public interface ResumeService {

	Result add(JobSeekerResumeDto resumeDto,int JobSeekerId);
}
