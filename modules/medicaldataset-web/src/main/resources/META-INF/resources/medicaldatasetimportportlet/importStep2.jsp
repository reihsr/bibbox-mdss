<%@ include file="../init.jsp" %>

<h1>Step2 Analyse</h1>


<%
long importMedicalDataSetId = Long.parseLong(renderRequest.getParameter("importMedicalDataSetId"));
%>

<portlet:renderURL var="importStep2RunBackgroundServiceURL">
	<portlet:param name="importMedicalDataSetId" value="<%=String.valueOf(importMedicalDataSetId) %>" />
	<portlet:param name="mvcPath" value="/medicaldatasetimportportlet/importStep2.jsp" />
</portlet:renderURL>
<portlet:renderURL var="importStep3MappingURL">
	<portlet:param name="importMedicalDataSetId" value="<%=String.valueOf(importMedicalDataSetId) %>" />
	<portlet:param name="mvcPath" value="/medicaldatasetimportportlet/importStep3.jsp" />
</portlet:renderURL>

<div class="panel panel-default">
		<div class="panel-body">
		<%																						 
		List<ImportMedicalDataSetLog> importMedicalDataSetLogs = ImportMedicalDataSetLogLocalServiceUtil.getImportMedicalDataSetLogsFromImportsAtStatus(importMedicalDataSetId, 5);
		for(ImportMedicalDataSetLog importMedicalDataSetLog : importMedicalDataSetLogs) {
			%>
			<%= importMedicalDataSetLog.getImportStatusLog() %><br>
			<%
		}
		%>
	</div>
</div>


<aui:button value="Reload" type="submit" onClick="<%= importStep2RunBackgroundServiceURL.toString() %>"></aui:button>
<aui:button value="Next" type="next" onClick="<%= importStep3MappingURL.toString() %>"></aui:button>