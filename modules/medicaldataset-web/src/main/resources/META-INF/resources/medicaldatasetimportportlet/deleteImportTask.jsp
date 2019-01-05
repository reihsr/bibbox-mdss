<%@ include file="../init.jsp" %>

<%
long importMedicalDataSetId = Long.parseLong(renderRequest.getParameter("importMedicalDataSetId"));
String back_redirect = ParamUtil.getString(request, "redirect");
%>

<h1>Delete Import <%= importMedicalDataSetId %></h1>

<portlet:actionURL var="deleteDatasetURL" name="deleteDataset"></portlet:actionURL>

<form action="<%=deleteDatasetURL%>" method="post" enctype="multipart/form-data">
	<div class="form-group">
		<aui:input type="hidden" name="importMedicalDataSetId" value="<%= importMedicalDataSetId %>"></aui:input>
	
		<aui:input type="checkbox" name="deleteImportDataset"></aui:input>
		<aui:input type="checkbox" name="deleteAllConnectedData"></aui:input>
	
		<aui:button value="Back" type="cancle" onClick="<%= back_redirect.toString() %>"></aui:button>
		<aui:button value="Delete" type="submit"></aui:button>
	</div>
</form>