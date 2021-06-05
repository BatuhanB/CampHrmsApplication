package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ActivationEmailService;
import kodlamaio.hrms.business.abstracts.AuthenticationService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.adapters.abstracts.MernisService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.verification.VerificationService;
import kodlamaio.hrms.entities.concretes.ActivationEmail;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@Service
public class AuthenticationManager implements AuthenticationService {

	private UserService userService;
	private JobSeekerService jobSeekerService;
	private EmployerService employerService;
	private VerificationService verificationService;
	private MernisService mernisService;
	private ActivationEmailService activationEmailService;

	@Autowired
	public AuthenticationManager(UserService userService, JobSeekerService jobSeekerService,
			EmployerService employerService, VerificationService verificationService, MernisService mernisService,
			ActivationEmailService activationEmailService) {
		super();
		this.userService = userService;
		this.jobSeekerService = jobSeekerService;
		this.employerService = employerService;
		this.verificationService = verificationService;
		this.mernisService = mernisService;
		this.activationEmailService = activationEmailService;
	}

	@Override
	public Result registerEmployer(Employer employer, String confirmPassword) {
		if (!checkInfoForEmployer(employer)) {
			return new ErrorResult("Entered information is missing.");
		}
		if (!checkEmailAndDomain(employer.getEmail(), employer.getDomainMail())) {
			return new ErrorResult("Invalid email and domain email.");
		}
		if (!confirmPassword(employer.getPassword(), confirmPassword)) {
			return new ErrorResult("Passwords do not match.");
		}
		if (!checkEmail(employer.getEmail())) {
			return new ErrorResult(employer.getEmail() + " is already exist.");
		}
		employerService.add(employer);
		String code = verificationService.sendCode();
		activationEmailRecord(employer.getId(), code, employer.getEmail());
		return new SuccessResult("Registration has been successfully completed");
	}

	@Override
	public Result registerJobseeker(JobSeeker jobseeker, String confirmPassword) {
		if (!checkInfoForJobseeker(jobseeker)) {
			return new ErrorResult("Entered information is missing.");
		}
		if (!checkIdentityNumber(jobseeker.getIdentityNumber())) {
			return new ErrorResult(jobseeker.getIdentityNumber() + " is already exist.");
		}
		if (checkIfRealPerson(jobseeker.getIdentityNumber(), jobseeker.getFirstName(), jobseeker.getLastName(),
				jobseeker.getDateOfBirth().getYear()) == false) {
			return new ErrorResult("User is not verified.");
		}
		if (!checkEmail(jobseeker.getEmail())) {
			return new ErrorResult(jobseeker.getEmail() + " is already exist.");
		}
		jobSeekerService.add(jobseeker);
		String code = verificationService.sendCode();
		activationEmailRecord(jobseeker.getId(), code, jobseeker.getEmail());
		return new SuccessResult("Registration has been successfully completed");
	}

	private boolean checkInfoForEmployer(Employer employer) {

		if (employer.getCompanyName() != null && employer.getWebsiteName() != null && employer.getDomainMail() != null
				&& employer.getPhoneNumber() != null && employer.getEmail() != null && employer.getPassword() != null) {
			return true;
		}
		return false;
	}

	private boolean checkEmailAndDomain(String email, String domain) {

		if (email != null && domain != null) {
			return true;
		}
		return false;
	}

	private boolean checkInfoForJobseeker(JobSeeker jobSeeker) {

		if (jobSeeker.getFirstName() != null && jobSeeker.getLastName() != null && jobSeeker.getIdentityNumber() != null
				&& jobSeeker.getDateOfBirth() != null && jobSeeker.getEmail() != null
				&& jobSeeker.getPassword() != null) {
			return true;
		}
		return false;
	}

	private boolean checkIdentityNumber(String identityNumber) {

		if (identityNumber.length() > 11) {
			if (this.jobSeekerService.getByIdentityNumber(identityNumber).getData() == null) {
				return true;
			}
		}
		return false;
	}

	private boolean checkIfRealPerson(String nationalId, String firstName, String lastName, int yearOfBirth) {

		if (mernisService.verifyByMernis(lastName, firstName, lastName, yearOfBirth)) {
			return true;
		}
		return false;
	}

	private boolean checkEmail(String email) {

		if (this.userService.getUserByEmail(email).getData() == null) {
			return true;
		}
		return false;
	}

	private boolean confirmPassword(String password, String confirmPassword) {

		if (!password.equals(confirmPassword)) {
			return false;
		}
		return true;
	}

	private void activationEmailRecord(int id, String code, String email) {
		ActivationEmail activationEmail = new ActivationEmail(id, code, false);
		this.activationEmailService.add(activationEmail);
		System.out.println("Activation code has been sended to : " + email);

	}

}
