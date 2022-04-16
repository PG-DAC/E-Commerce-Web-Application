package com.netcom.controllers;

import java.io.Console;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.netcom.dtos.Credentials;
import com.netcom.dtos.Response;
import com.netcom.entities.Address;
import com.netcom.entities.Product;
import com.netcom.entities.User;
import com.netcom.exceptions.CustomException;
import com.netcom.services.ProductServiceImpl;
import com.netcom.services.UserServiceImpl;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private ProductServiceImpl productService;
	
	//Create Account
	@PostMapping("/signup")
	public @ResponseBody ResponseEntity<?> signUp(@RequestBody User newuser)throws CustomException {

		User Result = userService.saveUser(newuser);
		if (Result == null) {
			return Response.error("User with same mail id already exists");
		} else
			return Response.success(Result);
	}

	// Login to the portal
	@PostMapping("/signin")
	public @ResponseBody ResponseEntity<?> signIn(@RequestBody Credentials cred) throws CustomException{
		{
			User user = userService.findUserByEmailAndPassword(cred);
			if (user == null)
				return Response.error("User not found");
			return Response.success(user);
		}
	}

	// get profile details with out address
	@GetMapping("/profile/{id}")
	public @ResponseBody ResponseEntity<?> findProfileById(@PathVariable("id") int id) throws CustomException{
		User profile = userService.showProfileDetails(id);
		if (profile == null) {
			return Response.error("User does not exist with this id");
		}
		return Response.success(profile);
	}

	// edit info
	@PutMapping("/update/{id}")
	public @ResponseBody ResponseEntity<?> updateUser(@PathVariable int id, @RequestBody User UserDetails)throws CustomException {
		User user = userService.updateUser(id, UserDetails);
		if (user == null) {
			return Response.error("User does not exist with this id");
		} else {
			return Response.success(user);
		}

	}

	// delete User rest api
	@DeleteMapping("/delete/{id}")
	public @ResponseBody ResponseEntity<?> deleteUser(@PathVariable int id)throws CustomException {
		User deletedUser = userService.deleteUser(id);
		if (deletedUser == null) {
			return Response.error("User not found");
		} else {
			return ResponseEntity.ok(deletedUser);
		}
	}

	// add Address
	@PostMapping("/address")
	public @ResponseBody ResponseEntity<?> addAddress(@RequestBody Address address) throws CustomException{
		System.out.println(address.getUser() + "  " + address.getAddressLine1());
		Address Result = userService.addAddress(address);
		if (Result == null) {
			return Response.error("Failure");
		} else
			return Response.success(Result);
	}

	// delete address
	@DeleteMapping("/deleteaddress/{id}")
	public @ResponseBody ResponseEntity<?> deleteAddress(@PathVariable int id)throws CustomException {
		Address deleteAddress = userService.deleteAddress(id);
		if (deleteAddress == null) {
			return Response.error("address not found");
		} else {
			return ResponseEntity.ok(deleteAddress);
		}
	}

	/*
	 * // get Address details byUserId
	 * 
	 * @GetMapping("/showAddresses/{id}") public @ResponseBody ResponseEntity<?>
	 * findAddressById(@PathVariable("id") int id) { List<Address> addresses =
	 * userService.findAddressByUserId(id);
	 * 
	 * 
	 * for (Address address : addresses) { System.out.println("address" +address); }
	 * 
	 * if (addresses != null) { return Response.success(addresses);
	 * 
	 * } return Response.error("Address does not exist with this Userid"); }
	 */
	// add wallet balance
	@PutMapping("/addWallet/{id}")
	public @ResponseBody ResponseEntity<?> updateWallet(@PathVariable int id, @RequestBody User UserDetailsmoney)throws CustomException {
		User user = userService.updateWallet(id, UserDetailsmoney);
		if (user == null) {
			return Response.error("User does not exist with this id");
		} else {
			return Response.success(user);
		}

	}

	// deduct wallet balance
	@PutMapping("/deductWallet/{id}")
	public @ResponseBody ResponseEntity<?> deductWallet(@PathVariable int id, @RequestBody User UserDetailsmoney) throws CustomException{
		User user = userService.deductWallet(id, UserDetailsmoney);
		if (user == null) {
			return Response.error("wallet balance is less than 0 ");
		}
		if (user == UserDetailsmoney) {
			return Response.error("User does not exist with this id ");
		} else {
			return Response.success(user);
		}

	}

	// change password

	@PutMapping("/changepass/{id}")
	public @ResponseBody ResponseEntity<?> changepass(@PathVariable int id, @RequestBody User userpass)throws CustomException {
		User user = userService.updatePass(id, userpass);
		if (user == null) {
			return Response.error("User does not exist with this id");
		} else {
			return Response.success(user);
		}

	}
	
	//Find all product addedin db by vendor
	@GetMapping("/product/{userid}")
	public @ResponseBody ResponseEntity<?> findproductaddedbyuserindb(@PathVariable("userid") int id)throws CustomException {
		List<Product> products = userService.showallproductaddedbyuser(id);
		if (products == null)
		{
			return Response.error("No product added by this vendor");
		}
		else {
			
		return Response.success(products);
	}
		}

}
