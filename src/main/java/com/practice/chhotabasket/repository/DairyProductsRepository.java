package com.practice.chhotabasket.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.practice.chhotabasket.pojo.DairyProduct;

@Repository
public interface DairyProductsRepository extends MongoRepository<DairyProduct,String>
{

}