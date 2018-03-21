package at.graz.meduni.bibbox.informationprocessing.service.permission;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.BaseModelPermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.ResourcePermissionChecker;

import at.graz.meduni.bibbox.informationprocessing.model.Dictionary;
import at.graz.meduni.bibbox.informationprocessing.service.DictionaryLocalService;

@Component(immediate = true, property = { "at.graz.meduni.bibbox.informationprocessing.model.Dictionary" })

public class DictionaryModelPermission implements BaseModelPermissionChecker {

	public static void check(PermissionChecker permissionChecker, long dictionaryId, String actionId) throws PortalException, SystemException {
		if (!contains(permissionChecker, dictionaryId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(PermissionChecker permissionChecker, long groupId, long dictionaryId, String actionId) throws PortalException {
		if (!contains(permissionChecker, groupId, actionId)) {
			throw new PrincipalException.MustHavePermission(permissionChecker, Dictionary.class.getName(), dictionaryId, actionId);
		}
	}

	public static boolean contains(PermissionChecker permissionChecker, long groupId, long dictionaryId, String actionId) throws PortalException {
		Dictionary dictionary = _dictionaryLocalService.getDictionary(dictionaryId, groupId);
		return contains(permissionChecker, dictionary, actionId);
	}

	public static boolean contains(PermissionChecker permissionChecker, long dictionaryId, String actionId) throws PortalException, SystemException {
		Dictionary dictionary = _dictionaryLocalService.getDictionary(dictionaryId);
		return contains(permissionChecker, dictionary, actionId);
	}

	public static boolean contains(PermissionChecker permissionChecker, Dictionary dictionary, String actionId) throws PortalException, SystemException {
		return permissionChecker.hasPermission(dictionary.getGroupId(), Dictionary.class.getName(), dictionary.getDictionaryId(), actionId);
	}

	@Override
	public void checkBaseModel(PermissionChecker permissionChecker, long groupId, long dictionaryId, String actionId)
			throws PortalException {
		check(permissionChecker, dictionaryId, actionId);
	}

	@Reference(unbind = "-")
	protected void setDictionaryService(DictionaryLocalService dictionaryLocalService) {
		_dictionaryLocalService = dictionaryLocalService;
	}

	private static DictionaryLocalService _dictionaryLocalService;
}
