package contacts;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ContactService {
	
	private List<Contact> contacts;
	
	// default constructor
	public ContactService() {
		contacts = new ArrayList<>();
	}
	
	/**
	 * deletes a contact based on its id
	 * @param id - the string id of the contact to delete
	 */
	public void delete(String id) {
		// null check
		if (id == null) {
			throw new IllegalArgumentException("Contact ID cannot be null");
		}
		
		Contact contactToDelete = null;
		
		for (Contact contact: contacts) {
			if (contact.getId().equals(id) ) {
				contactToDelete = contact;
				break;
			}
		}
		
		// if no contact found check to throw NoSuchElementException
		if (contactToDelete == null) {
			throw new NoSuchElementException("Contact ID does not exist");
		}
		
		contacts.remove(contactToDelete);
	}
	
	/**
	 * edit the contact by replacing a contact
	 * with new contact that contains
	 * updated data
	 * @param newContact updated contact object with
	 * target id and new data
	 */
	public void update(Contact newContact) {
		// null check
			if (newContact == null) {
				throw new IllegalArgumentException("Contact cannot be null");
			}
			
			Contact contactToUpdate = null;
			
			// track down contact using the id, set it to update
			for (Contact contact: contacts) {
				if (contact.getId().equals(newContact.getId())) {
					contactToUpdate = contact;
					break;
				}
			}
			
			// if no contact found check to throw NoSuchElementException
			if (contactToUpdate == null) {
				throw new NoSuchElementException("Contact ID does not exist");
			}
			
			// update the data using setter methods
			contactToUpdate.setFirstName(newContact.getFirstName());
			contactToUpdate.setLastName(newContact.getLastName());
			contactToUpdate.setPhoneNum(newContact.getPhoneNum());
			contactToUpdate.setAddress(newContact.getAddress());
	}

	/**
	 * add the contact by id
	 * if not a duplicate/null id
	 * @param newContact the contact object to add
	 */
	public void add(Contact newContact) {
		
		// check if whole contact object is null
		if (newContact == null) {
			throw new IllegalArgumentException("Contact cannot be null");
		}
		
		// set up bool variable for dupe check
		// for loop for getting contact id and new contact id and checking them
		// if the same, set bool to true then break out
		boolean isDuplicate = false;
		
		for (Contact contact: contacts) {
			if (contact.getId().equals(newContact.getId())) {
				isDuplicate = true;
				break;
			}
		}
		
		// if duplicate id throw illegal argument exception
		if (isDuplicate) {
			throw new IllegalArgumentException("Cannot add contact with duplicate ID: " + newContact.getId());
		}
		
		// add contact if not duplicate
		contacts.add(newContact);
		
	}

	/**
	 * Get the contact by id
	 * returns the contact if found
	 * otherwise returns null
	 * @param id - the contact id
	 * @return - the contact or null if id does not exist
	 */
	public Contact get(String id) {
		
		Contact foundContact = null;
		
		for (Contact contact: contacts) {
			if (contact.getId().equals(id)) {
				foundContact = contact;
				break;
			}
		}
		
		// null check
		if (foundContact == null) {
			return null;
		}
		
		return new Contact(foundContact);
	}
	
	/**
	 * grabs all contacts in service
	 * @return a new list of all contacts
	 */
	public List<Contact> getAllContacts() {
		
		// set up list to dump contacts into
		List<Contact> allContacts = new ArrayList<>();
		
		// loop through contacts and add them to the list
		for (Contact contact: contacts) {
			allContacts.add(new Contact(contact));
		}
		
		// return the dump
		return allContacts;
	}
	

}
