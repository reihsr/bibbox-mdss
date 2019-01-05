package at.graz.meduni.bibbox.medicaldataset.service.backgroundtask.helper.test;

import com.liferay.portal.kernel.resiliency.spi.agent.annotation.Distributed;

import java.io.File;
import java.net.URL;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;

import at.graz.meduni.bibbox.medicaldataset.service.backgroundtask.helper.CrystalReportsXMLParser;

public class CrystalReportsXMLParserTest {

	CrystalReportsXMLParser crystalReportsXMLParser_ = null;
	
	@Before
	public void setUp() {
		System.out.println("SetUp");
		crystalReportsXMLParser_ = new CrystalReportsXMLParser();
	}
	
	@Test
	public void testCrystalReportAnalyseFooterIDBerlin() {
		System.out.println("TestCrystalReportAnalyseFooter ID Berlin Q1");
		try {
			URL url = getClass().getResource("/imi_test_001.xml");
			File testWsdl = new File(url.getFile());
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(testWsdl);
			crystalReportsXMLParser_.setDocument(doc);
			HashMap<String, String> data = crystalReportsXMLParser_.getReportFooter();
			Assert.assertEquals("Anzahl Befunde:", data.get("lblAnzENUM"));
			Assert.assertEquals("20733", data.get("AnzENUM"));
			Assert.assertEquals(2, data.size());
		} catch(Exception e) {
			Assert.fail("Testrun testCrystalReportAnalyseFooter Failed");
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCrystalReportAnalyseFooterGoogleColonStageII() {
		System.out.println("TestCrystalReportAnalyseFooter Google Colon Stage II");
		try {
			URL url = getClass().getResource("/imi_test_002.xml");
			File testWsdl = new File(url.getFile());
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(testWsdl);
			crystalReportsXMLParser_.setDocument(doc);
			HashMap<String, String> data = crystalReportsXMLParser_.getReportFooter();
			Assert.assertEquals("Anzahl Befunde:", data.get("lblAnzENUM"));
			Assert.assertEquals("10", data.get("AnzENUM"));
			Assert.assertEquals(2, data.size());
		} catch(Exception e) {
			Assert.fail("Testrun testCrystalReportAnalyseFooter Failed");
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCrystalReportAnalyseFooterMEFOLeber() {
		System.out.println("TestCrystalReportAnalyseFooter MEFO Leber");
		try {
			URL url = getClass().getResource("/imi_test_003.xml");
			File testWsdl = new File(url.getFile());
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(testWsdl);
			crystalReportsXMLParser_.setDocument(doc);
			HashMap<String, String> data = crystalReportsXMLParser_.getReportFooter();
			Assert.assertEquals("Anzahl Befunde:", data.get("lblAnzENUM"));
			Assert.assertEquals("15", data.get("AnzENUM"));
			Assert.assertEquals(2, data.size());
		} catch(Exception e) {
			Assert.fail("Testrun testCrystalReportAnalyseFooter Failed");
			e.printStackTrace();
		}
	}

	public void testCrystalReportAnalyseDataMEFOLeber() {
		System.out.println("TestCrystalReportAnalyseData MEFO Leber");
		try {
			URL url = getClass().getResource("/imi_test_003.xml");
			File testWsdl = new File(url.getFile());
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(testWsdl);
			crystalReportsXMLParser_.setDocument(doc);
			HashMap<String, String> data = crystalReportsXMLParser_.generateXMLDataStructureForMapping();

			Assert.assertEquals(2, data.size());
			Assert.assertEquals("5", data.get("Analysed Entries"));	
			Assert.assertEquals("45", data.get("Analysed Fields"));
		} catch(Exception e) {
			Assert.fail("Testrun testCrystalReportAnalyseDataMEFOLeber Failed");
			e.printStackTrace();
		}
	}
}
