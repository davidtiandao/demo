package com.tdedu.bu.dao;

import java.util.List;
import java.util.Map;

import com.tdedu.bu.domain.Category;
import com.tdedu.bu.web.PageBean;

public interface CategoryDao extends BaseDao<Category> {

	public List<Category> listCategory(Map<String, Object> mapCategory);

	public Integer findByHierarchy(String uid);
	public List<Category> findCategoryParent();
}
