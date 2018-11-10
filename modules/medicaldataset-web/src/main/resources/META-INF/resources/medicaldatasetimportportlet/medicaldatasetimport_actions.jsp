<%@include file="../init.jsp"%>

<%
    String mvcPath = ParamUtil.getString(request, "mvcPath");

    ResultRow row = (ResultRow) request.getAttribute("SEARCH_CONTAINER_RESULT_ROW");

    ImportMedicalDataSet importMedicalDataSet = (ImportMedicalDataSet) row.getObject();
%>

<liferay-ui:icon-menu>

	<portlet:renderURL var="importStep1RunBackgroundServiceURL">
        <portlet:param name="importMedicalDataSetId" value="<%=String.valueOf(importMedicalDataSet.getImportMedicalDataSetId()) %>" />
        <portlet:param name="mvcPath" value="/medicaldatasetimportportlet/importStep1.jsp" />
    </portlet:renderURL>
    <liferay-ui:icon image="edit" message="Import Step 1 - File Upload" url="<%=importStep1RunBackgroundServiceURL.toString() %>" />

    <portlet:renderURL var="importStep2RunBackgroundServiceURL">
        <portlet:param name="importMedicalDataSetId" value="<%=String.valueOf(importMedicalDataSet.getImportMedicalDataSetId()) %>" />
        <portlet:param name="mvcPath" value="/medicaldatasetimportportlet/importStep2.jsp" />
    </portlet:renderURL>
    <liferay-ui:icon image="edit" message="Import Step 2 - Analysis" url="<%=importStep2RunBackgroundServiceURL.toString() %>" />

    <portlet:renderURL var="importStep3MappingURL">
        <portlet:param name="importMedicalDataSetId" value="<%=String.valueOf(importMedicalDataSet.getImportMedicalDataSetId()) %>" />
        <portlet:param name="mvcPath" value="/medicaldatasetimportportlet/importStep3.jsp" />
    </portlet:renderURL>
    <liferay-ui:icon image="edit" message="Import Step 3 - Mapping" url="<%=importStep3MappingURL.toString() %>" />
    
    <portlet:actionURL var="importStep5ReimportURL" name="importStep5Reimport">
        <portlet:param name="importMedicalDataSetId" value="<%=String.valueOf(importMedicalDataSet.getImportMedicalDataSetId()) %>" />
        <portlet:param name="mvcPath" value="/medicaldatasetimportportlet/importStep4.jsp" />
    </portlet:actionURL>
    <liferay-ui:icon image="edit" message="Import Step 4 - Reimport" url="<%=importStep5ReimportURL.toString() %>" />

</liferay-ui:icon-menu>