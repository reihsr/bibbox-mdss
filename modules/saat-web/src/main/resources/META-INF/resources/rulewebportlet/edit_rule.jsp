<%@ include file="/init.jsp" %>

<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/rulewebportlet/view.jsp"></portlet:param>
</portlet:renderURL>

<portlet:actionURL name="addRule" var="addRuleURL"></portlet:actionURL>

<aui:form action="<%= addRuleURL %>" name="<portlet:namespace />fm">
        <aui:fieldset>
            <aui:input name="synonym"></aui:input>
            <aui:input name="pattern"></aui:input>
        </aui:fieldset>

        <aui:button-row>
            <aui:button type="submit"></aui:button>
            <aui:button type="cancel" onClick="<%= viewURL.toString() %>"></aui:button>
        </aui:button-row>
</aui:form>