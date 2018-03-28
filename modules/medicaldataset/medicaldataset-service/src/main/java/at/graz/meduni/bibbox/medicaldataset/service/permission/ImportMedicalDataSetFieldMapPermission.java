package at.graz.meduni.bibbox.medicaldataset.service.permission;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.BaseModelPermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

import at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap;
import at.graz.meduni.bibbox.medicaldataset.service.ImportMedicalDataSetFieldMapLocalService;

@Component(
	    immediate = true,
	    property = {"model.class.name=at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap"}
	)
public class ImportMedicalDataSetFieldMapPermission implements BaseModelPermissionChecker {

	public static void check(PermissionChecker permissionChecker, long importMedicalDataSetFieldMapId, String actionId) throws PortalException, SystemException {
		if (!contains(permissionChecker, importMedicalDataSetFieldMapId, actionId)) {
			throw new PrincipalException();
		}
	}
	
	public static boolean contains(PermissionChecker permissionChecker, long importMedicalDataSetFieldMapId, String actionId) throws PortalException {
		ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap = _importMedicalDataSetFieldMapLocalService.getImportMedicalDataSetFieldMap(importMedicalDataSetFieldMapId);
		return contains(permissionChecker, importMedicalDataSetFieldMap, actionId);
	}
	
	public static boolean contains(PermissionChecker permissionChecker, ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap, String actionId) throws PortalException {
		return permissionChecker.hasPermission(importMedicalDataSetFieldMap.getGroupId(), ImportMedicalDataSetFieldMap.class.getName(), importMedicalDataSetFieldMap.getImportMedicalDataSetFieldMapId(), actionId);
	}
	
	@Override
	public void checkBaseModel(PermissionChecker permissionChecker, long groupId, long importMedicalDataSetFieldMapId, String actionId) throws PortalException {
		check(permissionChecker, importMedicalDataSetFieldMapId, actionId);
	}
	
	@Reference(unbind = "-")
	protected void setImportMedicalDataSetFieldMapLocalService(ImportMedicalDataSetFieldMapLocalService importMedicalDataSetFieldMapLocalService) {
		_importMedicalDataSetFieldMapLocalService = importMedicalDataSetFieldMapLocalService;
	}
	
	private static ImportMedicalDataSetFieldMapLocalService _importMedicalDataSetFieldMapLocalService;
}
