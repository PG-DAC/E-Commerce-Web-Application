package com.netcom.daos;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.netcom.entities.Cart;
import com.netcom.entities.Order;
import com.netcom.entities.User;

public interface OrderDao extends JpaRepository<Order, Integer>{

	
	List<Order>findAllByUserOrderByCreatedDateDesc(User user);

	
    
	@Modifying
	@Query(value ="Insert into orders select * from cart where userId = ?1", nativeQuery = true)
	 int addToOrder(int id);


	@Query(value ="select * from orders where userId = ?1", nativeQuery = true)
	List<Order> findByUserId(int userid);
}
