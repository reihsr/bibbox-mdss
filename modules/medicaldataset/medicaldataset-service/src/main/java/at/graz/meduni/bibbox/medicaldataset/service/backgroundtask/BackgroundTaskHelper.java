package at.graz.meduni.bibbox.medicaldataset.service.backgroundtask;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.liferay.portal.kernel.backgroundtask.BackgroundTask;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskManagerUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.StringPool;

public class BackgroundTaskHelper {

	public static long createImportAnalyseTask(long importMedicalDataSetId, ServiceContext serviceContext) {
		long groupId = serviceContext.getScopeGroupId();
		long userId = serviceContext.getUserId();
		Map<String, Serializable> taskContextMap = new HashMap<>();
		taskContextMap.put("importMedicalDataSetId", importMedicalDataSetId);
		try {
			//BackgroundTask task = BackgroundTaskManagerUtil.addBackgroundTask(userId, groupId, "at.graz.meduni.bibbox.medicaldataset.service.backgroundtask.ImportAnalyseTaskExecutor", ImportAnalyseTaskExecutor.class.getName(), taskContextMap, serviceContext);
			BackgroundTask task = BackgroundTaskManagerUtil.addBackgroundTask(userId, groupId, "Name", ImportAnalyseTaskExecutor.class.getName(), taskContextMap, serviceContext);
			
			System.out.println("----> Task ID " + task.getBackgroundTaskId());
			return task.getBackgroundTaskId();
		} catch (PortalException e) {
			System.err.println("-------> ERROR: at.graz.meduni.bibbox.medicaldataset.service.backgroundtask.BackgroundTaskHelper::createImportAnalyseTask");
			e.printStackTrace();
		}
		return 0;
	}
}
