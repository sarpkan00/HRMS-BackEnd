package kodlamaio.HumanRMS.core.utilities.adapters;

public interface ValidationService {
	
	boolean validateByMernis(String firstName, String lastName,long nationalityId, int birthYear);
}
