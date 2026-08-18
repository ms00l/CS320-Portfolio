package contacts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContactTest {
	
	//////////////////////////////////
	/// test variables             ///
	//////////////////////////////////
	
	private final String VALID_ID_MIN = "1";
	private final String VALID_ID_MAX = "1234567890";
	private final String VALID_FIRSTNAME_MIN = "t";
	private final String VALID_FIRSTNAME_MAX = "tencharact";
	private final String INVALID_FIRSTNAME = "samsunggalaxys7";
	private final String VALID_LASTNAME_MAX = "tencharact";
	private final String VALID_LASTNAME_MIN = "t";
	private final String INVALID_LASTNAME = "woahnelly!!!";
	private	final String VALID_NUM = "1234567899";
	private final String INVALID_NUM = "1234567896456519";
	private final String VALID_ADDR = "123 tito ave";
	private final String INVALID_ADDR = "182736 new york hampshireton avenue of the stars street";
	
	//////////////////////////////////
	/// tests for the ID           ///
	//////////////////////////////////
	
	// testing for min length ID
	@Test
	public void testID_withMinLengthValidId_IsSuccessful() {
		Contact myTestContact = new Contact(VALID_ID_MIN, "elderscrol", "skyrim", "1234567899", "123 tito ave");
		Assertions.assertEquals(VALID_ID_MIN, myTestContact.getId());
	}
	
	// testing for null ID
	@Test
	public void testID_withNullValue_throwsIllegalArgumentException() {		
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact(null, "spiderman", "oblivion", "1234567899", "123 tito ave"));
	}
	
	// testing for ID > 10 chars
	@Test
	public void testID_withMoreThanMaxCharacters_throwsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact("12345678901", "cereal", "morrowind", "1234567899", "123 tito ave"));
	}
	
	// testing for ID == 10 chars
	@Test
	public void testID_withMaxCharacters_IsSuccessful() {
		
		Contact myTestContact = new Contact(VALID_ID_MAX, "fortnite", "gta6", "1234567899", "123 tito ave");
		Assertions.assertEquals(VALID_ID_MAX, myTestContact.getId());
	}
	
	// testing for ID == empty string
	@Test
	public void testID_withEmptyString_throwsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact("", "god", "ofwar", "1234567899", "123 tito ave"));
	}

	//////////////////////////////////
	/// tests for the firstName    ///
	//////////////////////////////////
	
	
	// testing for first name <= 10 chars
	@Test
	public void testFirstName_withMaxCharacters_IsSuccessful() {
		
		Contact myTestContact = new Contact("12345", VALID_FIRSTNAME_MAX, "xfiles", "1234567899", "123 tito ave");
		Assertions.assertEquals(VALID_FIRSTNAME_MAX, myTestContact.getFirstName());
	}
	
	// testing for first name > 10 chars
	@Test
	public void testFirstName_withMoreThanMaxCharacters_throwsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact("888376", INVALID_FIRSTNAME, "iphone", "1234567899", "123 tito ave"));
	}
	
	// testing for null first name
	@Test
	public void testFirstName_withNullValue_throwsIllegalArgumentException() {		
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact("11234", null, "scully", "1234567899", "123 tito ave"));
	}
	
	
	// testing for min length first name
	@Test
	public void testFirstName_withMinLengthValidName_IsSuccessful() {
		
		Contact myTestContact = new Contact("54672", VALID_FIRSTNAME_MIN, "mulder", "1234567899", "123 tito ave");
		Assertions.assertEquals(VALID_FIRSTNAME_MIN, myTestContact.getFirstName());
	}
	
	// testing for first name == empty string
	@Test
	public void testFirstName_withEmptyString_throwsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact("6487", "", "joerogan", "1234567899", "123 tito ave"));
	}

	
	//////////////////////////////////
	/// tests for the lastName    ///
	//////////////////////////////////
	
	
	// testing for last name <= 10 chars
	@Test
	public void testLastName_withMaxCharacters_IsSuccessful() {
		Contact myTestContact = new Contact("12345", "hi", VALID_LASTNAME_MAX, "1234567899", "123 tito ave");
		Assertions.assertEquals(VALID_LASTNAME_MAX, myTestContact.getLastName());
	}
	
	// testing for last name > 10 chars
	@Test
	public void testLastName_withMoreThanMaxCharacters_throwsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact("1231", "swag", INVALID_LASTNAME, "1234567899", "123 tito ave"));
	}
	
	// testing for null last name
	@Test
	public void testLastName_withNullValue_throwsIllegalArgumentException() {		
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact("11234", "hi", null, "1234567899", "123 tito ave"));
	}
	
	// testing for min length last name
	@Test
	public void testLastName_withMinLengthValidName_IsSuccessful() {
		Contact myTestContact = new Contact("54672", "hi", VALID_LASTNAME_MIN, "1234567899", "123 tito ave");
		Assertions.assertEquals(VALID_LASTNAME_MIN, myTestContact.getLastName());
	}
	
	// testing for last name == empty string
	@Test
	public void testLastName_withEmptyString_throwsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact("81596", "lilwayne", "", "1234567899", "123 tito ave"));
	}
	
	//////////////////////////////////
	/// tests for the phoneNum     ///
	//////////////////////////////////
	
	// testing for min length phone num
	@Test
	public void testNum_withMinLengthValidNum_IsSuccessful() {
		Contact myTestContact = new Contact("8241", "elderscrol", "skyrim", VALID_NUM, "123 tito ave");
		Assertions.assertEquals(VALID_NUM, myTestContact.getPhoneNum());
	}
	
	// testing for null phone num
	@Test
	public void testNum_withNullValue_throwsIllegalArgumentException() {		
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact("231497", "spiderman", "oblivion", null, "123 tito ave"));
	}
	
	// testing for phone num > 10 chars
	@Test
	public void testNum_withMoreThanMaxCharacters_throwsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact("123456", "ashanti", "morrowind", INVALID_NUM, "123 tito ave"));
	}
	
	// testing for phone num == 10 chars
	@Test
	public void testNum_withMaxCharacters_IsSuccessful() {
		Contact myTestContact = new Contact("9286342", "fortnite", "gta6", VALID_NUM, "123 tito ave");
		Assertions.assertEquals(VALID_NUM, myTestContact.getPhoneNum());
	}
	
	// testing for phone num == empty string
	@Test
	public void testNum_withEmptyString_throwsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact("78215664", "god", "ofwar", "", "123 tito ave"));
	}
	
	//////////////////////////////////
	/// tests for the address      ///
	//////////////////////////////////
	
	// testing for min length address
	@Test
	public void testAddr_withMinLengthValidAddr_IsSuccessful() {
		Contact myTestContact = new Contact("8241", "elderscrol", "skyrim", "1234567899", VALID_ADDR);
		Assertions.assertEquals(VALID_ADDR, myTestContact.getAddress());
	}
	
	// testing for null address
	@Test
	public void testAddr_withNullValue_throwsIllegalArgumentException() {		
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact("231497", "spiderman", "oblivion", "1234567899", null));
	}
	
	// testing for address > 30 chars
	@Test
	public void testAddr_withMoreThanMaxCharacters_throwsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact("123456", "ashanti", "morrowind", "1234567899", INVALID_ADDR));
	}
	
	// testing for address == empty string
	@Test
	public void testAddr_withEmptyString_throwsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact("78215664", "god", "ofwar", "1234567899", ""));
	}
		
}
