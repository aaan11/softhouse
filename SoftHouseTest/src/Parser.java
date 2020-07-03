import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Parser {
	
	private File toRead;
	private ArrayList<Person> persons;
	
	public Parser(File file) {
		this.toRead = file;
		this.persons = new ArrayList<Person>();
	}
	
	public ArrayList<Person> startParsing() {
		Scanner reader;
		try {
			reader = new Scanner(toRead);
			
			while(reader.hasNextLine()) {
				String line = reader.nextLine();
				handlePerson(line, reader);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Error reading line: " + e.getMessage());
		}
		
		return this.persons;
	}
	
	private void handlePerson(String personLine, Scanner reader) {
		Person person = this.parsePerson(personLine);
		
		while(!reader.hasNext(Pattern.compile("(P\\|)(.*)")) && reader.hasNext()) {
			String line = reader.nextLine();
			
			if(line.startsWith("F")) {
				person.addFamily(handleFamily(line, reader));
			} else {
				if(line.startsWith("T")) {
					//System.out.println("Adding number: " + line);
					person.addNumber(this.parsePhone(line));
				} else {
					person.addAddress(this.parseAddress(line));
				}
			}
		}
		
		//System.out.println(person);
		this.persons.add(person);
	}
	
	private FamilyMember handleFamily(String familyLine, Scanner reader) {
		FamilyMember member = this.parseFamily(familyLine);
		
		while(reader.hasNext(Pattern.compile("T\\|.*")) || reader.hasNext(Pattern.compile("A\\|.*"))) {
			String line = reader.nextLine();
			if(line.startsWith("T")) {
				member.addNumber(this.parsePhone(line));
			} else {
				member.addAddress(this.parseAddress(line));
			}
		}
		
		return member;
	}
	
	private Person parsePerson(String toSplit) {
		String[] split = toSplit.split("\\|");
		
		return new Person(split[1], split[2]);
	}
	
	private PhoneNumber parsePhone(String toSplit) {
		String[] split = toSplit.split("\\|");
		
		return new PhoneNumber(split[1], split[2]);
	}
	
	private Address parseAddress(String toSplit) {
		String[] split = toSplit.split("\\|");
		Address address;
		
		if(split.length == 4) {
			address = new Address(split[1], split[2], split[3]);
		} else {
			address = new Address(split[1], split[2]);
		}
		
		return address;
	}
	
	private FamilyMember parseFamily(String toSplit) {
		String[] split = toSplit.split("\\|");
		
		return new FamilyMember(split[1], split[2]);		
	}
}
