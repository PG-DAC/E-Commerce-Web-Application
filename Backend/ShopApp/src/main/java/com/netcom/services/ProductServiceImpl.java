package com.netcom.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.netcom.daos.CategoryDao;
import com.netcom.daos.FeedbackDao;
import com.netcom.daos.ProductDao;
import com.netcom.daos.SubCategoryDao;
import com.netcom.daos.UserDao;
import com.netcom.entities.Category;
import com.netcom.entities.Feedback;
import com.netcom.entities.Product;
import com.netcom.entities.SubCategory;
import com.netcom.entities.User;
import com.netcom.entities.Vendor;
import com.netcom.exceptions.CustomException;
import com.netcom.exceptions.ProductNotExistsException;


@Transactional
@Service
public class ProductServiceImpl {

	@Autowired
	private FeedbackDao feedbackDao;
	@Autowired
	private ProductDao productDao;
	@Autowired
	private UserDao userDao;
	

	/*
	 * public Feedback addFeedback(Feedback newFeedback) { Feedback feedback =
	 * feedbackDao.save(newFeedback); return feedback; }
	 * 
	 * public Feedback findFeedbackByRating(Feedback newFeedback) { Feedback
	 * feedback = feedbackDao.findByRating(newFeedback); return feedback; }
	 */
	
	 public Product addProduct(Product product)
	 {
			
		 int userid = product.getUser().getUserId();
			User user = userDao.findByUserId(userid);
			if (user.getRole().contentEquals("Vendor")) {
				Product savedproductdetails = productDao.save(product);
				return savedproductdetails;
			} else {
				return null;
			}
	 }
	 
	 
	 
	 
	 public Product findProductById(int id)
	 {
		 Product result=productDao.findByProductId(id);
		  if(result == null)
		  {
			  throw new CustomException("product not present");
		  }
		 return result;
	 }
	 
	 //find product by name
	 public List<Product> findProductByName(String name)
	 {
		 List<Product> result =  productDao.findByproductName(name);
		 System.out.println(result);
		 if(result == null)
		 {
			 return null;
		 }
		 else
		 return result;
	 }
	 
	 //Find product by  price
	 public List<Product> findProductByProductPrice( Double price)
	 {
		 List<Product> productPrice =productDao.findByProductFinalPrice(price);
		 return productPrice;
	 }
	 public List<Product> findProductByProductDiscountPrice( Double discountPrice)
	 {
		 List<Product> productDiscountPrice =productDao.findByProductDiscount(discountPrice);
		 return productDiscountPrice;
	 }
	 
	 public Product deleteProductById(int id)
	 {
		 Product product = productDao.findByProductId(id);
		 productDao.delete(product);
		 return product;
	 }
	 
	 public List<Product> sortProductByField(String[] field) {
		 
		 List<Product> product=productDao.findAll(Sort.by(Direction.ASC, field));
		 return product;
		 
	 }
	 
	 public List<Product> showAllProduct()
	 {
		List<Product> product = productDao.findAll();
		return product;
	 }



//find product by product id
	public Product findById(int productId) throws ProductNotExistsException {
		  Optional<Product> optionalProduct = productDao.findById(productId);
		 if(optionalProduct.isEmpty())
		 {
			 //here exception 
			 throw new ProductNotExistsException("product id " + " -> "+  productId +" " + "is not valid");
			
		 }
		 else
		 {
			 return optionalProduct.get() ;
		 }
		
	}




	public List<Product> findProductByCName(String cname) {
		   List<Product> productlist = productDao.findByCname(cname);
		   if(productlist.isEmpty())
		   {
			   return null;
		   }
		   else
		   {
		return productlist;
	}}




	public List<Product> findProductBySName(String sname) {
		List<Product> productlist = productDao.findBySname(sname);
		 if(productlist.isEmpty())
		   {
			   return null;
		   }
		   else
		   {
		return productlist;
	}}
		
	
	
}
