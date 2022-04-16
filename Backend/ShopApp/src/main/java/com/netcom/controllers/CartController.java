package com.netcom.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.netcom.dtos.AddToCartDto;
import com.netcom.dtos.CartDto;
import com.netcom.dtos.Response;
import com.netcom.entities.Cart;
import com.netcom.entities.Product;
import com.netcom.entities.User;
import com.netcom.services.CartServiceImpl;
import com.netcom.services.ProductServiceImpl;
import com.netcom.services.UserServiceImpl;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/cart")
public class CartController 
{
	@Autowired
	private CartServiceImpl cartService;
	
	@Autowired
	private UserServiceImpl userService;
	
	// cart add
	
	@PostMapping("/add/{id}")
	public @ResponseBody ResponseEntity<?> addTocart(@RequestBody AddToCartDto addToCartDto, @PathVariable("id") int id  ) {

		User user = userService.findUserById(id);
		//System.out.println(user);
	 Cart cart = cartService.addToCart(addToCartDto,user);
	
			return Response.success("Added product to cart successfully" +cart);
	}
	
	
	//get all cartitems for a user
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<?> getCartItems( @PathVariable("id") int id  ) {

		User user = userService.findUserById(id);
		//System.out.println(user);
		//get cart items
	 CartDto cartList = cartService.listCartItems(user);
	
			return Response.success(cartList);
	}
	
	//delete cart item by user
	@DeleteMapping("/delete/{cartItemId}/{id}")
	public @ResponseBody ResponseEntity<?> deleteCartItems(@PathVariable("cartItemId") int cartItemId,@PathVariable("id") int userid ) {
		User user = userService.findUserById(userid);
		cartService.deleteCartItem(cartItemId,user);
		return Response.success("the cart items is deleted ");
		
	}
	
	//delete allcart item by userid on check out
		@DeleteMapping("/checkout/{id}")
		public @ResponseBody ResponseEntity<?> deleteAllCartItems(@PathVariable("id") int userid ) {
			User user = userService.findUserById(userid);
			if(user == null)
			{
				return Response.error("user does not exist");
			}
			else
			{
			 cartService.deleteAllCartItems(user);
			return Response.success("the cart items is deleted ");
			}
		}
	
	

}
