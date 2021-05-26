package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.abstracts.User;

public interface UserService {

	Result add(User user);
	
	//Result update(User user);
	//Result delete(User user);
	
	DataResult<List<User>> getAll();
	DataResult<User> getUserByEmail(String email);
	DataResult<User> getUserById(Integer id);
	
}
