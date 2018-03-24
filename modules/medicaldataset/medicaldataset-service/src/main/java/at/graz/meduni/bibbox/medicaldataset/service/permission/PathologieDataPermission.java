package at.graz.meduni.bibbox.medicaldataset.service.permission;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.BaseModelPermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

import at.graz.meduni.bibbox.medicaldataset.model.PathologieData;
import at.graz.meduni.bibbox.medicaldataset.service.PathologieDataLocalService;

@Component(
	    immediate = true,
	    property = {"at.graz.meduni.bibbox.medicaldataset.model.PathologieData"}
	)
public class PathologieDataPermission implements BaseModelPermissionChecker {

	public static void check(PermissionChecker permissionChecker, long pathologieDataId, String actionId) throws PortalException, SystemException {
		if (!contains(permissionChecker, pathologieDataId, actionId)) {
			throw new PrincipalException();
		}
	}
	
	public static boolean contains(PermissionChecker permissionChecker, long pathologieDataId, String actionId) throws PortalException {
		PathologieData pathologieData = _pathologieDataLocalService.getPathologieData(pathologieDataId);
		return contains(permissionChecker, pathologieData, actionId);
	}
	
	public static boolean contains(PermissionChecker permissionChecker, PathologieData pathologieData, String actionId) throws PortalException {
		return permissionChecker.hasPermission(pathologieData.getGroupId(), PathologieData.class.getName(), pathologieData.getPathologieDataId(), actionId);
	}
	
	@Override
	public void checkBaseModel(PermissionChecker permissionChecker, long groupId, long pathologieDataId, String actionId) throws PortalException {
		check(permissionChecker, pathologieDataId, actionId);
	}
	
	@Reference(unbind = "-")
	protected void setPathologieDataLocalService(PathologieDataLocalService pathologieDataLocalService) {
		_pathologieDataLocalService = pathologieDataLocalService;
	}
	
	private static PathologieDataLocalService _pathologieDataLocalService;
}
