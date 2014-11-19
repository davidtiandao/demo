package com.tdedu.bu.dao;

import com.tdedu.bu.domain.Video;

public interface VideoDao extends BaseDao<Video> {
	public Video findBySection(String sectionId);
}
