package kodlamaio.hrms.business.abstracts;

import java.util.List;


import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvert;

public interface JobAdvertService {

	Result add(JobAdvert jobAdd);

	Result update(JobAdvert jobAdd);

	Result delete(int id);

	Result changeOpenToClose(int id);

	DataResult<JobAdvert> getById(int id);

	DataResult<List<JobAdvert>> getAll();

	DataResult<List<JobAdvert>> getAllOpen();

	DataResult<List<JobAdvert>> findAllByOpenOrderByPublishDate();

	DataResult<List<JobAdvert>> getAllOpenAndEmployer_Id(int id);
}
