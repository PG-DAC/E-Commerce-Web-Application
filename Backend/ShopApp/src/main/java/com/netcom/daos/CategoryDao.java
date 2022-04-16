package com.netcom.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.netcom.entities.Category;

public interface CategoryDao extends JpaRepository<Category, String>{

	Category findByCategoryName(String categoryName);
	//Category deleteCategory(String categoryName);


}
