<%@ include file="../init.jsp" %>

<p>
	<b><liferay-ui:message key="medicaldataset-web.caption"/></b>
</p>

<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/medicaldatasetportlet/view.jsp"></portlet:param>
</portlet:renderURL>

<portlet:actionURL name="addMedicalDataSet" var="addMedicalDataSetURL"></portlet:actionURL>

<aui:form action="<%= addMedicalDataSetURL %>" name="<portlet:namespace />fm">
        <aui:fieldset>
            <aui:input name="name"></aui:input>
            <aui:input name="message"></aui:input>
        </aui:fieldset>

        <aui:button-row>
            <aui:button type="submit"></aui:button>
            <aui:button type="cancel" onClick="<%= viewURL.toString() %>"></aui:button>
        </aui:button-row>
</aui:form>