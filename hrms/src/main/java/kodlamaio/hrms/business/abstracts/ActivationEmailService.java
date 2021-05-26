package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ActivationEmail;

public interface ActivationEmailService {

	Result add(ActivationEmail activationEmail);
}
