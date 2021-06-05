package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Link;

public interface LinkService {

	Result add(Link link);
	
	Result addAll(List<Link> link);

	Result update(Link link);

	Result delete(int id);

	DataResult<Link> getById(int id);

	DataResult<List<Link>> getAll();

	DataResult<List<Link>> getByJobseekerId(int id);
}
