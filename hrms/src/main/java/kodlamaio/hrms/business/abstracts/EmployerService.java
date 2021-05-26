package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerService {

	Result add(Employer employer);
	
	//Result update(Employer employer);
	//Result delete(Integer id);

	DataResult<List<Employer>> getAll();
	DataResult<Employer> getByEmail(String email);
	DataResult<Employer> getById(Integer id);
}
