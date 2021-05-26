package kodlamaio.hrms.core.verification;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class FakeVerificationManager implements VerificationService{

	
	@Override
	public void sendEmail(String email) {
		
		System.out.println("Verification link has been sent to " + email );
	}

	@Override
	public String sendCode() {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
	}

}
