package contacts;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
	
	private ContactService service;
	
	// reset test before each
	@BeforeEach
	public void setup() {
		service = new ContactService();
	}
	
	//////////////////////////////////
	/// ADD                        ///
	//////////////////////////////////
	
	
	@Test
	public void testAdd_withNewElement_successfullyAdds() {
		// arrange create a new contact
		// act add it to the service
		// assert check that the new contact was added
		
		Contact newContact = new Contact("1", "leon", "kennedy", "1234567899", "123 tito ave");
		
		service.add(newContact);
		
		Assertions.assertEquals(service.get(newContact.getId()), newContact);
		
	}
	
	@Test
	public void testAdd_withDuplicateElement_throwsIllegalArgumentException() {
		Contact newContact = new Contact("1", "leon", "kennedy", "1234567899", "123 tito ave");
		
		// act check that the contact doesnt exist
		// then add to the list
		service.add(newContact);
		Assertions.assertNotNull(service.get(newContact.getId()));
		
		// assert should get a illegal argument exception
		// when adding same element
		Assertions.assertThrows(IllegalArgumentException.class, () -> service.add(newContact));
	}
	
	@Test
	public void testAdd_isNull_throwsIllegalArgumentException() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> service.add(null));
		
	}

	//////////////////////////////////
	/// DELETE                     ///
	//////////////////////////////////
	
	
	@Test
	public void testDelete_withExistingElement_isSuccessful() {
		Contact newContact = new Contact("1", "leon", "kennedy", "1234567899", "123 tito ave");
		
		service.add(newContact);
		
		// act delete contact
		service.delete("1");
		
		// assert search for id results in null 
		Assertions.assertNull(service.get("1"));
		
	}
	
	@Test
	public void testDelete_withNonExistingElement_throwsNoSuchElementException() {
		
		// assert attempting to delete an id that doesnt exist
		// throws no such element exception
		
		Assertions.assertThrows(NoSuchElementException.class, () -> service.delete("999"));
	}
 
	@Test
	public void testDelete_isNull_throwsIllegalArgumentException() {
		
		// assert attempting to delete an id that is null
		// throws illegal argument exception
		Assertions.assertThrows(IllegalArgumentException.class, () -> service.delete(null));
	}
	 
	//////////////////////////////////
	/// EDIT                       ///
	//////////////////////////////////
	
	@Test
	public void testEdit_withExistingElement_isSuccessful() {
		
		// arrange add a contact
		Contact initialContact = new Contact("1", "leon", "kennedy", "1234567899", "123 tito ave");
		service.add(initialContact);
		
		// act create a new contact with same ID but different data
		Contact newContact = new Contact("1", "Claire", "Redfield", "1234556454", "98 raccoon st");
		service.update(newContact);
		
		// assert grab contact and verify data
		Contact fetchContact = service.get("1");
		Assertions.assertEquals("Claire", fetchContact.getFirstName());
		Assertions.assertEquals("Redfield", fetchContact.getLastName());
		Assertions.assertEquals("1234556454", fetchContact.getPhoneNum());
		Assertions.assertEquals("98 raccoon st", fetchContact.getAddress());
		
	}
	
	@Test
	public void testEdit_withNonExistingElement_throwsNoSuchElementException() {
		
		// assert attempting to edit an id that doesnt exist
		// throws no such element exception
		Contact newContact = new Contact("6549819", "Claire", "Redfield", "1234556454", "98 raccoon st");
		Assertions.assertThrows(NoSuchElementException.class, () -> service.update(newContact));
	}
	
	@Test
	public void testEdit_isNull_throwsIllegalArgumentException() {
		
		// assert attempting to edit an id that is null
		// throws no such element exception
		Assertions.assertThrows(IllegalArgumentException.class, () -> service.update(null));
	}

}
