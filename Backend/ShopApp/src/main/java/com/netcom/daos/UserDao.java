package com.netcom.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.netcom.entities.User;

public interface UserDao extends JpaRepository<User, Integer> 
{
  User findByEmail(String email);
  User findByUserId(int id);
  

  
  
  
  
  
  
  
	  
	  //select u.email,u.lastname,a.city from user u inner join address a on u.userId = a.userId where u.userId = ?1
  
}
