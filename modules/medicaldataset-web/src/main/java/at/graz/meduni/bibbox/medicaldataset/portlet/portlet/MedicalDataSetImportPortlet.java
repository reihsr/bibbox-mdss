package at.graz.meduni.bibbox.medicaldataset.portlet.portlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

import com.liferay.document.library.kernel.exception.DuplicateFileEntryException;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSet;
import at.graz.meduni.bibbox.medicaldataset.portlet.constants.MedicalDataSetImportPortletKeys;
import at.graz.meduni.bibbox.medicaldataset.portlet.constants.MedicalDataSetWebKeys;
import at.graz.meduni.bibbox.medicaldataset.service.ImportMedicalDataSetLocalServiceUtil;
import at.graz.meduni.bibbox.medicaldataset.service.backgroundtask.BackgroundTaskHelper;

@Component(
	    immediate = true,
	    property = {
	            "com.liferay.portlet.display-category=" + MedicalDataSetWebKeys.COM_LIFERAY_PORTLET_DISPLAY_CATEGORY,
	            "com.liferay.portlet.scopeable=true",
	            "javax.portlet.display-name=" + MedicalDataSetImportPortletKeys.JAVAX_PORTLET_DISPLAY_NAME_MEDICAL_DATA_SET_PORTLET,
	            "javax.portlet.expiration-cache=0",
	            "javax.portlet.init-param.portlet-title-based-navigation=true",
	            "javax.portlet.init-param.template-path=/",
	            "javax.portlet.init-param.view-template=/medicaldatasetimportportlet/view.jsp",
	            "javax.portlet.name=" + MedicalDataSetImportPortletKeys.MEDICAL_DATA_SET_IMPORT,
	            "javax.portlet.resource-bundle=content.Language",
	            "javax.portlet.security-role-ref=administrator",
	            "javax.portlet.supports.mime-type=text/html",
	            "com.liferay.portlet.add-default-resource=true"
	    },
	    service = Portlet.class
	)
public class MedicalDataSetImportPortlet extends MVCPortlet {
	
	private static String ROOT_FOLDER_NAME = "Import Folder";
	private static String ROOT_FOLDER_DESCRIPTION = "";
	private static long PARENT_FOLDER_ID = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
	
