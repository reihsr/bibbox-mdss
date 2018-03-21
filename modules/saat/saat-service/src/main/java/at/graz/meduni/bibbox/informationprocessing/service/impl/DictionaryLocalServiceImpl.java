/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package at.graz.meduni.bibbox.informationprocessing.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import at.graz.meduni.bibbox.informationprocessing.exception.NoSuchDictionaryException;
import at.graz.meduni.bibbox.informationprocessing.model.Dictionary;
import at.graz.meduni.bibbox.informationprocessing.service.base.DictionaryLocalServiceBaseImpl;

/**
 * The implementation of the dictionary local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.graz.meduni.bibbox.informationprocessing.service.DictionaryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author robert
 * @see DictionaryLocalServiceBaseImpl
 * @see at.graz.meduni.bibbox.informationprocessing.service.DictionaryLocalServiceUtil
 */
public class DictionaryLocalServiceImpl extends DictionaryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link at.graz.meduni.bibbox.informationprocessing.service.DictionaryLocalServiceUtil} to access the dictionary local service.
	 */
	
	public Dictionary addDictionary(String synonym, String pattern, boolean code, String code_type, String code_value, 
			boolean root, boolean negation, int priority, boolean priority_mode, int before_synonym, int after_synonym,
			boolean foreword, boolean ending, boolean sentence, boolean occure,
			long userId, ServiceContext serviceContext) throws PortalException {
		
		long groupId = serviceContext.getScopeGroupId();
	    User user = userLocalService.getUserById(userId);
	    Date now = new Date();
	    
	    long dictionaryId = counterLocalService.increment();
	    Dictionary dictionary = dictionaryPersistence.create(dictionaryId);
	    
	    dictionary.setUuid(serviceContext.getUuid());
	    dictionary.setUserId(userId);
	    dictionary.setGroupId(groupId);
	    dictionary.setCompanyId(user.getCompanyId());
	    dictionary.setUserName(user.getFullName());
	    dictionary.setCreateDate(serviceContext.getCreateDate(now));
	    dictionary.setModifiedDate(serviceContext.getModifiedDate(now));
	    
	    dictionary.setSynonym(synonym);
	    dictionary.setPattern(pattern);
	    dictionary.setCode(code);
	    dictionary.setCode_type(code_type);
	    dictionary.setCode_value(code_value);
	    dictionary.setRoot(root);
	    dictionary.setNegation(negation);
	    dictionary.setPriority(priority);
	    dictionary.setPriority_mode(priority_mode);
	    
	    dictionary.setBefore_synonym(before_synonym);
	    dictionary.setAfter_synonym(after_synonym);
	    dictionary.setForeword(foreword);
	    dictionary.setEnding(ending);
	    dictionary.setSentence(sentence);
	    dictionary.setOccure(occure);
	    
	    dictionaryPersistence.update(dictionary);
	    resourceLocalService.addResources(user.getCompanyId(), groupId, userId, Dictionary.class.getName(), dictionaryId, false, true, true);
	    return dictionary;
	}
	
	public Dictionary addDictionary(Dictionary dictionary, ServiceContext serviceContext) throws PortalException {
		long groupId = serviceContext.getScopeGroupId();
	    User user = userLocalService.getUserById(serviceContext.getUserId());
	    Date now = new Date();
	    dictionary.setUuid(serviceContext.getUuid());
	    dictionary.setUserId(serviceContext.getUserId());
	    dictionary.setGroupId(groupId);
	    dictionary.setCompanyId(user.getCompanyId());
	    dictionary.setUserName(user.getFullName());
	    dictionary.setCreateDate(serviceContext.getCreateDate(now));
	    dictionary.setModifiedDate(serviceContext.getModifiedDate(now));
	    
	    dictionaryPersistence.update(dictionary);
	    resourceLocalService.addResources(user.getCompanyId(), groupId, serviceContext.getUserId(), Dictionary.class.getName(), dictionary.getDictionaryId(), false, true, true);
	    return dictionary;
	}
	
	public Dictionary updateDictionary(long dictionaryId, String synonym, String pattern, boolean code, String code_type, String code_value, 
			boolean root, boolean negation, int priority, boolean priority_mode, int before_synonym, int after_synonym,
			boolean foreword, boolean ending, boolean sentence, boolean occure,
			long userId, ServiceContext serviceContext) throws PortalException {
		
		long groupId = serviceContext.getScopeGroupId();
	    User user = userLocalService.getUserById(userId);
	    Date now = new Date();
	    
	    Dictionary dictionary = getDictionary(dictionaryId);
	   
	    dictionary.setUserId(userId);
	    dictionary.setUserName(user.getFullName());
	    dictionary.setModifiedDate(serviceContext.getModifiedDate(now));
	    
	    dictionary.setSynonym(synonym);
	    dictionary.setPattern(pattern);
	    dictionary.setCode(code);
	    dictionary.setCode_type(code_type);
	    dictionary.setCode_value(code_value);
	    dictionary.setRoot(root);
	    dictionary.setNegation(negation);
	    dictionary.setPriority(priority);
	    dictionary.setPriority_mode(priority_mode);
	    
	    dictionary.setBefore_synonym(before_synonym);
	    dictionary.setAfter_synonym(after_synonym);
	    dictionary.setForeword(foreword);
	    dictionary.setEnding(ending);
	    dictionary.setSentence(sentence);
	    dictionary.setOccure(occure);
	    
	    dictionaryPersistence.update(dictionary);
	    
	    resourceLocalService.updateResources(serviceContext.getCompanyId(),
                serviceContext.getScopeGroupId(), 
                Dictionary.class.getName(), dictionaryId,
                serviceContext.getGroupPermissions(),
                serviceContext.getGuestPermissions());
	    
	    return dictionary;
	}
	
	public Dictionary deleteEntry(long dictionaryId, ServiceContext serviceContext) throws PortalException {
		Dictionary dictionary = getDictionary(dictionaryId);
		dictionary = deleteDictionary(dictionaryId);
		// Delete oter data
		resourceLocalService.deleteResource(serviceContext.getCompanyId(),
				Dictionary.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
				dictionaryId);
		return dictionary;
	}
	
	public Dictionary deleteEntry(long dictionaryId) throws PortalException {
		Dictionary dictionary = getDictionary(dictionaryId);
		long companyId = dictionary.getCompanyId();
		dictionary = deleteDictionary(dictionaryId);
		// Delete oter data
		resourceLocalService.deleteResource(companyId,
				Dictionary.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
				dictionaryId);
		return dictionary;
	}
	
	public List<Dictionary>  getRoot(long groupId) {
		return dictionaryPersistence.findByRoot(true, groupId);
	}
	
	public List<Dictionary>  getRoot(long groupId, int start, int end, OrderByComparator<Dictionary> obc) {
		return dictionaryPersistence.findByRoot(true, groupId, start, end, obc);
	}
	
	public List<Dictionary>  getRoot(long groupId, int start, int end) {
		return dictionaryPersistence.findByRoot(true, groupId, start, end);
	}
	
	public int  getRootCount(long groupId) {
		return dictionaryPersistence.countByRoot(true, groupId);
	}

	public Dictionary getDictionary(long dictionaryId, long groupId) throws NoSuchDictionaryException {
		return dictionaryPersistence.findByDirectory(dictionaryId, groupId);
	}
}