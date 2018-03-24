package at.graz.meduni.bibbox.medicaldataset.application.list;

import java.net.PasswordAuthentication;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.portal.kernel.model.Portlet;

import at.graz.meduni.bibbox.medicaldataset.portlet.constants.MedicalDataSetImporterPortletKeys;

/*
@Component(
	    immediate = true,
	    property = {
	        "panel.app.order:Integer=300",
	        "panel.category.key=" + PanelCategoryKeys.SITE_ADMINISTRATION_CONTENT
	    },
	    service = PanelApp.class
	)*/
public class MedicalDataSetImporterPortletPanelApp {
	
}

/*extends BasePanelApp {

	@Override
	public String getPortletId() {
		return MedicalDataSetImporterPortletKeys.MEDICAL_DATA_SET_IMPORTER;
	}

	@Override
    @Reference(
        target = "(javax.portlet.name=" + MedicalDataSetImporterPortletKeys.MEDICAL_DATA_SET_IMPORTER + ")",
        unbind = "-"
    )
    public void setPortlet(Portlet portlet) {
        super.setPortlet(portlet);
    }
}*/
