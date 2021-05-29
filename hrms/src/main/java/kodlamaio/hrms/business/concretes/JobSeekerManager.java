package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService{

	private JobSeekerDao jobSeekerDao;
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao) {
		super();
		this.jobSeekerDao = jobSeekerDao;
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult("Jobseeker has been added.");
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll());
	}

	@Override
	public DataResult<JobSeeker> getByIdentityNumber(String identityNumber) {
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.findByIdentityNumber(identityNumber));
	}

	@Override
	public DataResult<JobSeeker> getById(int id) {
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.getOne(id));
	}

}
