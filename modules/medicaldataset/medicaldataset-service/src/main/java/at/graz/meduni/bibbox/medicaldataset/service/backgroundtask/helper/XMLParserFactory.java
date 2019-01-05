package at.graz.meduni.bibbox.medicaldataset.service.backgroundtask.helper;

public class XMLParserFactory {
	
	public XMLParserInterface getXMLParser(String root_element){
	      if(root_element == null){
	         return null;
	      }		
	      if(root_element.equalsIgnoreCase("CrystalReport")){
	         return new CrystalReportsXMLParser();
	         
	      }
	      
	      return null;
	   }
}
