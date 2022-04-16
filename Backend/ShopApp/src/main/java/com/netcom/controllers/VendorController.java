package com.netcom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.netcom.dtos.Response;
import com.netcom.entities.Vendor;
import com.netcom.services.VendorServiceImpl;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/vendor")
public class VendorController {

		@Autowired
		private VendorServiceImpl vendorService;
			
		@PostMapping("/add")
		public @ResponseBody ResponseEntity<?> addVendorshopdetails(@RequestBody Vendor vendor)
		{
			Vendor result = vendorService.addVendorshop(vendor);
			if(result == null)
			{
		   return Response.error("only Vendor can add his shop details else userId not found");
			}else {
				return Response.success(result);
		}
		
		}
		
		
}
