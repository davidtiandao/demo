package com.tdedu.bu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tdedu.bu.dao.CourseDao;
import com.tdedu.bu.dao.UserStudyDao;
import com.tdedu.bu.domain.UserStudy;
import com.tdedu.bu.vo.ChapterVo;
import com.tdedu.bu.vo.CourseVo;
import com.tdedu.bu.vo.SectionVo;
import com.tdedu.bu.vo.UserCourseVo;


public class CourseStudyService {
@Autowired
private UserStudyDao userStudyDao; 
@Autowired
private CourseDao courseDao;
public UserCourseVo getUserCourse(String uid){
	return userStudyDao.getuserCourse(uid);
}
public void selectCourse(String courseId,String userId) throws Exception{
	UserStudy userStudy=new UserStudy();
	userStudy.setCourseId(courseId);
	userStudy.setUserId(userId);
	userStudy.setSectionTime(0);
	userStudy.setStudyStatus(0);
	CourseVo coursevo=courseDao.getCourseInfo(courseId);
	List<ChapterVo> chapterList=coursevo.getChapters(); 
	for(ChapterVo chaptervo:chapterList){
		List<SectionVo> sectionList=chaptervo.getSections();
		for(SectionVo sectionvo:sectionList){
		userStudy.setSectionId(sectionvo.getId());
		userStudyDao.insert(userStudy);
		}
	}

}
}
