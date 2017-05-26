
package com.niit.back.userdao;

import java.util.List;

import com.niit.back.domain.Category;

public interface CategoryDAO {

	public boolean save(Category category);

	public boolean update(Category category);

	public List<Category> list();

	public Category get(String categoryId);
	
	public void delete(String categoryId);
	

}
