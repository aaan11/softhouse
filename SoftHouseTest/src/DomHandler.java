import java.util.ArrayList;

import javax.xml.parsers.*;
import javax.xml.transform.dom.*;

import org.w3c.dom.*;

public class DomHandler {
	Document doc;
	
	public DomHandler() throws ParserConfigurationException {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		this.doc = dBuilder.newDocument();
	}
	
	public DOMSource createXML(ArrayList<Person> persons) {
		Element rootElement = doc.createElement("people");
        doc.appendChild(rootElement);
        
        for(Person person : persons) {
        	this.personToXML(person, rootElement);
        }
		
		return new DOMSource(doc);
	}
	
	private void personToXML(Person person, Element parentElement) {
		Element personElement = doc.createElement("person");
		createElement(personElement, "firstname", person.getFirstName());
		createElement(personElement, "lastname", person.getLastName());
		parentElement.appendChild(personElement);
		
		for(Address address : person.getAddresses()) {
			addressToXML(address, personElement);
		}
		
		for(PhoneNumber phoneNr : person.getPhoneNumbers()) {
			phoneNumberToXML(phoneNr, personElement);
		}
		
		for(FamilyMember familyMember : person.getFamily()) {
			familyMemberToXML(familyMember, personElement);
		}
	}
	
	private void familyMemberToXML(FamilyMember familyMember, Element parentElement) {
		Element childElement = doc.createElement("family");
		createElement(childElement, "name", familyMember.getName());
		createElement(childElement, "born", familyMember.getBirthYear());
		parentElement.appendChild(childElement);
		
		for(Address address : familyMember.getAddresses()) {
			addressToXML(address, childElement);
		}
		
		for(PhoneNumber phoneNr : familyMember.getPhoneNumbers()) {
			phoneNumberToXML(phoneNr, childElement);
		}
	}
	
	private void addressToXML(Address address, Element parentElement) {
		Element childElement = doc.createElement("address");
		createElement(childElement, "street", address.getStreet());
		createElement(childElement, "city", address.getCity());
		if(address.getPostalNr() != null) {
			createElement(childElement, "postalnumber", address.getPostalNr());
		}
		parentElement.appendChild(childElement);		
	}
	
	private void phoneNumberToXML(PhoneNumber phoneNr, Element parentElement) {
		Element childElement = doc.createElement("phone");
		createElement(childElement, "mobile", phoneNr.getPhone());
		createElement(childElement, "mobile2", phoneNr.getPhone2());
		parentElement.appendChild(childElement);		
	}
	
	private void createElement(Element parent, String name, String value) {
		Element element = doc.createElement(name);
		element.appendChild(doc.createTextNode(value));
		parent.appendChild(element);
	}
}
