package at.graz.meduni.bibbox.medicaldataset.service.backgroundtask;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.liferay.portal.kernel.backgroundtask.BackgroundTask;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskManagerUtil;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskStatus;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskStatusRegistryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.StringPool;

public class BackgroundTaskHelper {

	public static long createImportAnalyseTask(long importMedicalDataSetId, String importType, String importName, ServiceContext serviceContext) {
		System.out.println("BackgroundTaskHelper.createImportAnalyseTask");
		long groupId = serviceContext.getScopeGroupId();
		long userId = serviceContext.getUserId();
		Map<String, Serializable> taskContextMap = new HashMap<>();
		taskContextMap.put("importMedicalDataSetId", importMedicalDataSetId);
		taskContextMap.put("importType", importType);
		taskContextMap.put("scopeGroupId", serviceContext.getScopeGroupId());
		taskContextMap.put("userId", serviceContext.getUserId());
		try {
			BackgroundTask task = BackgroundTaskManagerUtil.addBackgroundTask(userId, groupId, importName, ImportAnalyseTaskExecutor.class.getName(), taskContextMap, serviceContext);
			
			long backgroundTaskId = task.getBackgroundTaskId();
			System.out.println("BackgroundTaskHelper.createImportAnalyseTask " + backgroundTaskId);

			return backgroundTaskId;
		} catch (PortalException e) {
			System.err.println("-------> ERROR: at.graz.meduni.bibbox.medicaldataset.service.backgroundtask.BackgroundTaskHelper::createImportAnalyseTask");
			e.printStackTrace();
		}
		return 0;
	}
	
	public static long createImportImporterTask(long importMedicalDataSetId, String importName, ServiceContext serviceContext) {
		System.out.println("BackgroundTaskHelper.createImportImporterTask");
		long groupId = serviceContext.getScopeGroupId();
		long userId = serviceContext.getUserId();
		Map<String, Serializable> taskContextMap = new HashMap<>();
		taskContextMap.put("importMedicalDataSetId", importMedicalDataSetId);
		taskContextMap.put("scopeGroupId", groupId);
		taskContextMap.put("userId", userId);
		try {
			BackgroundTask task = BackgroundTaskManagerUtil.addBackgroundTask(userId, groupId, importName, ImportImporterTaskExecutor.class.getName(), taskContextMap, serviceContext);
			
			long backgroundTaskId = task.getBackgroundTaskId();
			System.out.println("BackgroundTaskHelper.createImportImporterTask " + backgroundTaskId);

			return backgroundTaskId;
		} catch (PortalException e) {
			System.err.println("-------> ERROR: at.graz.meduni.bibbox.medicaldataset.service.backgroundtask.BackgroundTaskHelper::createImportImporterTask");
			e.printStackTrace();
		}
		return 0;
	}
}
