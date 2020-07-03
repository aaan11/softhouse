import java.util.ArrayList;

public class FamilyMember {
	private String name;
	private String birthYear;
	private ArrayList<PhoneNumber> phoneNrs;
	private ArrayList<Address> addresses;
	
	public FamilyMember(String name, String birthYear) {
		this.name = name;
		this.birthYear = birthYear;
		this.phoneNrs = new ArrayList<PhoneNumber>();
		this.addresses = new ArrayList<Address>();
	}
	
	public void addNumber(PhoneNumber number) {
		this.phoneNrs.add(number);
	}
	
	public void addAddress(Address address) {
		this.addresses.add(address);
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\tName: ").append(this.name).append(" Birth year: ").append(this.birthYear).append("\n\t");
		
		for(PhoneNumber nr : this.phoneNrs) {
			sb.append("Nr 1: " ).append(nr.getPhone()).append(" Nr 2: ").append(nr.getPhone2()).append("\n\t");
		}
		
		for(Address address : this.addresses) {
			sb.append("Street: " ).append(address.getStreet()).append(" City: ").append(address.getCity()).append("\n\t");
		}
		
		return sb.toString();
	}
	
	public String getName() {
		return name;
	}

	public String getBirthYear() {
		return birthYear;
	}
	
	public ArrayList<PhoneNumber> getPhoneNumbers() {
		return this.phoneNrs;
	}
	
	public ArrayList<Address> getAddresses() {
		return this.addresses;
	}
}
