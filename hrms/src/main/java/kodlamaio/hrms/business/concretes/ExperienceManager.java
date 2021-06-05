package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ExperienceDao;
import kodlamaio.hrms.entities.concretes.Experience;

@Service
public class ExperienceManager implements ExperienceService{

	private ExperienceDao experienceDao;
	
	@Autowired
	public ExperienceManager(ExperienceDao experienceDao) {
		super();
		this.experienceDao = experienceDao;
	}

	@Override
	public Result add(Experience experience) {
		this.experienceDao.save(experience);
		return new SuccessResult("Experience has been successfully added.");
	}
	
	@Override
    public Result addAll(List<Experience> experience) {
		experienceDao.saveAll(experience);
        return new SuccessResult("Experience has been successfully added.");
    }

	@Override
	public Result update(Experience experience) {
		this.experienceDao.save(experience);
		return new SuccessResult("Experience has been successfully updated.");
	}

	@Override
	public Result delete(int id) {
		this.experienceDao.deleteById(id);
		return new SuccessResult("Experience has been successfully deleted.");
	}

	@Override
	public DataResult<Experience> getById(int id) {
		return new SuccessDataResult<Experience>(this.experienceDao.getById(id));
	}

	@Override
	public DataResult<List<Experience>> getAll() {
		return new SuccessDataResult<List<Experience>>(this.experienceDao.findAll());
	}

	@Override
	public DataResult<List<Experience>> getByidOrderByEndAtAsc(int id) {
		return new SuccessDataResult<List<Experience>>(this.experienceDao.getByJobSeeker_idOrderByCreatedDateAsc(id));
	}

	@Override
	public DataResult<List<Experience>> getByJobseekerId(int id) {
		return new SuccessDataResult<List<Experience>>(this.experienceDao.getByJobSeeker_id(id));
	}

}
