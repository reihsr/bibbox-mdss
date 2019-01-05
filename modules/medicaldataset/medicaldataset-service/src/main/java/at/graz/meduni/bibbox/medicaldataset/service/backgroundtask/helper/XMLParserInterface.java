package at.graz.meduni.bibbox.medicaldataset.service.backgroundtask.helper;

import com.liferay.portal.kernel.service.ServiceContext;

import java.util.HashMap;

import org.w3c.dom.Document;

public interface XMLParserInterface {
	
	public abstract String getXMLParser();
	
	public abstract void setDocument(Document document);
	
	public abstract void setServiceContext(ServiceContext serviceContext);
	
	public abstract void setImportMedicalDataSetId(long importMedicalDataSetId);
	
	public abstract HashMap<String, String> getXMLFooter();
	
	public abstract HashMap<String, String> generateXMLDataStructureForMapping();
	
	public abstract String getXMLData();
}
