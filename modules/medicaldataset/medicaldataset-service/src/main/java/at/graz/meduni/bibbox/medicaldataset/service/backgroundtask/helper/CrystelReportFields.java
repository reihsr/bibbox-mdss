package at.graz.meduni.bibbox.medicaldataset.service.backgroundtask.helper;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

public class CrystelReportFields {
	private String fieldName_;
	private JSONObject fieldPath_ = JSONFactoryUtil.createJSONObject();
	private JSONObject fieldSampleValue_ = JSONFactoryUtil.createJSONObject();
	
	/*
	 * [{"path":"CrystalReport>Details>Section>Field>FormattedValue","selected":"true"},{"path":"CrystalReport>Details>Section>Field>Value","selected":"false"}]
	 * 
	 * [{"CrystalReport>Details>Section>Field>FormattedValue":""},{"CrystalReport>Details>Section>Field>Value":""}]
	 */
	
	public void setFieldsData(String fieldPath, String fieldSampleValue) {
		setFieldSampleValue(fieldPath, fieldSampleValue);
		setFieldPath(fieldPath);
		System.out.println("CrystelReportFields: " + fieldName_ + " - " + fieldPath);
	}
	
	public String toString() {
		String crystelReportFieldsString = "Field: " + fieldName_;
		crystelReportFieldsString += " || Path: " + fieldPath_.toJSONString();
		crystelReportFieldsString += " || Sample Value: " + fieldSampleValue_.toJSONString();
		return crystelReportFieldsString;
	}

	public String getFieldName() {
		return fieldName_;
	}

	public void setFieldName(String fieldName) {
		this.fieldName_ = fieldName;
	}

	public JSONObject getFieldSampleValue() {
		return fieldSampleValue_;
	}
	
	public JSONObject getFieldPath() {
		return fieldPath_;
	}

	private void setFieldSampleValue(String fieldPath, String fieldSampleValue) {
		fieldSampleValue_.put(fieldPath, fieldSampleValue);
	}

	private void setFieldPath(String fieldPath) {
		fieldPath_ = JSONFactoryUtil.createJSONObject();
		fieldPath_.put("path", fieldPath);
		if(fieldPath.endsWith(">FormattedValue")) {
			fieldPath_.put("selected", true);
		} else {
			fieldPath_.put("selected", false);
		}	
	}
}
