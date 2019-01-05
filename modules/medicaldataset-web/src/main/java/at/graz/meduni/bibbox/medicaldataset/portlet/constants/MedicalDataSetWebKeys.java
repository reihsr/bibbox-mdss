package at.graz.meduni.bibbox.medicaldataset.portlet.constants;

public class MedicalDataSetWebKeys {
	public static final String COM_LIFERAY_PORTLET_DISPLAY_CATEGORY = "Medical Data Set";
	
	public static final String getStatusTranslation(int importStatus) {
		switch(importStatus) {
			case 1: return "Step 1 - File Upload";
			case 5: return "Step 2 - Analysing";
			case 10: return "Step 2 - Analysed";
			case 20: return "Step 3 - Mapping";
			case 25: return "Step 4 - Importing Data";
			case 30: return "Step 4 - Importing Data done";
			case 100: return "Finished";
			case 200: return "Deleting";
		}
		return "Error";
	}
}
