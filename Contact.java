package contacts;

public class Contact {
	
	// local variables

	private String id;
	private String firstName;
	private String lastName;
	private String phoneNum;
	private String address;
	
	// constructor

	public Contact(String id, String firstName, String lastName, String phoneNum, String address) {
		setId(id);
		setFirstName(firstName);
		setLastName(lastName);
		setPhoneNum(phoneNum);
		setAddress(address);
	}
	
	// copy constructor
	
	public Contact(Contact other) {
		this(other.id, other.firstName, other.lastName, other.phoneNum, other.address);
	}
	
	// setter methods

	public void setAddress(String address) {
		if (address == null || address.isEmpty()) {
			throw new IllegalArgumentException("Address cannot be null");
		} else if (address.length() > 30) {
			throw new IllegalArgumentException("Address cannot exceed 30 characters");
		}
		
		this.address = address;
		
	}

	public void setPhoneNum(String phoneNum) {
		if (phoneNum == null || phoneNum.isEmpty() || !phoneNum.matches("\\d+")) {
			throw new IllegalArgumentException("Phone number cannot be null/nothing, and only contains numbers");
		} else if (phoneNum.length() != 10) {
			throw new IllegalArgumentException("Phone number needs to be 10 digits");
		}
		
		this.phoneNum = phoneNum;
		
	}

	public void setLastName(String lastName) {
		if (lastName == null || lastName.isEmpty()) {
			throw new IllegalArgumentException("Last name cannot be null");
		} else if (lastName.length() > 10) {
			throw new IllegalArgumentException("Last name cannot exceed 10 characters");
		}
		
		this.lastName = lastName;
		
	}

	public void setFirstName(String firstName) {
		if (firstName == null || firstName.isEmpty()) {
			throw new IllegalArgumentException("First name cannot be null");
		} else if (firstName.length() > 10) {
			throw new IllegalArgumentException("First name cannot exceed 10 characters");
		}
		
		this.firstName = firstName;
	}

	private void setId(String id) {
		if (id == null || id.isEmpty()) {
			throw new IllegalArgumentException("Id cannot be null/nothing");
		} else if (id.length() > 10) {
			throw new IllegalArgumentException("Id cannot exceed 10 characters");
		}
		
		this.id = id;	
	}
	
	// getter methods

	public String getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public String getPhoneNum() {
		return phoneNum;
	}
	
	public String getAddress() {
		return address;
	}
	
	// override equals method
	
	@Override
	public boolean equals(Object obj) {
		
		// if check for same object in memory
		if (this == obj) {
			return true;
		}
		
		// checking if the other object is null or a different class
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		
		// casting object to a Contact and comparing Strings
		Contact other = (Contact) obj;
		return id.equals(other.id)
				&& firstName.equals(other.firstName)
				&& lastName.equals(other.lastName)
				&& phoneNum.equals(other.phoneNum)
				&& address.equals(other.address);
	}

	
}
