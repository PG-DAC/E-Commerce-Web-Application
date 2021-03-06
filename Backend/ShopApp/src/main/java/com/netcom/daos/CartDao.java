package com.netcom.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.netcom.entities.Cart;
import com.netcom.entities.User;

public interface CartDao extends JpaRepository<Cart, Integer>{

	
	List<Cart>findAllByUserOrderByCreatedDateDesc(User user);

	@Query(value = "select * from cart where userId = ?1",nativeQuery = true)
	List<Cart>findCartByuserId(int userid);
	
	
}
