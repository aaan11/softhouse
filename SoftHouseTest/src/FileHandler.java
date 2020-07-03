import java.io.File;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class FileHandler {
	private String filePath;
	private File readFile;
	
	public FileHandler(String filePath) {
		this.filePath = filePath;
	}
	
	public boolean init() {
		boolean status = false;
		
		this.readFile = new File(filePath);
		status = this.readFile.exists();
		
		if(!status) {
			System.out.println("File at location not found: " + this.readFile.getAbsolutePath());
		}
		
		return status;
	}
	
	public void writeToFile(DOMSource source) throws TransformerException {
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		File outputFile = new File(System.getProperty("user.dir") + "/result.xml");
		StreamResult result = new StreamResult(outputFile);
		transformer.transform(source, result);
		
		System.out.println("File created at: " + outputFile.getAbsolutePath());
	}
	
	public File getReadFile() {
		return this.readFile;
	}
}
