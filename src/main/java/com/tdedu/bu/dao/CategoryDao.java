package com.tdedu.bu.dao;

import java.util.List;
import java.util.Map;

import com.tdedu.bu.domain.Category;

public interface CategoryDao extends BaseDao<Category> {

	public List<Category> listCategory(Map<String, Object> mapCategory);

	public Integer findByHierarchy(String uid);
	public List<Category> findCategoryParent(String categoryParentId);

	public void updateStatus(Map<String, Object> mapCategoryStatus) throws Exception;

}
