package at.graz.meduni.bibbox.medicaldataset.service.backgroundtask.helper.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import at.graz.meduni.bibbox.medicaldataset.service.backgroundtask.helper.XMLParserFactory;
import at.graz.meduni.bibbox.medicaldataset.service.backgroundtask.helper.XMLParserInterface;

public class XMLParserFactoryTest {
	
	XMLParserFactory xmlParserFactory_ = null;
	
	@Before
	public void setUp() {
		xmlParserFactory_ = new XMLParserFactory();
	}
	
	@Test
	public void TestCrystalReportCreation() {
		XMLParserInterface crystalReport = xmlParserFactory_.getXMLParser("CrystalReport");
		Assert.assertEquals("at.graz.meduni.bibbox.medicaldataset.service.backgroundtask.helper.CrystalReportsXMLParser", crystalReport.getClass().getName());
		Assert.assertEquals("CrystalReport", crystalReport.getXMLParser());
	}
}