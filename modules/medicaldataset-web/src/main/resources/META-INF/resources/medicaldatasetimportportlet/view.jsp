<%@ include file="../init.jsp" %>

<div class="page-header">
  <h1>Importer</h1>
</div>

<%
String currentURL = PortalUtil.getCurrentURL(request);
%>

<div class="container">
  <div class="row">
    <div class="col-sm-4">
		<portlet:renderURL var="importPathologyDataSetURL">
		    <portlet:param name="mvcPath" value="/medicaldatasetimportportlet/importStep1.jsp"></portlet:param>
		    <portlet:param name="redirect" value="<%= currentURL %>"/>
		    <portlet:param name="importType" value="PathologyDataSet"/>
		</portlet:renderURL>
		
		<portlet:renderURL var="importKloezelbuchSetURL">
		    <portlet:param name="mvcPath" value="/medicaldatasetimportportlet/importStep1.jsp"></portlet:param>
		    <portlet:param name="importType" value="Kloezelbuch"/>
		</portlet:renderURL>
		
		<portlet:renderURL var="importImiIdMappingURL">
		    <portlet:param name="mvcPath" value="/medicaldatasetimportportlet/importStep1.jsp"></portlet:param>
		    <portlet:param name="importType" value="ImiIdMapping"/>
		</portlet:renderURL>
		
		<aui:button-row>
		    <aui:button onClick="<%= importPathologyDataSetURL.toString() %>" class="btn btn-md btn-success btn-block" value="Import Pathology Data Set"></aui:button>
		    <aui:button onClick="<%= importKloezelbuchSetURL.toString() %>" class="btn btn-md btn-primary btn-block" value="Import Klötzelbuch Set"></aui:button>
		    <aui:button onClick="<%= importImiIdMappingURL.toString() %>" class="btn btn-md btn-info btn-block" value="Import ID IMI Mapping"></aui:button>
		</aui:button-row>
    </div>
    <div class="col-sm-8">
    	<div class="panel panel-default">
		  <div class="panel-heading">
		    <h3 class="panel-title">Import History</h3>
		  </div>
		  <div class="panel-body">
		    
		    <liferay-ui:search-container total="<%=ImportMedicalDataSetLocalServiceUtil.getImportMedicalDataSetsCount()%>">
				<liferay-ui:search-container-results results="<%=ImportMedicalDataSetLocalServiceUtil.getImportMedicalDataSets(scopeGroupId.longValue(), searchContainer.getStart(), searchContainer.getEnd())%>" />	
					<liferay-ui:search-container-row className="at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSet" modelVar="importMedicalDataSet">
					
						<liferay-ui:search-container-column-text property="importMedicalDataSetId" />		
						<liferay-ui:search-container-column-text property="importName" />
					
					</liferay-ui:search-container-row>
				<liferay-ui:search-iterator />
			</liferay-ui:search-container>
		    
		  </div>
		</div>
    </div>
  </div>
</div>
