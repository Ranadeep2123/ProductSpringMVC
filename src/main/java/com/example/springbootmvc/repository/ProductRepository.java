package com.example.springbootmvc.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springbootmvc.entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long>{
	

}
