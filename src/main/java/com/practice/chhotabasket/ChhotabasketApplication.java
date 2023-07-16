package com.practice.chhotabasket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;
import com.practice.chhotabasket.model.*;
import com.practice.chhotabasket.repository.StorageRepository;
import com.practice.chhotabasket.pojo.Storage;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
//import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class ChhotabasketApplication {

	public static void main(String[] args) {
System.out.println("Run ke pehele me likha he");		
SpringApplication.run(ChhotabasketApplication.class, args);
		System.out.println("Run ke baad me likha he");
	}


@Autowired
StorageRepository storageRepository;


@Bean
public ProductModel getProductModel()
{
List<String> productName= new LinkedList<>();
List<Storage> storageList=new LinkedList<>();
storageList=storageRepository.findAll();
storageList.forEach((storage)->{
productName.add(storage.getName());
});
ProductModel productModel=new ProductModel();
productModel.setProductData(productName);
//System.out.println(" ** God is Great **"+productModel.getProductData().get(2));
return productModel;
}

}
