package kodlamaio.hrms.core.utilities.adapters;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.mernis.FakeMernisService;

@Service
public class MernisServiceAdapter implements MernisService {

	@Override
	public boolean verifyByMernis(String nationalityId, String firstName, String lastName, int dateOfBirth) {
		FakeMernisService fakeMernisService = new FakeMernisService();

		boolean result = true;
		if (fakeMernisService.ValidateByPersonalInfo(nationalityId, firstName, lastName, dateOfBirth)) {
			result = true;
		} else
			result = false;

		return result;
	}

}
