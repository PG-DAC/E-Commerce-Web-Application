package com.netcom.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcom.daos.ProductDao;
import com.netcom.daos.UserDao;
import com.netcom.daos.VendorDao;
import com.netcom.entities.Product;
import com.netcom.entities.User;
import com.netcom.entities.Vendor;
import com.netcom.exceptions.CustomException;

@Transactional
@Service
public class VendorServiceImpl {

	@Autowired
	private VendorDao vendorDao;



	@Autowired
	private UserDao userDao;

	public Vendor addVendorshop(Vendor vendor) {
		try {
			int userid = vendor.getUser().getUserId();
			User user = userDao.findByUserId(userid);
			if (user == null) {
				throw new CustomException("User not found !");
			} else {
				if (user.getRole().contentEquals("Vendor")) {
					Vendor savedVendordetails = vendorDao.save(vendor);
					return savedVendordetails;
				} else {
					throw new CustomException("You're not vendor , only vendor can add !");
				}
			}
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}

	}
	}
