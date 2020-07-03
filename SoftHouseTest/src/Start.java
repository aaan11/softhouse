import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;

public class Start {

	private static FileHandler fileHandler;
	private static DomHandler domHandler;
	private static Parser parser;
	private static String defaultFile = "testFile.txt";

	public static void main(String[] args) throws ParserConfigurationException, TransformerException {
		// Initiate program and find file, parse file and generate new file
		String fileName = parseArgs(args);

		if (init(fileName)) {
			DOMSource source = Start.readAndParse();
			Start.writeAndClose(source);
		}
	}

	public static String parseArgs(String[] args) {
		String fileName = Start.defaultFile;

		if (args != null && args.length > 0) {
			fileName = args[0];
		}

		return fileName;
	}

	public static boolean init(String fileName) throws ParserConfigurationException {
		boolean status = false;

		Start.fileHandler = new FileHandler(fileName);
		if (Start.fileHandler.init()) {
			Start.parser = new Parser(fileHandler.getReadFile());
			Start.domHandler = new DomHandler();
			status = true;
		}

		return status;
	}

	public static DOMSource readAndParse() {
		// read file and parse string
		ArrayList<Person> persons = Start.parser.startParsing();

		return Start.domHandler.createXML(persons);
	}

	public static void writeAndClose(DOMSource source) throws TransformerException {
		// write file and close
		Start.fileHandler.writeToFile(source);
	}

}
