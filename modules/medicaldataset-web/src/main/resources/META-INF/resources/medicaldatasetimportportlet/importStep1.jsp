<%@ include file="../init.jsp" %>

<%
String importType = ParamUtil.getString(request, "importType");
String back_redirect = ParamUtil.getString(request, "redirect");
%>
Import Type: <%= importType %><br>

<portlet:actionURL var="uplaodURL" name="step1UploadDocument"></portlet:actionURL>

<style>
.mds-form-upload-file {
    border-color: #869CAD;
	padding: 8px 14px;
    font-size: 16px;
    line-height: 20px;
    border-radius: 4px;
	color: #869CAD;
    background-color: #FFF;
	display: inline-block;
    margin-bottom: 0;
    font-weight: 500;
    text-align: center;
    vertical-align: middle;
    touch-action: manipulation;
    cursor: pointer;
    background-image: none;
    border: 1px solid transparent;
    white-space: nowrap;
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
    user-select: none;
}

</style>

<form action="<%=uplaodURL%>" method="post" enctype="multipart/form-data">
	<div class="form-group">
		<aui:input type="hidden" name="ImportType" value="<%= importType %>"></aui:input>
	
		<aui:input label="Import Name" name="ImportName"></aui:input>
		<aui:input label="IMI Job ID" name="IMIJobId"></aui:input>
		<aui:input label="Description" name="Description"></aui:input>
		
		<input type="file" class="form-control-file mds-form-upload-file" name="uploadedFile">
		<br>
		<aui:button value="Back" type="cancle" onClick="<%= back_redirect.toString() %>"></aui:button>
		<aui:button value="Next" type="submit"></aui:button>
	</div>
</form>
