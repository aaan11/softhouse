import java.util.ArrayList;

public class Person {
	private String firstName;
	private String lastName;
	
	private ArrayList<PhoneNumber> phoneNrs;
	private ArrayList<Address> addresses;
	private ArrayList<FamilyMember> family;
	
	public Person(String firstName, String lastName) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		
		this.phoneNrs = new ArrayList<PhoneNumber>();
		this.addresses = new ArrayList<Address>();
		this.family = new ArrayList<FamilyMember>();
	}
	
	public void addNumber(PhoneNumber nr) {
		this.phoneNrs.add(nr);
	}
	
	public void addAddress(Address address) {
		this.addresses.add(address);
	}
	
	public void addFamily(FamilyMember family) {
		this.family.add(family);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public ArrayList<Address> getAddresses() {
		return this.addresses;
	}

	public ArrayList<PhoneNumber> getPhoneNumbers() {
		return this.phoneNrs;
	}
	
	public ArrayList<FamilyMember> getFamily() {
		return this.family;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("First name: ").append(this.firstName).append(" Last name: ").append(this.lastName).append("\n");
		
		for(PhoneNumber nr : this.phoneNrs) {
			sb.append("Nr 1: " ).append(nr.getPhone()).append(" Nr 2: ").append(nr.getPhone2()).append("\n");
		}
		
		for(Address address : this.addresses) {
			sb.append("Street: " ).append(address.getStreet()).append(" City: ").append(address.getCity()).append("\n");
		}
		
		//sb.append("\t");
		
		for(FamilyMember fam : this.family) {
			sb.append(fam).append("\n");
		}
		
		return sb.toString();
	}
}
