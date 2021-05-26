package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ActivationEmailService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.dataAccess.abstracts.ActivationEmailDao;
import kodlamaio.hrms.entities.concretes.ActivationEmail;

@Service
public class ActivationEmailManager implements ActivationEmailService{
	
	private ActivationEmailDao activationDao;

	@Autowired
	public ActivationEmailManager(ActivationEmailDao activationDao) {
		super();
		this.activationDao = activationDao;
	}

	@Override
	public Result add(ActivationEmail activationEmail) {
		this.activationDao.save(activationEmail);
		return null;
	}

}
