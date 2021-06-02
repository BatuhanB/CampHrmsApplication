package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertDao;
import kodlamaio.hrms.entities.concretes.JobAdvert;

@Service
public class JobAdvertManager implements JobAdvertService {

	private JobAdvertDao jobAddDao;

	@Autowired
	public JobAdvertManager(JobAdvertDao jobAddDao) {
		super();
		this.jobAddDao = jobAddDao;
	}

	@Override
	public Result add(JobAdvert jobAdvert) {

		if (!checkFields(jobAdvert)) {
			return new ErrorResult("Missing information.");
		}
		this.jobAddDao.save(jobAdvert);
		return new SuccessResult("Job advert is added.");
	}

	@Override
	public Result update(JobAdvert jobAdd) {
		this.jobAddDao.save(jobAdd);
		return new SuccessResult("Job advert is updated.");
	}

	@Override
	public Result delete(int id) {
		this.jobAddDao.deleteById(id);
		return new SuccessResult("Job advert is deleted.");
	}

	@Override
	public DataResult<JobAdvert> getById(int id) {
		return new SuccessDataResult<JobAdvert>(this.jobAddDao.getOne(id));
	}

	@Override
	public DataResult<List<JobAdvert>> getAll() {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAddDao.findAll());
	}
	
	@Override
	public Result changeOpenToClose(int id) {
		if (getById(id) == null) {
			return new ErrorResult("Job advert not available.");
		}
		if (getById(id).getData().isOpen() == false) {
			return new ErrorResult("This job advert is not active.");
		}
		JobAdvert jobAdvert = getById(id).getData();
		jobAdvert.setOpen(false);
		update(jobAdvert);
		return new SuccessResult("Job advert has been successfully closed.");
	}

	@Override
	public DataResult<List<JobAdvert>> getAllOpen() {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAddDao.getAllOpen());
	}

	@Override
	public DataResult<List<JobAdvert>> getByOpenOrderByPublishDate() {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAddDao.getByOpenOrderByPublishDateAsc());
	}

	@Override
	public DataResult<List<JobAdvert>> getOpenAndEmployer_Id(int id) {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAddDao.getOpenAndEmployer_Id(id));
	}

	private boolean checkFields(JobAdvert jobAdd) {

		if (jobAdd.getJob() != null && jobAdd.getDescription() != null && jobAdd.getCity() != null
				&& jobAdd.getOpenJobCounter() != 0) {

			return true;
		}

		return false;
	}

}
