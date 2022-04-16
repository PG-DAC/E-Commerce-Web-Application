package com.netcom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netcom.dtos.Response;
import com.netcom.entities.Category;
import com.netcom.exceptions.CustomException;
import com.netcom.services.CategoryServiceImpl;
import com.netcom.services.ProductServiceImpl;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/category")
public class CategoryController 
{
	@Autowired
	private CategoryServiceImpl categoServiceImpl;
	
	
	
	// add category
		@PostMapping("/add")
		public ResponseEntity<?> addCategory(@RequestBody Category newCategory)throws CustomException  {
			Category category = categoServiceImpl.addCategory(newCategory);
			if (category == null)
				return Response.error("Can not add Category error ");
			return Response.success(category);
		}
   //
		// show product details by category name
		@GetMapping("/{categoryName}")
		public ResponseEntity<?> findCategoryByName(@PathVariable("categoryName") String categoryName)throws CustomException  {
			Category category = categoServiceImpl.findByCategoryName(categoryName);
			if (category == null)
				return Response.error("Category not found");
			return Response.success(category);

		}
}
