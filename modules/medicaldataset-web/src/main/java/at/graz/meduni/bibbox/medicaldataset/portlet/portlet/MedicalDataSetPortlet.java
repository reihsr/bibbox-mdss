package at.graz.meduni.bibbox.medicaldataset.portlet.portlet;

import at.graz.meduni.bibbox.medicaldataset.model.MedicalRecord;
import at.graz.meduni.bibbox.medicaldataset.portlet.constants.MedicalDataSetPortletKeys;
import at.graz.meduni.bibbox.medicaldataset.service.MedicalRecordLocalService;
import at.graz.meduni.bibbox.medicaldataset.portlet.constants.MedicalDataSetWebKeys;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author reihsr
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=" + MedicalDataSetWebKeys.COM_LIFERAY_PORTLET_DISPLAY_CATEGORY,
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=" + MedicalDataSetPortletKeys.JAVAX_PORTLET_DISPLAY_NAME_MEDICAL_DATA_SET_PORTLET,
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/medicaldatasetportlet/view.jsp",
		"javax.portlet.name=" + MedicalDataSetPortletKeys.MEDICAL_DATA_SET,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class MedicalDataSetPortlet extends MVCPortlet {
	
	public void addEntry(ActionRequest request, ActionResponse response) throws PortalException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(MedicalRecord.class.getName(), request);
		//String userName = ParamUtil.getString(request, "name");
		/*
		 * try {

            _entryLocalService.updateEntry(
                serviceContext.getUserId(), guestbookId, entryId, userName,
                email, message, serviceContext);

            SessionMessages.add(request, "entryAdded");

            response.setRenderParameter(
                "guestbookId", Long.toString(guestbookId));

        }
        catch (Exception e) {
            System.out.println(e);

            SessionErrors.add(request, e.getClass().getName());

            PortalUtil.copyRequestParameters(request, response);

            response.setRenderParameter(
                "mvcPath", "/guestbookwebportlet/edit_entry.jsp");
        }
		 */
	}
	
	
	@Reference(unbind = "-")
	protected void setEntryService(MedicalRecordLocalService medicalRecordLocalService) {
		_medicalRecordLocalService = medicalRecordLocalService;
	}
	
	private MedicalRecordLocalService _medicalRecordLocalService;
}