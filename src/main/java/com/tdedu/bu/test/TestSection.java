package com.tdedu.bu.test;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tdedu.bu.dao.SectionDao;
import com.tdedu.bu.domain.Section;

public class TestSection {
	ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
	SectionDao sectionDao=(SectionDao) applicationContext.getBean("sectionDao");	
	
	@Test
	public void testInsert(){
		Section section=new Section();
		section.setId(UUID.randomUUID().toString());
		section.setSectionCreateDate(new Date());
		section.setSectionName("ewjhfjkewbgh");
		section.setSectionStatus(2);
		section.setSectionUpdateDate(new Date());
		section.setTeacherId("127622ef-33b2-46df-b981-f57e4f92cd38");
		section.setSectionTypeId("rehgrehre");
		section.setSectionVersion("001001");
		sectionDao.insert(section);
	}
	@Test
	public void testSeclect(){
		List<Section> sections=sectionDao.find(2);
		Section section=sectionDao.get("0ebd4887-24cc-48e9-a82f-42eb719335e0");
		System.out.println(sections.get(0).getSectionName()); 
		System.out.println(section.getSectionName());
	}
	
	@Test
	public void testUpdate(){
		Section section=new Section();
		section.setId("0ebd4887-24cc-48e9-a82f-42eb719335e0");
		section.setSectionCreateDate(new Date());
		section.setSectionName("雅思4级口语视频");
		section.setSectionStatus(2);
		section.setSectionUpdateDate(new Date());
		section.setTeacherId("127622ef-33b2-46df-b981-f57e4f92cd38");
		section.setSectionTypeId("rehgrehre");
		sectionDao.update(section);
	}
	@Test
	public void testDelete(){
		sectionDao.deleteById("0ebd4887-24cc-48e9-a82f-42eb719335e0");
	}
}
