package kodlamaio.hrms.mernis;

public class FakeMernisService {
	public boolean ValidateByPersonalInfo(String nationalityId, String firstName, String lastName, int dateOfBirth) {
		System.out.println(firstName + " " + lastName + " is valid person.");
		return true;
	}
}
