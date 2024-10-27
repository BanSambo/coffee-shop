package com.coffee.shop.repos;

import com.coffee.shop.entities.Booked;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookedRepo extends JpaRepository<Booked,Integer> {

}


