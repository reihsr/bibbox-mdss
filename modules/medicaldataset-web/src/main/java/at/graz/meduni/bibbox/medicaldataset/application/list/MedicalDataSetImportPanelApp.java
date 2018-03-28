package at.graz.meduni.bibbox.medicaldataset.application.list;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.model.Portlet;

import at.graz.meduni.bibbox.medicaldataset.portlet.constants.MedicalDataSetImportPortletKeys;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;

/*@Component(
	    immediate = true,
	    property = {
	        "panel.app.order:Integer=300",
	        "panel.category.key=" + PanelCategoryKeys.SITE_ADMINISTRATION_CONTENT
	    },
	    service = PanelApp.class
	)*/
public class MedicalDataSetImportPanelApp {
}
/*extends BasePanelApp {
}

	@Override
	public String getPortletId() {
		return MedicalDataSetImportPortletKeys.MEDICAL_DATA_SET_IMPORT;
	}
	
	@Override
    @Reference(
        target = "(javax.portlet.name=" + MedicalDataSetImportPortletKeys.MEDICAL_DATA_SET_IMPORT + ")",
        unbind = "-"
    )
    public void setPortlet(Portlet portlet) {
        super.setPortlet(portlet);
    }

}*/
