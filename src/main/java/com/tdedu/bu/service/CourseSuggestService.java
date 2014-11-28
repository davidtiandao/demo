package com.tdedu.bu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tdedu.bu.dao.CourseSuggestDao;
import com.tdedu.bu.domain.CourseSuggest;


@Component("courseSuggestService")
public class CourseSuggestService {
	@Autowired
	private CourseSuggestDao courseSuggestDao;
	
	public void saveCourseSuggest(CourseSuggest courseSuggest) throws Exception{
		courseSuggestDao.insert(courseSuggest);
	}

	public void deleteCourseSuggest(String[] suggestIds) throws Exception {
		courseSuggestDao.delete(suggestIds);
		
	}
}
