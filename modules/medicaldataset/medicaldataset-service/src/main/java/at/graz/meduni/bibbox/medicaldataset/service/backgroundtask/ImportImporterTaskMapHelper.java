package at.graz.meduni.bibbox.medicaldataset.service.backgroundtask;

import java.util.ArrayList;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap;

public class ImportImporterTaskMapHelper {
	
	private ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap_;
	private ArrayList<String> path_ = new ArrayList<String>();
	private boolean global_ = false;
	private String golobalValue_ = "";
	
	public ImportImporterTaskMapHelper(ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap) {
		importMedicalDataSetFieldMap_ = importMedicalDataSetFieldMap;
		generateFieldPath();
	}
	
	public String getFieldName() {
		if(global_) {
			return "Global" + importMedicalDataSetFieldMap_.getImportMedicalDataSetFieldMapId();
		} else {
			return importMedicalDataSetFieldMap_.getImportField();
		}
	}
	
	public String getTableName() {
		return importMedicalDataSetFieldMap_.getTableName();
	}
	
	public String getTableColumn() {
		return importMedicalDataSetFieldMap_.getTableField();
	}
	
	public String getGlobalValue() {
		return golobalValue_;
	}
	
	private  void generateFieldPath() {
		try {
			if(importMedicalDataSetFieldMap_.getImportField().equals("__importMedicalDataSetGlobalValue")) {
				global_ = true;
				golobalValue_ = importMedicalDataSetFieldMap_.getImportFieldPath();
				System.out.println("Global");
				System.out.println("Value: " + golobalValue_);
			} else {
				global_ = false;
				JSONArray sampleValueArray = JSONFactoryUtil.createJSONArray(importMedicalDataSetFieldMap_.getImportFieldPath());
				for(int array_counter = 0; array_counter < sampleValueArray.length(); array_counter++) {
					JSONObject pathObject = sampleValueArray.getJSONObject(array_counter);
					if(pathObject.getBoolean("selected")) {
						System.out.println("Dynamic");
						System.out.println("Path: " + pathObject.getString("path"));
					}
				}
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
