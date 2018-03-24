package at.graz.meduni.bibbox.medicaldataset.portlet.portlet;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.model.Portlet;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import at.graz.meduni.bibbox.medicaldataset.portlet.constants.MedicalDataSetImporterPortletKeys;

@Component(
	    immediate = true,
	    property = {
	            "com.liferay.portlet.display-category=Medical Data Set",
	            "com.liferay.portlet.scopeable=true",
	            "javax.portlet.display-name=" + MedicalDataSetImporterPortletKeys.JAVAX_PORTLET_DISPLAY_NAME_MEDICAL_DATA_SET_IMPORTER_PORTLET,
	            "javax.portlet.expiration-cache=0",
	            "javax.portlet.init-param.portlet-title-based-navigation=true",
	            "javax.portlet.init-param.template-path=/",
	            "javax.portlet.init-param.view-template=/medicaldatasetimportportlet/view.jsp",
	            "javax.portlet.name=" + MedicalDataSetImporterPortletKeys.MEDICAL_DATA_SET_IMPORTER,
	            "javax.portlet.resource-bundle=content.Language",
	            "javax.portlet.security-role-ref=administrator",
	            "javax.portlet.supports.mime-type=text/html",
	            "com.liferay.portlet.add-default-resource=true"
	    },
	    service = Portlet.class
	)
public class MedicalDataSetImporterPortlet extends MVCPortlet {

}
