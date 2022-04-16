package com.netcom.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.netcom.entities.Address;

public interface AddressDao  extends JpaRepository<Address, Integer>  {

 Address findByAddressId(int id);
 @Modifying
 @Query(value = "delete from address where addressId = ?1",nativeQuery = true)
 void deleteByAddress(int id );
 
}
