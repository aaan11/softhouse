
public class Address {
	private String street;
	private String city;
	private String postalNr;
	
	public Address(String street, String city) {
		this.setStreet(street);
		this.setCity(city);
	}
	
	public Address(String street, String city, String postalNr) {
		this.setStreet(street);
		this.setCity(city);
		this.setPostalNr(postalNr);
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalNr() {
		return postalNr;
	}

	public void setPostalNr(String postalNr) {
		this.postalNr = postalNr;
	}
}
