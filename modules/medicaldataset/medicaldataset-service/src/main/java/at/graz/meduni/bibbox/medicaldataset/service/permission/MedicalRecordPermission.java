package at.graz.meduni.bibbox.medicaldataset.service.permission;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.BaseModelPermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

import at.graz.meduni.bibbox.medicaldataset.model.MedicalRecord;
import at.graz.meduni.bibbox.medicaldataset.service.MedicalRecordLocalService;

@Component(
	    immediate = true,
	    property = {"at.graz.meduni.bibbox.medicaldataset.model.MedicalRecord"}
	)
public class MedicalRecordPermission implements BaseModelPermissionChecker {
	
	public static void check(PermissionChecker permissionChecker, long medicalRecordId, String actionId) throws PortalException, SystemException {
		if (!contains(permissionChecker, medicalRecordId, actionId)) {
			throw new PrincipalException();
		}
	}
	
	//Error in the docu?
	public static void check(PermissionChecker permissionChecker, long groupId, long medicalRecordId, String actionId) throws PortalException {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!-> at.graz.meduni.bibbox.medicaldataset.service.permission.MedicalRecordPermission.check????????");
		if (!contains(permissionChecker, groupId, actionId)) {
			throw new PrincipalException.MustHavePermission(permissionChecker, MedicalRecord.class.getName(), medicalRecordId, actionId);
		}
	}
	
	//Error in the docu?
	public static boolean contains(PermissionChecker permissionChecker, long groupId, long medicalRecordId, String actionId) throws PortalException {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!-> at.graz.meduni.bibbox.medicaldataset.service.permission.MedicalRecordPermission.contains????????");
		MedicalRecord medicalrecord = _medicalRecordLocalService.getMedicalRecord(medicalRecordId);
		return MedicalDataSetModelPermission.contains(permissionChecker, groupId, actionId);
	}
	
	public static boolean contains(PermissionChecker permissionChecker, long medicalRecordId, String actionId) throws PortalException {
		MedicalRecord medicalrecord = _medicalRecordLocalService.getMedicalRecord(medicalRecordId);
		return contains(permissionChecker, medicalrecord, actionId);
	}
	
	public static boolean contains(PermissionChecker permissionChecker, MedicalRecord medicalrecord, String actionId) throws PortalException {
		return permissionChecker.hasPermission(medicalrecord.getGroupId(), MedicalRecord.class.getName(), medicalrecord.getMedicalRecordId(), actionId);
	}
	

	@Override
	public void checkBaseModel(PermissionChecker permissionChecker, long groupId, long medicalRecordId, String actionId) throws PortalException {
		check(permissionChecker, medicalRecordId, actionId);
	}
	
	@Reference(unbind = "-")
	protected void setMedicalRecordLocalService(MedicalRecordLocalService medicalRecordLocalService) {
		_medicalRecordLocalService = medicalRecordLocalService;
	}
	
	private static MedicalRecordLocalService _medicalRecordLocalService;

}
