package at.graz.meduni.bibbox.medicaldataset.service.permission;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.BaseModelPermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

import at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog;
import at.graz.meduni.bibbox.medicaldataset.service.ImportMedicalDataSetLogLocalService;

@Component(
	    immediate = true,
	    property = {"model.class.name=at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog"}
	)
public class ImportMedicalDataSetLogPermission implements BaseModelPermissionChecker {

	public static void check(PermissionChecker permissionChecker, long importMedicalDataSetLogId, String actionId) throws PortalException, SystemException {
		if (!contains(permissionChecker, importMedicalDataSetLogId, actionId)) {
			throw new PrincipalException();
		}
	}
	
	public static boolean contains(PermissionChecker permissionChecker, long importMedicalDataSetLogId, String actionId) throws PortalException {
		ImportMedicalDataSetLog importMedicalDataSetLog = _importMedicalDataSetLogLocalService.getImportMedicalDataSetLog(importMedicalDataSetLogId);
		return contains(permissionChecker, importMedicalDataSetLog, actionId);
	}
	
	public static boolean contains(PermissionChecker permissionChecker, ImportMedicalDataSetLog importMedicalDataSetLog, String actionId) throws PortalException {
		return permissionChecker.hasPermission(importMedicalDataSetLog.getGroupId(), ImportMedicalDataSetLog.class.getName(), importMedicalDataSetLog.getImportMedicalDataSetLogId(), actionId);
	}
	
	@Override
	public void checkBaseModel(PermissionChecker permissionChecker, long groupId, long importMedicalDataSetLogId, String actionId) throws PortalException {
		check(permissionChecker, importMedicalDataSetLogId, actionId);
	}
	
	@Reference(unbind = "-")
	protected void setImportMedicalDataSetLogLocalService(ImportMedicalDataSetLogLocalService importMedicalDataSetLogLocalService) {
		_importMedicalDataSetLogLocalService = importMedicalDataSetLogLocalService;
	}
	
	private static ImportMedicalDataSetLogLocalService _importMedicalDataSetLogLocalService;
}
