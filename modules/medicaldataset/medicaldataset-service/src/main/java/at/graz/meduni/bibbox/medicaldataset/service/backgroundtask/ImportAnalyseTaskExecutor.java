package at.graz.meduni.bibbox.medicaldataset.service.backgroundtask;

import java.util.Map;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.backgroundtask.BackgroundTask;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskConstants;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskExecutor;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskResult;
import com.liferay.portal.kernel.backgroundtask.BaseBackgroundTaskExecutor;
import com.liferay.portal.kernel.backgroundtask.display.BackgroundTaskDisplay;
import com.liferay.portal.kernel.backgroundtask.display.BackgroundTaskDisplayFactoryUtil;

@Component(
	immediate = true, 
	property = {"background.task.executor.class.name=at.graz.meduni.bibbox.medicaldataset.service.backgroundtask.ImportAnalyseTaskExecutor"}, 
	service = BackgroundTaskExecutor.class
)
public class ImportAnalyseTaskExecutor extends BaseBackgroundTaskExecutor {
	
	public ImportAnalyseTaskExecutor() {
		System.out.println("------> Bong!!");
		setBackgroundTaskStatusMessageTranslator(new ImportAnalyseTaskStatusMessageTranslator());
	}

	@Override
	public BackgroundTaskResult execute(BackgroundTask backgroundTask) throws Exception {
		Map taskContextMap = backgroundTask.getTaskContextMap();
		System.out.println("------> BING!!");
		return BackgroundTaskResult.SUCCESS;
	}
	
	public void testClass() {
		for(int i = 0; i< 30; i++) {
		    try {
		        //sending the actual Thread of execution to sleep X milliseconds
		        Thread.sleep(15000);
		    } catch(InterruptedException ie) {}
		    System.out.println("Run! " + i);
		    //message system
		}
	}

	@Override
	public BackgroundTaskDisplay getBackgroundTaskDisplay(BackgroundTask backgroundTask) {
		System.out.println("ImportAnalyseTaskExecutor.getBackgroundTaskDisplay");
		return BackgroundTaskDisplayFactoryUtil.getBackgroundTaskDisplay(backgroundTask);
		//return new ImportAnalyseTaskDisplay(backgroundTask);
	}

	@Override
	public BackgroundTaskExecutor clone() {
		System.out.println("clone ImportAnalyseTaskExecutor");
		return this;
	}
	
	@Override
	public boolean isSerial() {
		return true;
	}
	
	@Override
	public int getIsolationLevel() {
		return BackgroundTaskConstants.ISOLATION_LEVEL_TASK_NAME;
	}
}
