package com.tdedu.bu.test;

import java.util.Date;
import java.util.UUID;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tdedu.bu.dao.ChapterDao;
import com.tdedu.bu.domain.Chapter;

public class TestChapter {
	ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
	ChapterDao chapterDao=(ChapterDao) applicationContext.getBean("chapterDao");	
	@Test
	public void insert() throws Exception{
		Chapter chapter=new Chapter();
		chapter.setChapterTitle("雅思口语");
		chapter.setId(UUID.randomUUID().toString());
		chapter.setHierarchy(2);
		chapter.setChapterCreateDate(new Date());
		chapter.setChapterUpdateDate(new Date());
		chapter.setCourseId("2d9bcb24-c146-43c4-9a04-0a1c31e8ccf2");
		chapter.setChapterStatus(2);
		chapter.setChapterNo("wgvelknlnw");
		chapter.setChapterVersion("flkenlfnwe");
		chapterDao.insert(chapter);
	}
	@Test
	public void select(){
		chapterDao.get("ab29b0c8-3cfd-40a2-8920-8bce426d777f");
	}
	@Test
	public void update() throws Exception{
		Chapter chapter=new Chapter();
		chapter.setChapterTitle("雅思口语_口语俄外交部副");
		chapter.setId("ab29b0c8-3cfd-40a2-8920-8bce426d777f");
		chapter.setHierarchy(2);
		chapter.setChapterCreateDate(new Date());
		chapter.setChapterUpdateDate(new Date());
		chapter.setCourseId("2d9bcb24-c146-43c4-9a04-0a1c31e8ccf2");
		chapter.setChapterStatus(2);
		chapter.setChapterNo("wgvelknlnw");
		chapter.setChapterVersion("flkenlfnwe");
		chapterDao.update(chapter);
	}
	@Test
	public void delete() throws Exception{
		chapterDao.deleteById("ab29b0c8-3cfd-40a2-8920-8bce426d777f");
	}
}
