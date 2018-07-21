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
			
			<div id="golobalFieldsSet">
			
			</div>
			
			<aui:button id="addGolobalField" class="btn btn-md btn-success btn-block" value="Add "></aui:button>
			<aui:script use="aui-base, bibboxmds">
				AUI().use('aui-base', 'bibboxmds', function(A){
					A.one('#<portlet:namespace/>addGolobalField').on(
						'click',
						function(event) {
							A.bibboxmdsUpdateSelectScripts.AddField();
						}
					);
				});
			</aui:script>
			
			<hr>
			
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
		},
		AddField: function () {
			var added_element_id = A.bibboxmdsUpdateSelectScripts.RandomId(10);
			var newElement = document.createElement('div');
			newElement.setAttribute('class', 'row');
			
			//Create 1. Row:
			var elementRow1 = document.createElement('div');
			elementRow1.setAttribute('class', 'col-md-3');
			elementRow1.innerHTML = '<div class="form-group form-inline input-select-wrapper"> <label class="control-label" for="_at_graz_meduni_bibbox_medicaldataset_portlet_MedicalDataSetImportPortlet_' + added_element_id + '_Table"> Select Table </label> <select class="form-control tableselector" id="_at_graz_meduni_bibbox_medicaldataset_portlet_MedicalDataSetImportPortlet_' + added_element_id + '_Table" name="_at_graz_meduni_bibbox_medicaldataset_portlet_MedicalDataSetImportPortlet_' + added_element_id + '_Table"> <option class="" selected="" value="NotSelected"> NotSelected </option> <option class="" value="MedicalRecord"> MedicalRecord </option> <option class="" value="PathologieData"> PathologieData </option> <option class="" value="KloetzelBuch"> KloetzelBuch </option> </select> </div>';
			
			//Create 2. Row:
			var elementRow2 = document.createElement('div');
			elementRow2.setAttribute('class', 'col-md-3');
			elementRow2.innerHTML = '<div class="form-group form-inline displayClassNone input-select-wrapper"> <label class="control-label" for="_at_graz_meduni_bibbox_medicaldataset_portlet_MedicalDataSetImportPortlet_' + added_element_id + '_MedicalRecord"> Select Colum </label> <select class="form-control" id="_at_graz_meduni_bibbox_medicaldataset_portlet_MedicalDataSetImportPortlet_' + added_element_id + '_MedicalRecord" name="_at_graz_meduni_bibbox_medicaldataset_portlet_MedicalDataSetImportPortlet_' + added_element_id + '_MedicalRecord"> <option class="" selected="" value="histonumberStart"> histonumberStart </option> <option class="" value="histonumberEnd"> histonumberEnd </option> <option class="" value="histonumberRunning"> histonumberRunning </option> <option class="" value="iNumber"> iNumber </option> <option class="" value="vPatentId"> vPatentId </option> <option class="" value="vHistonNumber"> vHistonNumber </option> <option class="" value="area"> Area </option> <option class="" value="imiJobId"> imiJobId </option> <option class="" value="importFile"> importFile </option> </select> </div> <div class="form-group form-inline displayClassNone input-select-wrapper"> <label class="control-label" for="_at_graz_meduni_bibbox_medicaldataset_portlet_MedicalDataSetImportPortlet_' + added_element_id + '_PathologieData"> Select Colum </label> <select class="form-control displayClassNone" id="_at_graz_meduni_bibbox_medicaldataset_portlet_MedicalDataSetImportPortlet_' + added_element_id + '_PathologieData" name="_at_graz_meduni_bibbox_medicaldataset_portlet_MedicalDataSetImportPortlet_' + added_element_id + '_PathologieData"> <option class="" selected="" value="receivedDate"> receivedDate </option> <option class="" value="validationDate"> validationDate </option> <option class="" value="patientAge"> patientAge </option> <option class="" value="sender"> Sender </option> <option class="" value="extractionMethode"> extractionMethode </option> <option class="" value="reportingPhysician1"> reportingPhysician1 </option> <option class="" value="reportingPhysician2"> reportingPhysician2 </option> <option class="" value="gynPhysician"> gynPhysician </option> <option class="" value="validationPhysician1"> validationPhysician1 </option> <option class="" value="validationPhysician2"> validationPhysician2 </option> <option class="" value="reportStatus"> reportStatus </option> <option class="" value="numberOfBlockes"> numberOfBlockes </option> <option class="" value="numberOfSlides"> numberOfSlides </option> <option class="" value="basicDisease"> basicDisease </option> <option class="" value="causeOfDeath"> causeOfDeath </option> <option class="" value="material"> material </option> <option class="" value="materialExtended"> materialExtended </option> <option class="" value="macroscopicDescription"> macroscopicDescription </option> <option class="" value="microscopicDescription"> microscopicDescription </option> <option class="" value="histologicDescription"> histologicDescription </option> <option class="" value="molecularPathologicDescription"> molecularPathologicDescription </option> <option class="" value="zytologieDescription"> zytologieDescription </option> <option class="" value="pathologicDiagnosis"> pathologicDiagnosis </option> <option class="" value="frozenSectionDiagnosis"> frozenSectionDiagnosis </option> <option class="" value="molecularPathologicDiagnosis"> molecularPathologicDiagnosis </option> <option class="" value="zytologieDiagnosis"> zytologieDiagnosis </option> <option class="" value="neuroPathologicDiagnosis"> neuroPathologicDiagnosis </option> <option class="" value="comment"> Comment </option> <option class="" value="zytologiecomment"> zytologiecomment </option> <option class="" value="grad"> grad </option> <option class="" value="tnmp"> tnmp </option> <option class="" value="tnmt"> tnmt </option> <option class="" value="tnmn"> tnmn </option> <option class="" value="tnmm"> tnmm </option> <option class="" value="tnmr"> tnmr </option> <option class="" value="tnml"> tnml </option> <option class="" value="tnmv"> tnmv </option> <option class="" value="tnmpn"> tnmpn </option> <option class="" value="dgcode1"> dgcode1 </option> <option class="" value="dgcode2"> dgcode2 </option> <option class="" value="pap"> pap </option> <option class="" value="smearQuality"> smearQuality </option> </select> </div> <div class="form-group form-inline displayClassNone input-select-wrapper"> <label class="control-label" for="_at_graz_meduni_bibbox_medicaldataset_portlet_MedicalDataSetImportPortlet_' + added_element_id + '_KloetzelBuch"> Select Colum </label> <select class="form-control displayClassNone" id="_at_graz_meduni_bibbox_medicaldataset_portlet_MedicalDataSetImportPortlet_' + added_element_id + '_KloetzelBuch" name="_at_graz_meduni_bibbox_medicaldataset_portlet_MedicalDataSetImportPortlet_' + added_element_id + '_KloetzelBuch"> <option class="" selected="" value="histonumberStart"> histonumberStart </option> <option class="" value="histonumberEnd"> histonumberEnd </option> <option class="" value="histonumberRunning"> histonumberRunning </option> <option class="" value="histonumber"> histonumber </option> <option class="" value="kloetzelBuchRunning"> kloetzelBuchRunning </option> <option class="" value="oid"> oid </option> <option class="" value="bid"> bid </option> <option class="" value="area"> Area </option> <option class="" value="type"> Type </option> <option class="" value="acronym"> acronym </option> <option class="" value="text"> Text </option> <option class="" value="info"> Info </option> <option class="" value="count"> Count </option> <option class="" value="numberOfPieces"> numberOfPieces </option> <option class="" value="kbStatus"> kbStatus </option> <option class="" value="sort"> sort </option> <option class="" value="color"> Color </option> <option class="" value="kbDate"> kbDate </option> <option class="" value="day"> Day </option> <option class="" value="pocessinguser"> pocessinguser </option> <option class="" value="organizationUnit"> organizationUnit </option> </select> </div>';
			
			//Create 3. Row:
			var elementRow3 = document.createElement('div');
			elementRow3.setAttribute('class', 'col-md-5');
			elementRow3.innerHTML = '<div class="form-group form-inline input-select-wrapper"> <label class="control-label" for="_at_graz_meduni_bibbox_medicaldataset_portlet_MedicalDataSetImportPortlet_' + added_element_id + '_GlobalValue"> Global Value </label> <input class="form-control tableselector" id="_at_graz_meduni_bibbox_medicaldataset_portlet_MedicalDataSetImportPortlet_' + added_element_id + '_GlobalValue" name="_at_graz_meduni_bibbox_medicaldataset_portlet_MedicalDataSetImportPortlet_' + added_element_id + '_GlobalValue"></input> </div>';
			
			//Create 4. Row:
			var elementRow4 = document.createElement('div');
			elementRow4.setAttribute('class', 'col-md-1');
			elementRow4.innerHTML = '<button class="btn btn-default" id="__at_graz_meduni_bibbox_medicaldataset_portlet_MedicalDataSetImportPortlet_' + added_element_id + '_Remove" type="button"> <span class="lfr-btn-label">-</span> </button>';
			
			newElement.appendChild(elementRow1);
			newElement.appendChild(elementRow2);
			newElement.appendChild(elementRow3);
			newElement.appendChild(elementRow4);
			//newElement.innerHTML = '<div class="col-md-4">CCCCCCCC</div>';
			document.getElementById('golobalFieldsSet').appendChild(newElement);
			
			console.log('#<portlet:namespace/>' + added_element_id + '_Table');
			
			A.one('#<portlet:namespace/>' + added_element_id + '_Table').on(
			        'change',
			        function(event) {
			            A.bibboxmdsUpdateSelectScripts.DisplayRules(added_element_id);
			        }
			    );
			
		},
		RandomId: function (id_length) {
			var text = "";
			var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

			for (var i = 0; i < id_length; i++)
				text += possible.charAt(Math.floor(Math.random() * possible.length));
			return text;
		}
	}
});
</aui:script>