	public void step1UploadDocument(ActionRequest actionRequest,ActionResponse actionResponse) throws IOException,PortletException, PortalException, SystemException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		createFolder(actionRequest, themeDisplay);
		FileEntry fileEntry = fileUpload(themeDisplay, actionRequest);
		long importMedicalDataSetId = createImportTask(actionRequest, fileEntry);
		actionResponse.setRenderParameter("importMedicalDataSetId", String.valueOf(importMedicalDataSetId));
		actionResponse.setRenderParameter("jspPage", "/medicaldatasetimportportlet/importStep2.jsp");
	}
	
	private Folder createFolder(ActionRequest actionRequest, ThemeDisplay themeDisplay) {
		boolean folderExist = doseFolderExist(themeDisplay);
		Folder folder = null;
		if (!folderExist) {
			long repositoryId = themeDisplay.getScopeGroupId();		
			try {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), actionRequest);
				folder = DLAppServiceUtil.addFolder(repositoryId,PARENT_FOLDER_ID, ROOT_FOLDER_NAME,ROOT_FOLDER_DESCRIPTION, serviceContext);
			} catch (PortalException e1) {
				e1.printStackTrace();
			} catch (SystemException e1) {
				e1.printStackTrace();
			}			
		} else {
			try {
				DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), PARENT_FOLDER_ID, ROOT_FOLDER_NAME);
			} catch (Exception e) {	
				System.out.println(e.getMessage());
			}
		}
		return folder;
	}
	
	private boolean doseFolderExist(ThemeDisplay themeDisplay){
		boolean folderExist = false;
		try {
			DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), PARENT_FOLDER_ID, ROOT_FOLDER_NAME);
			folderExist = true;
		} catch (Exception e) {	
			System.out.println(e.getMessage());
		}
		return folderExist;
	}
	
	private FileEntry fileUpload(ThemeDisplay themeDisplay, ActionRequest actionRequest) {
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
      
		String fileName= uploadPortletRequest.getFileName("uploadedFile");		 			
		File file = uploadPortletRequest.getFile("uploadedFile");
		String mimeType = uploadPortletRequest.getContentType("uploadedFile");		
		
		String description = createFileDescription(actionRequest);
		long repositoryId = themeDisplay.getScopeGroupId();
		FileEntry fileEntry = null;
		String fileNameExtentionNumber= "";
		int counter = 1;
		while(fileEntry == null) {
			try {
				String fileName_created = generateFilenameWithExtensionNumber(fileName, fileNameExtentionNumber);
				fileEntry = createFile(fileEntry, themeDisplay, actionRequest, file, repositoryId, fileName_created, mimeType, fileName_created, description);
				fileNameExtentionNumber = "_" + counter;
				counter++;
				if(counter > 50) {
					break;
				}
			} catch (Exception e) {
		    	System.out.println(e.getMessage());
		    	e.printStackTrace();
		    	break;
		    }
		}
	    return fileEntry;
	}
	
	private String createFileDescription(ActionRequest actionRequest) {
		String fileDescription = "File Uploaded for Import Process ";
		fileDescription += ParamUtil.getString(actionRequest, "ImportName") + "\n";
		fileDescription += "Import Type: " + ParamUtil.getString(actionRequest, "ImportType") + "     \n\n";
		fileDescription += ParamUtil.getString(actionRequest, "Description");
		return fileDescription;
	}
	
	private String generateFilenameWithExtensionNumber(String fileName, String fileNameExtentionNumber) {
		String[] fileNameArray = fileName.split("\\.");
		fileName = "";
		if(fileNameArray.length == 1) {
			return fileName + fileNameExtentionNumber;
		}
		for(int i = fileNameArray.length - 1; i > 0; i--) {
			fileName = fileNameExtentionNumber + "." + fileNameArray[i] + fileName;
			fileNameExtentionNumber = "";
		}
		fileName = fileNameArray[0] + fileName;
		return fileName;
	}
	
	private FileEntry createFile(FileEntry fileEntry, ThemeDisplay themeDisplay, ActionRequest actionRequest, File file, long repositoryId, String fileName, String mimeType, String title, String description) throws PortalException, FileNotFoundException {
		try {  	
	    	Folder folder = getFolder(themeDisplay);
	    	ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), actionRequest);
	    	InputStream is = new FileInputStream( file );
	    	fileEntry = DLAppServiceUtil.addFileEntry(repositoryId, folder.getFolderId(), fileName, mimeType, title, description, "", is, file.getTotalSpace(), serviceContext);
	    	return fileEntry;
	    } catch (DuplicateFileEntryException e) {
	    	System.err.println("File With name \"" + fileName + "\" already exists.");
	    	return null;
	    }
	}
	
	private Folder getFolder(ThemeDisplay themeDisplay){
		Folder folder = null;
		try {
			folder =DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), PARENT_FOLDER_ID, ROOT_FOLDER_NAME);
		} catch (Exception e) {	
			System.out.println(e.getMessage());
		}
		return folder;
	}
	
	private long createImportTask(ActionRequest actionRequest, FileEntry fileEntry) {
		ServiceContext serviceContext;
		try {
			String importName = ParamUtil.getString(actionRequest, "ImportName");
			String importType = ParamUtil.getString(actionRequest, "ImportType");
			long iMIJobId = ParamUtil.getLong(actionRequest, "IMIJobId");
			String description = ParamUtil.getString(actionRequest, "Description");
			serviceContext = ServiceContextFactory.getInstance(ImportMedicalDataSet.class.getName(), actionRequest);
			ImportMedicalDataSet importMedicalDataSet = ImportMedicalDataSetLocalServiceUtil.addImportMedicalDataSet(importName, importType, 
					iMIJobId, description, fileEntry.getFileName(), fileEntry.getFolder().getName(), 
					fileEntry.getFileEntryId(), 1, serviceContext);
			BackgroundTaskHelper.createImportAnalyseTask(importMedicalDataSet.getImportMedicalDataSetId(), serviceContext);
			return importMedicalDataSet.getImportMedicalDataSetId();
		} catch (PortalException e) {
			System.out.println("at.graz.meduni.bibbox.medicaldataset.portlet.portlet.MedicalDataSetImportPortlet::createImportTask");
			e.printStackTrace();
		}
		return 0;
	}
}
