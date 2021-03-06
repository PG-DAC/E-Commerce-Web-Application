package com.netcom.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.netcom.dtos.Response;
import com.netcom.entities.Category;
import com.netcom.entities.Feedback;
import com.netcom.entities.Product;
import com.netcom.entities.SubCategory;
import com.netcom.services.ProductServiceImpl;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductServiceImpl productService;

	/*
	 * // add feedback
	 * 
	 * @PostMapping("/feedback/add") public ResponseEntity<?>
	 * addFeedback(@RequestBody Feedback newFeedback) { Feedback feedback =
	 * productService.addFeedback(newFeedback); if (newFeedback == null) return
	 * Response.error("Failure"); return Response.success(newFeedback); }
	 */

	
	//Add products
	@PostMapping("/add") //done
	public @ResponseBody ResponseEntity<?> addProduct(@RequestBody Product product)
	{
		Product result = productService.addProduct(product);
		if(result == null)
		{
			return Response.error("Only Vendor can add product");
		}
		return Response.success(result);
	}

	
	
	@GetMapping("/findbyname/{name}")
	public ResponseEntity<?> findProductByName(@PathVariable("name") String name) {
		List<Product> result = productService.findProductByName(name);
		if(result == null)
		{
			return Response.error("Not found product with name " +name);
		}
		return Response.success(result);
	}

	@GetMapping("/findbyprice/{price}")
	public ResponseEntity<?> findProductByPrice(@PathVariable("price") Double price) {
		List<Product> result = productService.findProductByProductPrice(price);
		return Response.success(result);
	}

	@GetMapping("/discountPrice/{discountPrice}")
	public ResponseEntity<?> findProductByDiscountPrice(@PathVariable("discountPrice") Double price) {
		List<Product> result = productService.findProductByProductDiscountPrice(price);
		return Response.success(result);
	}

	@SuppressWarnings("unchecked")
	@PutMapping("/editProduct/{id}")
	public ResponseEntity<?> editProductById(@PathVariable("id") int id, @RequestBody Product productDetails) {
		Product product = productService.findProductById(id);
		if (product == null) {
			return (ResponseEntity<Product>) Response.error("User not exist with id :" + id);
		}

		product.setProductName(productDetails.getProductName());
		product.setProductDescription(productDetails.getProductDescription());
		product.setProductQuantity(productDetails.getProductQuantity());
		product.setProductImage(productDetails.getProductImage());
		product.setProductPrice(productDetails.getProductPrice());
		product.setProductDiscount(productDetails.getProductDiscount());
		product.setProductFinalPrice(productDetails.getProductFinalPrice());

		Product updatedProduct = productService.addProduct(product);
		return ResponseEntity.ok(updatedProduct);
	}
	
  //done
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteProductById(@PathVariable("id") int id) {
		Product product = productService.findProductById(id);
		if (product != null) {
			Product deletedProduct = productService.deleteProductById(id);
			return Response.success(deletedProduct);
		} else {
			return Response.error("product does not exists");
		}

	}
	
	@GetMapping("/sort/{field}")
	public ResponseEntity<?> sortProductByField(@PathVariable("field") String[] field)
	{
		 List<Product> product=productService.sortProductByField(field);
		 if(product !=null)
		 {
			 return Response.success(product);
		 }
		 else {
			 return Response.error("product does not esists");
		 }
	}
	
	
	@GetMapping("/show")
	public ResponseEntity<?> showProduct()
	{
		 List<Product> product=productService.showAllProduct();
		 if(product !=null)
		 {
			 return Response.success(product);
		 }
		 else {
			 return Response.error("product does not esists");
		 }
	}
	
	@GetMapping("/findbyid/{id}")
	public ResponseEntity<?> findProductByName(@PathVariable("id") int id) {
		Product result = productService.findProductById(id);
		if(result == null)
		{
			return Response.error("Not found product with id " +id);
		}
		return Response.success(result);
	}
	
	//findby category Name
	@GetMapping("/findbycname/{Cname}")
	public ResponseEntity<?> findProductBycName(@PathVariable("Cname") String Cname) {
		List<Product> result = productService.findProductByCName(Cname);
		if(result == null)
		{
			return Response.error("Not found product with subcategory " +Cname);
		}
		return Response.success(result);
	}
	
	//Find By sub category name
	@GetMapping("/findbysname/{Sname}")
	public ResponseEntity<?> findProductBySName(@PathVariable("Sname") String Sname) {
		List<Product> result = productService.findProductBySName(Sname);
		if(result == null)
		{
			return Response.error("Not found product with subcategory " +Sname);
		}
		return Response.success(result);
	}
	
	
	
}
