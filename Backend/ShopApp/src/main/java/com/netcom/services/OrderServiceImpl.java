package com.netcom.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.netcom.daos.CartDao;
import com.netcom.daos.OrderDao;
import com.netcom.daos.UserDao;
import com.netcom.dtos.AddToCartDto;
import com.netcom.dtos.CartDto;
import com.netcom.dtos.CartItemsDto;
import com.netcom.dtos.OrderDto;
import com.netcom.dtos.OrderItemsDto;
import com.netcom.entities.Cart;
import com.netcom.entities.Order;
import com.netcom.entities.Product;
import com.netcom.entities.User;
import com.netcom.exceptions.CustomException;

@Transactional
@Service
public class OrderServiceImpl {

	@Autowired
	private ProductServiceImpl productServiceImpl;
	
	@Autowired
	private CartDao cartDao; 
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private UserDao userDao;
	
	//on clicking Confirm order
	public int addtoorder(int id) {
		
		int i = orderDao.addToOrder(id);
		if(i == 0)
		{
			return i;
		}
		return i;
		
		
		
		
	}



	public List<Order> listOrderItems(User user) {
	int userid  = user.getUserId();
		List<Order> orders = orderDao.findByUserId(userid);
		if(orders.isEmpty())
		{
			return null;
		}
		return orders;
		
	}
	/*List<Order> orders	=  orderDao.findAllByUserOrderByCreatedDateDesc(user);
	if(orders.isEmpty())
	{
		return null;
	}
	return orders;
	
	}
*/

	


	

	//on click of get order details
	
	
	
	
	
	










	

}
