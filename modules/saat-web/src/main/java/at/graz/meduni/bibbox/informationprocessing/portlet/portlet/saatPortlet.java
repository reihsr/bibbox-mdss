package at.graz.meduni.bibbox.informationprocessing.portlet.portlet;

import at.graz.meduni.bibbox.informationprocessing.model.Dictionary;
import at.graz.meduni.bibbox.informationprocessing.portlet.constants.saatPortletKeys;
import at.graz.meduni.bibbox.informationprocessing.service.DictionaryDictionaryLinkLocalService;
import at.graz.meduni.bibbox.informationprocessing.service.DictionaryLocalService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author reihsr
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.saat",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=" + saatPortletKeys.SAAT_RULE_DISPLAY_PORTLET_NAME,
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/rulewebportlet/view.jsp",
		"javax.portlet.name=" + saatPortletKeys.saat,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class saatPortlet extends MVCPortlet {
	
	/*@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Dictionary.class.getName(), renderRequest);
			long groupId = serviceContext.getScopeGroupId();
			List<Dictionary> rules = _dictionaryLocalService.getRoot(groupId);
		} catch (Exception e) {
            throw new PortletException(e);
        }

        super.render(renderRequest, renderResponse);
	}*/
	
	public void addRule(ActionRequest request, ActionResponse response) throws PortalException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Dictionary.class.getName(), request);
		long dictionaryId = ParamUtil.getLong(request, "dictionaryId");
		Dictionary dictionary = _dictionaryLocalService.createDictionary(dictionaryId);
		createDictionaryFromRequest(dictionary, request);
	}
	
	private Dictionary createDictionaryFromRequest(Dictionary dictionary, ActionRequest request) throws PortalException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Dictionary.class.getName(), request);
		dictionary.setSynonym(ParamUtil.getString(request, "synonym"));
		dictionary.setPattern(ParamUtil.getString(request, "pattern"));
		dictionary.setCode(ParamUtil.getBoolean(request, "code"));
		dictionary.setCode_type(ParamUtil.getString(request, "code_type"));
		dictionary.setCode_value(ParamUtil.getString(request, "code_value"));
		dictionary.setRoot(ParamUtil.getBoolean(request, "root"));
		dictionary.setNegation(ParamUtil.getBoolean(request, "negation"));
		dictionary.setPriority(ParamUtil.getInteger(request, "priority"));
		dictionary.setPriority_mode(ParamUtil.getBoolean(request, "priority_mode"));
		
		dictionary.setBefore_synonym(ParamUtil.getInteger(request, "before_synonym"));
		dictionary.setAfter_synonym(ParamUtil.getInteger(request, "after_synonym"));
		dictionary.setForeword(ParamUtil.getBoolean(request, "foreword"));
		dictionary.setEnding(ParamUtil.getBoolean(request, "ending"));
		dictionary.setSentence(ParamUtil.getBoolean(request, "sentence"));
		dictionary.setOccure(ParamUtil.getBoolean(request, "occure"));
		
		return dictionary;
	}
	
	@Reference(unbind = "-")
	protected void setDictionaryService(DictionaryLocalService dictionaryLocalService) {
		_dictionaryLocalService = dictionaryLocalService;
	}
	
	@Reference(unbind = "-")
	protected void setDictionaryDictionaryLinkService(DictionaryDictionaryLinkLocalService dictionaryDictionaryLinkLocalService) {
		_dictionaryDictionaryLinkLocalService = dictionaryDictionaryLinkLocalService;
	}
	
	private DictionaryLocalService _dictionaryLocalService;
	private DictionaryDictionaryLinkLocalService _dictionaryDictionaryLinkLocalService;
}