<%@ include file="../init.jsp" %>

<h1>Step3 Mapping</h1><br>

<style>
	.displayClassNone {
		display: none;
	}
</style>

<%
long importMedicalDataSetId = Long.parseLong(renderRequest.getParameter("importMedicalDataSetId"));
List<ImportMedicalDataSetFieldMap> importMedicalDataSetFieldMaps = ImportMedicalDataSetFieldMapLocalServiceUtil.getImportMedicalDataSetFieldMapsFromImportMedicalDataSet(importMedicalDataSetId);
%>

<portlet:actionURL name="updateFieldMapStep3" var="updateFieldMapStep3URL" windowState="normal" />
<form action="<%= updateFieldMapStep3URL %>" method="post" enctype="multipart/form-data">
	<div class="form-group">
		<div class="container">
			
			<aui:input type="hidden" name="importMedicalDataSetId" value="<%= importMedicalDataSetId %>"></aui:input>
			
			<%
			for(ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap : importMedicalDataSetFieldMaps) {
				%>
					<div class="row">
						<div class="col-md-4"><%= importMedicalDataSetFieldMap.getImportField() %></div>
						<div class="col-md-4">
							<aui:select name='<%= importMedicalDataSetFieldMap.getImportMedicalDataSetFieldMapId() + "_Table" %>' label="Select Table" inlineLabel="true" cssClass="tableselector">
								<aui:option label="NotSelected" value="NotSelected" selected="true"></aui:option>
		        				<aui:option label="MedicalRecord" value="MedicalRecord"/>
						        <aui:option label="PathologieData" value="PathologieData"/>
						        <aui:option label="KloetzelBuch" value="KloetzelBuch"/>
						    </aui:select>
					    </div>
					    <div class="col-md-4">
							<aui:select wrapperCssClass="displayClassNone" name='<%= importMedicalDataSetFieldMap.getImportMedicalDataSetFieldMapId() + "_MedicalRecord" %>' label="Select Colum" inlineLabel="true" >
		        				<aui:option label="histonumberStart" value="histonumberStart" selected="true"></aui:option>
						        <aui:option label="histonumberEnd" value="histonumberEnd"></aui:option>
						        <aui:option label="histonumberRunning" value="histonumberRunning"></aui:option>
						        <aui:option label="iNumber" value="iNumber"></aui:option>
						        <aui:option label="vPatentId" value="vPatentId"></aui:option>
						        <aui:option label="vHistonNumber" value="vHistonNumber"></aui:option>
						        <aui:option label="area" value="area"></aui:option>
						        <aui:option label="imiJobId" value="imiJobId"></aui:option>
						        <aui:option label="importFile" value="importFile"></aui:option>
						    </aui:select>
						    <aui:select wrapperCssClass="displayClassNone" name='<%= importMedicalDataSetFieldMap.getImportMedicalDataSetFieldMapId() + "_PathologieData" %>' label="Select Colum" inlineLabel="true" cssClass="displayClassNone">
		        				<aui:option label="receivedDate" value="receivedDate" selected="true"></aui:option>
						        <aui:option label="validationDate" value="validationDate"></aui:option>
						        <aui:option label="patientAge" value="patientAge"></aui:option>
						        <aui:option label="sender" value="sender"></aui:option>
						        <aui:option label="extractionMethode" value="extractionMethode"></aui:option>
						        <aui:option label="reportingPhysician1" value="reportingPhysician1"></aui:option>
						        <aui:option label="reportingPhysician2" value="reportingPhysician2"></aui:option>
						        <aui:option label="gynPhysician" value="gynPhysician"></aui:option>
						        <aui:option label="validationPhysician1" value="validationPhysician1"></aui:option>
						        <aui:option label="validationPhysician2" value="validationPhysician2"></aui:option>
						        <aui:option label="reportStatus" value="reportStatus"></aui:option>
						        <aui:option label="numberOfBlockes" value="numberOfBlockes"></aui:option>
						        <aui:option label="numberOfSlides" value="numberOfSlides"></aui:option>
						        <aui:option label="basicDisease" value="basicDisease"></aui:option>
						        <aui:option label="causeOfDeath" value="causeOfDeath"></aui:option>
						        <aui:option label="material" value="material"></aui:option>
						        <aui:option label="materialExtended" value="materialExtended"></aui:option>
						        <aui:option label="macroscopicDescription" value="macroscopicDescription"></aui:option>
						        <aui:option label="microscopicDescription" value="microscopicDescription"></aui:option>
						        <aui:option label="histologicDescription" value="histologicDescription"></aui:option>
						        <aui:option label="molecularPathologicDescription" value="molecularPathologicDescription"></aui:option>
						        <aui:option label="zytologieDescription" value="zytologieDescription"></aui:option>
						        <aui:option label="pathologicDiagnosis" value="pathologicDiagnosis"></aui:option>
						        <aui:option label="frozenSectionDiagnosis" value="frozenSectionDiagnosis"></aui:option>
						        <aui:option label="molecularPathologicDiagnosis" value="molecularPathologicDiagnosis"></aui:option>
						        <aui:option label="zytologieDiagnosis" value="zytologieDiagnosis"></aui:option>
						        <aui:option label="neuroPathologicDiagnosis" value="neuroPathologicDiagnosis"></aui:option>
						        <aui:option label="comment" value="comment"></aui:option>
						        <aui:option label="zytologiecomment" value="zytologiecomment"></aui:option>
						        <aui:option label="grad" value="grad"></aui:option>
						        <aui:option label="tnmp" value="tnmp"></aui:option>
						        <aui:option label="tnmt" value="tnmt"></aui:option>
						        <aui:option label="tnmn" value="tnmn"></aui:option>
						        <aui:option label="tnmm" value="tnmm"></aui:option>
						        <aui:option label="tnmr" value="tnmr"></aui:option>
						        <aui:option label="tnml" value="tnml"></aui:option>
						        <aui:option label="tnmv" value="tnmv"></aui:option>
						        <aui:option label="tnmpn" value="tnmpn"></aui:option>
						        <aui:option label="dgcode1" value="dgcode1"></aui:option>
						        <aui:option label="dgcode2" value="dgcode2"></aui:option>
						        <aui:option label="pap" value="pap"></aui:option>
						        <aui:option label="smearQuality" value="smearQuality"></aui:option>
						    </aui:select>
						    <aui:select wrapperCssClass="displayClassNone" name='<%= importMedicalDataSetFieldMap.getImportMedicalDataSetFieldMapId() + "_KloetzelBuch" %>' label="Select Colum" inlineLabel="true" cssClass="displayClassNone">
		        				<aui:option label="histonumberStart" value="histonumberStart" selected="true"></aui:option>
						        <aui:option label="histonumberEnd" value="histonumberEnd"></aui:option>
						        <aui:option label="histonumberRunning" value="histonumberRunning"></aui:option>
						        <aui:option label="histonumber" value="histonumber"></aui:option>
						        <aui:option label="kloetzelBuchRunning" value="kloetzelBuchRunning"></aui:option>
						        <aui:option label="oid" value="oid"></aui:option>
						        <aui:option label="bid" value="bid"></aui:option>
						        <aui:option label="area" value="area"></aui:option>
						        <aui:option label="type" value="type"></aui:option>
						        <aui:option label="acronym" value="acronym"></aui:option>
						        <aui:option label="text" value="text"></aui:option>
						        <aui:option label="info" value="info"></aui:option>
						        <aui:option label="count" value="count"></aui:option>
						        <aui:option label="numberOfPieces" value="numberOfPieces"></aui:option>
						        <aui:option label="kbStatus" value="kbStatus"></aui:option>
						        <aui:option label="sort" value="sort"></aui:option>
						        <aui:option label="color" value="color"></aui:option>
						        <aui:option label="kbDate" value="kbDate"></aui:option>
						        <aui:option label="day" value="day"></aui:option>
						        <aui:option label="pocessinguser" value="pocessinguser"></aui:option>
						        <aui:option label="organizationUnit" value="organizationUnit"></aui:option>
						    </aui:select>
						    
						    <aui:script use="aui-base, bibboxmds">
						    	AUI().use('aui-base', 'bibboxmds', function(A){
								    A.one('#<portlet:namespace/><%= importMedicalDataSetFieldMap.getImportMedicalDataSetFieldMapId() %>_Table').on(
								        'change',
								        function(event) {
								            A.bibboxmdsUpdateSelectScripts.DisplayRules('<%= String.valueOf(importMedicalDataSetFieldMap.getImportMedicalDataSetFieldMapId()) %>');
								        }
								    );
						    	});
							</aui:script>
					    </div>
					</div>
				<%
			}
			%>
			
			<aui:button value="Next" type="submit"></aui:button>
		</div>
	</div>
</form>

<aui:input name="someNodeId" id="someNodeId" type="checkbox" onclick="showHideDiv()" />

<aui:script>
AUI.add('bibboxmds', function (A) {
	A.bibboxmdsUpdateSelectScripts = {
		DisplayRules: function (fieldname) {
			var fullfieldname = "#<portlet:namespace/>" + fieldname + "_";
			var inputObject=A.one(fullfieldname + "Table");
			var selectedTable = inputObject.get('value');
			console.log(selectedTable);
			console.log(fullfieldname);
			A.one(fullfieldname + "MedicalRecord").ancestor().addClass('displayClassNone');
			A.one(fullfieldname + "PathologieData").ancestor().addClass('displayClassNone');
			A.one(fullfieldname + "KloetzelBuch").ancestor().addClass('displayClassNone');
			A.one(fullfieldname + selectedTable).ancestor().removeClass('displayClassNone');
		}
	}
});
</aui:script>