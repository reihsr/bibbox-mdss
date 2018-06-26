<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="java.util.List" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.PortalUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.model.PersistedModel" %>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchEntry" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>

<%@ page import="at.graz.meduni.bibbox.medicaldataset.model.MedicalRecord" %>
<%@ page import="at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSet" %>
<%@ page import="at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap" %>
<%@ page import="at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog" %>
<%@ page import="at.graz.meduni.bibbox.medicaldataset.service.MedicalRecordLocalServiceUtil" %>
<%@ page import="at.graz.meduni.bibbox.medicaldataset.service.ImportMedicalDataSetLocalServiceUtil" %>
<%@ page import="at.graz.meduni.bibbox.medicaldataset.service.ImportMedicalDataSetFieldMapLocalServiceUtil" %>
<%@ page import="at.graz.meduni.bibbox.medicaldataset.service.ImportMedicalDataSetLogLocalServiceUtil" %>

<%@ page import="at.graz.meduni.bibbox.medicaldataset.portlet.constants.MedicalDataSetWebKeys" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />