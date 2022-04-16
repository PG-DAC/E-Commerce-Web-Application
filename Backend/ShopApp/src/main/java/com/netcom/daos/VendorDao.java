package com.netcom.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.netcom.entities.Product;
import com.netcom.entities.Vendor;

public interface VendorDao extends JpaRepository<Vendor, Integer>{

	

	//Vendor save(Product product);

}
