package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SkillService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SkillDao;
import kodlamaio.hrms.entities.concretes.Skill;

@Service
public class SkillManager implements SkillService{

	private SkillDao skillDao;
	
	@Autowired
	public SkillManager(SkillDao skillDao) {
		super();
		this.skillDao = skillDao;
	}

	@Override
	public Result add(Skill skill) {
		this.skillDao.save(skill);
		return new SuccessResult("Skill has been successfully added.");
	}
	
	@Override
    public Result addAll(List<Skill> skill) {
		skillDao.saveAll(skill);
        return new SuccessResult("Skill has been successfully added.");
    } 

	@Override
	public Result update(Skill skill) {
		this.skillDao.save(skill);
		return new SuccessResult("Skill has been successfully updated.");
	}

	@Override
	public Result delete(int id) {
		this.skillDao.deleteById(id);
		return new SuccessResult("Skill has been successfully deleted.");
	}

	@Override
	public DataResult<Skill> getById(int id) {
		return new SuccessDataResult<Skill>(this.skillDao.getById(id));
	}

	@Override
	public DataResult<List<Skill>> getAll() {
		return new SuccessDataResult<List<Skill>>(this.skillDao.findAll());
	}

	@Override
	public DataResult<List<Skill>> getByJobseekerId(int id) {
		return new SuccessDataResult<List<Skill>>(this.skillDao.getByJobSeeker_id(id));
	}

}
