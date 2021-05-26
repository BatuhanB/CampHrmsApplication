package kodlamaio.hrms.core.verification;

public interface VerificationService {

	void sendEmail(String email);
	String sendCode();
}
