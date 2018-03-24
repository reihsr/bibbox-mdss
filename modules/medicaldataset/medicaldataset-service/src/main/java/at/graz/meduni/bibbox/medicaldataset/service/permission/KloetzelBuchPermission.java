package at.graz.meduni.bibbox.medicaldataset.service.permission;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.BaseModelPermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

import at.graz.meduni.bibbox.medicaldataset.model.KloetzelBuch;
import at.graz.meduni.bibbox.medicaldataset.service.KloetzelBuchLocalService;

@Component(
	    immediate = true,
	    property = {"at.graz.meduni.bibbox.medicaldataset.model.KloetzelBuch"}
	)
public class KloetzelBuchPermission implements BaseModelPermissionChecker {

	public static void check(PermissionChecker permissionChecker, long kloetzelBuchId, String actionId) throws PortalException, SystemException {
		if (!contains(permissionChecker, kloetzelBuchId, actionId)) {
			throw new PrincipalException();
		}
	}
	
	public static boolean contains(PermissionChecker permissionChecker, long kloetzelBuchId, String actionId) throws PortalException {
		KloetzelBuch kloetzelBuch = _kloetzelBuchLocalService.getKloetzelBuch(kloetzelBuchId);
		return contains(permissionChecker, kloetzelBuch, actionId);
	}
	
	public static boolean contains(PermissionChecker permissionChecker, KloetzelBuch kloetzelBuch, String actionId) throws PortalException {
		return permissionChecker.hasPermission(kloetzelBuch.getGroupId(), KloetzelBuch.class.getName(), kloetzelBuch.getKloetzelBuchId(), actionId);
	}
	
	@Override
	public void checkBaseModel(PermissionChecker permissionChecker, long groupId, long kloetzelBuchId, String actionId) throws PortalException {
		check(permissionChecker, kloetzelBuchId, actionId);
	}
	
	@Reference(unbind = "-")
	protected void setKloetzelBuchLocalService(KloetzelBuchLocalService kloetzelBuchLocalService) {
		_kloetzelBuchLocalService = kloetzelBuchLocalService;
	}
	
	private static KloetzelBuchLocalService _kloetzelBuchLocalService;
}
