package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CoverLetterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CoverLetterDao;
import kodlamaio.hrms.entities.concretes.CoverLetter;

@Service
public class CoverLetterManager implements CoverLetterService{

	private CoverLetterDao coverLetterDao;
	
	@Autowired
	public CoverLetterManager(CoverLetterDao coverLetterDao) {
		super();
		this.coverLetterDao = coverLetterDao;
	}

	@Override
	public Result add(CoverLetter coverLetter) {
		this.coverLetterDao.save(coverLetter);
		return new SuccessResult("Coverletter has been successfully added.");
	}
	
	@Override
    public Result addAll(List<CoverLetter> coverLetter) {
        coverLetterDao.saveAll(coverLetter);
        return new SuccessResult("Coverletter has been successfully added.");
    }

	@Override
	public Result update(CoverLetter coverLetter) {
		this.coverLetterDao.save(coverLetter);
		return new SuccessResult("Coverletter has been successfully updated.");
	}

	@Override
	public Result delete(int id) {
		this.coverLetterDao.deleteById(id);
        return new SuccessResult("Coverletter has been successfully deleted.");
	}

	@Override
	public DataResult<CoverLetter> getById(int id) {
		return new SuccessDataResult<CoverLetter>(this.coverLetterDao.getById(id));
	}

	@Override
	public DataResult<List<CoverLetter>> getAll() {
		return new SuccessDataResult<List<CoverLetter>>(this.coverLetterDao.findAll());
	}

	
}
