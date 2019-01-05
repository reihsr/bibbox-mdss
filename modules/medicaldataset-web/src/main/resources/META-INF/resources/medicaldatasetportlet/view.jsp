<%@ include file="../init.jsp" %>

<p>
	<b><liferay-ui:message key="medicaldataset-web.caption"/></b>
</p>

<portlet:renderURL var="addEntryURL">
    <portlet:param name="mvcPath" value="/medicaldatasetportlet/edit_entry.jsp"></portlet:param>
</portlet:renderURL>

<aui:button-row>
    <aui:button onClick="<%= addEntryURL.toString() %>" value="Add Entry"></aui:button>
</aui:button-row>


<liferay-ui:search-container total="<%=MedicalRecordLocalServiceUtil.getMedicalRecordsCount()%>">
	<liferay-ui:search-container-results results="<%=MedicalRecordLocalServiceUtil.getMedicalRecords(scopeGroupId.longValue(), searchContainer.getStart(), searchContainer.getEnd())%>" />	
		<liferay-ui:search-container-row className="at.graz.meduni.bibbox.medicaldataset.model.MedicalRecord" modelVar="medicalRecord">
		
			<liferay-ui:search-container-column-text property="medicalRecordId" />		
			
			<liferay-ui:search-container-column-text property="histonumberRunning" />
			
			<%
			int diagnosisDisplayLength = 120;
			if(medicalRecord.getPathologyData().getPathologicDiagnosis().length() < 120) {
				diagnosisDisplayLength  = medicalRecord.getPathologyData().getPathologicDiagnosis().length();
			}
			%>
			<liferay-ui:search-container-column-text name="pathologyDiagnosis" value="<%= medicalRecord.getPathologyData().getPathologicDiagnosis().substring(0, diagnosisDisplayLength) %>"/>
		
			<liferay-ui:search-container-column-jsp align="right" path="/medicaldatasetportlet/medicaldatasetportlet_action.jsp" />
		
		</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>
