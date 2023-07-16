package com.practice.chhotabasket.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.practice.chhotabasket.pojo.Storage;

@Repository
public interface StorageRepository extends MongoRepository<Storage,String>
{
Storage findByName(String name);
}