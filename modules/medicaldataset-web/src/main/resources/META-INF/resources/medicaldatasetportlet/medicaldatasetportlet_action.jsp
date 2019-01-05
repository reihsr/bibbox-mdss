<%@include file="../init.jsp"%>

<%
    String mvcPath = ParamUtil.getString(request, "mvcPath");

    ResultRow row = (ResultRow) request.getAttribute("SEARCH_CONTAINER_RESULT_ROW");

    MedicalRecord medicalRecord = (MedicalRecord) row.getObject();
%>

<liferay-ui:icon-menu>

	<portlet:renderURL var="editMedicalRecordURL">
        <portlet:param name="medicalRecordId" value="<%=String.valueOf(medicalRecord.getMedicalRecordId()) %>" />
        <portlet:param name="mvcPath" value="/medicaldatasetportlet/view_record.jsp" />
    </portlet:renderURL>
    <liferay-ui:icon image="edit" message="Edit" url="<%=editMedicalRecordURL.toString() %>" />

</liferay-ui:icon-menu>