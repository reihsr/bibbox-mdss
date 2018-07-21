package at.graz.meduni.bibbox.medicaldataset.service.permission;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.BaseModelPermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

import at.graz.meduni.bibbox.medicaldataset.model.PathologyData;
import at.graz.meduni.bibbox.medicaldataset.service.PathologyDataLocalService;

@Component(
	    immediate = true,
	    property = {"model.class.name=at.graz.meduni.bibbox.medicaldataset.model.PathologyData"}
	)
public class PathologyDataPermission implements BaseModelPermissionChecker {

	public static void check(PermissionChecker permissionChecker, long pathologyDataId, String actionId) throws PortalException, SystemException {
		if (!contains(permissionChecker, pathologyDataId, actionId)) {
			throw new PrincipalException();
		}
	}
	
	public static boolean contains(PermissionChecker permissionChecker, long pathologyDataId, String actionId) throws PortalException {
		PathologyData pathologyData = _pathologyDataLocalService.getPathologyData(pathologyDataId);
		return contains(permissionChecker, pathologyData, actionId);
	}
	
	public static boolean contains(PermissionChecker permissionChecker, PathologyData pathologyData, String actionId) throws PortalException {
		return permissionChecker.hasPermission(pathologyData.getGroupId(), PathologyData.class.getName(), pathologyData.getPathologyDataId(), actionId);
	}
	
	@Override
	public void checkBaseModel(PermissionChecker permissionChecker, long groupId, long pathologyDataId, String actionId) throws PortalException {
		check(permissionChecker, pathologyDataId, actionId);
	}
	
	@Reference(unbind = "-")
	protected void setPathologyDataLocalService(PathologyDataLocalService pathologyDataLocalService) {
		_pathologyDataLocalService = pathologyDataLocalService;
	}
	
	private static PathologyDataLocalService _pathologyDataLocalService;
}
