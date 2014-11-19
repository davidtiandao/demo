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
	public void insert(){
		Chapter chapter=new Chapter();
		chapter.setChapterTitle("雅思口语");
		chapter.setId(UUID.randomUUID().toString());
		chapter.setHierarchy(2);
		chapter.setChapterCreateDate(new Date());
		chapter.setChapterUpdateDate(new Date());
		chapter.setCourseId("3f0fed46-1c79-4580-abe4-47e07f7fa28c");
		chapter.setChapterStatus(2);
		chapter.setChapterNo("wgvelknlnw");
		chapter.setChapterVersion("flkenlfnwe");
		chapterDao.insert(chapter);
	}
	@Test
	public void select(){
		chapterDao.get("3f0fed46-1c79-4580-abe4-47e07f7fa28c");
	}
	@Test
	public void update(){
		Chapter chapter=new Chapter();
		chapter.setChapterTitle("雅思口语_口语俄外交部副");
		chapter.setId("0728101b-a2e8-49c9-b1a0-20ca35b115e5");
		chapter.setHierarchy(2);
		chapter.setChapterCreateDate(new Date());
		chapter.setChapterUpdateDate(new Date());
		chapter.setCourseId("3f0fed46-1c79-4580-abe4-47e07f7fa28c");
		chapter.setChapterStatus(2);
		chapter.setChapterNo("wgvelknlnw");
		chapter.setChapterVersion("flkenlfnwe");
		chapterDao.update(chapter);
	}
	@Test
	public void delete(){
		chapterDao.deleteById("4b9e42e4-6b27-4086-a3ed-0e5e4b7c72ff");
	}
}
