<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="saat-web.caption"/></b>
</p>


<portlet:renderURL var="addRuleURL">
    <portlet:param name="mvcPath" value="/rulewebportlet/edit_rule.jsp"></portlet:param>
</portlet:renderURL>
    
<aui:button-row>
	<c:if test='<%= DictionaryPermission.contains(permissionChecker, "ADD_RULE") %>'>
    	<aui:button onClick="<%= addRuleURL.toString() %>" value="Add Rule"></aui:button>
    </c:if>
</aui:button-row>