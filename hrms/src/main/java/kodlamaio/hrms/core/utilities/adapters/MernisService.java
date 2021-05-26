package kodlamaio.hrms.core.utilities.adapters;

public interface MernisService {

	boolean verifyByMernis(String nationalityId,String firstName,String lastName,int dateOfBirth);
}
