package com.practice.chhotabasket.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.practice.chhotabasket.pojo.*;

@Repository
public interface ClientsRepository extends MongoRepository<Client,String>
{

}