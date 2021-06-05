package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Experience;

public interface ExperienceService {

	Result add(Experience experience);
	
	Result addAll(List<Experience> experience);

	Result update(Experience experience);

	Result delete(int id);

	DataResult<Experience> getById(int id);

	DataResult<List<Experience>> getAll();

	DataResult<List<Experience>> getByidOrderByEndAtAsc(int id);

	DataResult<List<Experience>> getByJobseekerId(int id);
}
