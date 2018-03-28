package at.graz.meduni.bibbox.medicaldataset.service.permission;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.BaseModelPermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

import at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSet;
import at.graz.meduni.bibbox.medicaldataset.service.ImportMedicalDataSetLocalService;

@Component(
	    immediate = true,
	    property = {"model.class.name=at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSet"}
	)
public class ImportMedicalDataSetPermission implements BaseModelPermissionChecker {

	public static void check(PermissionChecker permissionChecker, long importMedicalDataSetId, String actionId) throws PortalException, SystemException {
		if (!contains(permissionChecker, importMedicalDataSetId, actionId)) {
			throw new PrincipalException();
		}
	}
	
	public static boolean contains(PermissionChecker permissionChecker, long importMedicalDataSetId, String actionId) throws PortalException {
		ImportMedicalDataSet importMedicalDataSet = _importMedicalDataSetLocalService.getImportMedicalDataSet(importMedicalDataSetId);
		return contains(permissionChecker, importMedicalDataSet, actionId);
	}
	
	public static boolean contains(PermissionChecker permissionChecker, ImportMedicalDataSet importMedicalDataSet, String actionId) throws PortalException {
		return permissionChecker.hasPermission(importMedicalDataSet.getGroupId(), ImportMedicalDataSet.class.getName(), importMedicalDataSet.getImportMedicalDataSetId(), actionId);
	}
	
	@Override
	public void checkBaseModel(PermissionChecker permissionChecker, long groupId, long importMedicalDataSetId, String actionId) throws PortalException {
		check(permissionChecker, importMedicalDataSetId, actionId);
	}
	
	@Reference(unbind = "-")
	protected void setImportMedicalDataSetLocalService(ImportMedicalDataSetLocalService importMedicalDataSetLocalService) {
		_importMedicalDataSetLocalService = importMedicalDataSetLocalService;
	}
	
	private static ImportMedicalDataSetLocalService _importMedicalDataSetLocalService;
}
