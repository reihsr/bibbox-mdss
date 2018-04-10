package at.graz.meduni.bibbox.medicaldataset.service.backgroundtask;

import java.util.Map;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.backgroundtask.BackgroundTask;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskConstants;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskExecutor;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskResult;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskThreadLocal;
import com.liferay.portal.kernel.backgroundtask.BaseBackgroundTaskExecutor;
import com.liferay.portal.kernel.backgroundtask.display.BackgroundTaskDisplay;
import com.liferay.portal.kernel.backgroundtask.display.BackgroundTaskDisplayFactoryUtil;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;

@Component(
	immediate = true, 
	property = {"background.task.executor.class.name=at.graz.meduni.bibbox.medicaldataset.service.backgroundtask.ImportAnalyseTaskExecutor"}, 
	service = BackgroundTaskExecutor.class
)
public class ImportAnalyseTaskExecutor extends BaseBackgroundTaskExecutor {
	
	public ImportAnalyseTaskExecutor() {
		setBackgroundTaskStatusMessageTranslator(new ImportAnalyseTaskStatusMessageTranslator());
	}

	@Override
	public BackgroundTaskResult execute(BackgroundTask backgroundTask) throws Exception {
		Map taskContextMap = backgroundTask.getTaskContextMap();
		System.out.println("------> BING!!");
		return BackgroundTaskResult.SUCCESS;
	}
	
	/*
	public void testClass() {
		for(int i = 0; i< 20; i++) {
		    try {
		    	
		    	Message message = new Message();

		    	// Background task id needs to be passed

		    	message.put("backgroundTaskId", BackgroundTaskThreadLocal.getBackgroundTaskId());
		    	message.put("abc", "Run! " + i);

		    	// Pass all the necessary attributes here

		    	// Send it over the built-in Message Bus to the background task status
		    	// destination

		    	MessageBusUtil.sendMessage(DestinationNames.BACKGROUND_TASK_STATUS, message);
		    	
		        //sending the actual Thread of execution to sleep X milliseconds
		        Thread.sleep(15000);
		    } catch(InterruptedException ie) {
		    	System.err.println("------> testClass");
		    }
		    System.out.println("Run! " + i);
		    //message system
		}
	}*/

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
