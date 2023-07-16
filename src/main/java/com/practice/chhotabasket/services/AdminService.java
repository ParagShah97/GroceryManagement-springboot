package com.practice.chhotabasket.services;

import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Criteria;

import com.practice.chhotabasket.pojo.*;
import com.practice.chhotabasket.repository.*;
import java.util.*;
@Service
public class AdminService
{

@Autowired
MongoTemplate mongoTemplate;

@Autowired
FruitsRepository fruitsRepository;

@Autowired
VegetablesRepository vegetablesRepository;

@Autowired
DairyProductsRepository dairyProductsRepository;

@Autowired
SellsRepository sellsRepository;

@Autowired
StorageRepository storageRepository;

@Autowired
AdminRepository adminRepository;


@Autowired
IdCounterRepository idCounterRepository;

public List<Fruit> getAllFruitsList()
{
//System.out.println("************"+fruitsRepository.findAll()+"  ***  "+fruitsRepository.findAll().getClass().getName());
List<Fruit> l=fruitsRepository.findAll();
return fruitsRepository.findAll();

}

public String addFruit(Storage storage)
{
List<IdCounter> l=idCounterRepository.findAll();
String oldId=l.get(0).getLastId();
int i=Integer.parseInt(oldId.substring(1));
i++;
String newId="f"+(String.valueOf(i));
System.out.println(oldId+"  "+newId);
storage.setId(newId);
Fruit fruit=new Fruit(newId,storage.getName(),storage.getCategory(),storage.getQuantity(),storage.getScale(),storage.getProductCost(),storage.getImgSrc());
l.get(0).setLastId(newId);
idCounterRepository.save(l.get(0));
storageRepository.save(storage);
fruitsRepository.save(fruit);
return "Fruit added successfully";
}

public String removeFruit(String fruitId)
{
return "fruit removed";
}
//-------------------------^^^ Fruits ^^^---------------------------

public List<Vegetable> getAllVegetablesList()
{
//System.out.println("************"+vegetablesRepository.findAll()+"  ***  "+vegetablesRepository.findAll().getClass().getName());
List<Vegetable> l=vegetablesRepository.findAll();
return vegetablesRepository.findAll();

}

public String addVegetable(Storage storage)
{
List<IdCounter> l=idCounterRepository.findAll();
String oldId=l.get(1).getLastId();
int i=Integer.parseInt(oldId.substring(1));
i++;
String newId="v"+(String.valueOf(i));
System.out.println(oldId+"  "+newId);
storage.setId(newId);
Vegetable vegetable=new Vegetable(newId,storage.getName(),storage.getCategory(),storage.getQuantity(),storage.getScale(),storage.getProductCost(),storage.getImgSrc());
l.get(1).setLastId(newId);
idCounterRepository.save(l.get(1));
storageRepository.save(storage);
vegetablesRepository.save(vegetable);
return "Vegetable added successfully";
}

public String removeVegetable(String vegetableId)
{
return "vegetable removed";
}
//-------------------------^^^ Vegetable ^^^---------------------------

public List<DairyProduct> getAllDairyProductsList()
{
//System.out.println("************"+dairyProductsRepository.findAll()+"  ***  "+dairyProductsRepository.findAll().getClass().getName());
List<DairyProduct> l=dairyProductsRepository.findAll();
return dairyProductsRepository.findAll();

}

public String addDairyProduct(Storage storage)
{
List<IdCounter> l=idCounterRepository.findAll();
String oldId=l.get(2).getLastId();
int i=Integer.parseInt(oldId.substring(1));
i++;
String newId="d"+(String.valueOf(i));
System.out.println(oldId+"  "+newId);
storage.setId(newId);
DairyProduct dairyProduct=new DairyProduct(newId,storage.getName(),storage.getCategory(),storage.getQuantity(),storage.getScale(),storage.getProductCost(),storage.getImgSrc());
l.get(2).setLastId(newId);
idCounterRepository.save(l.get(2));
storageRepository.save(storage);
dairyProductsRepository.save(dairyProduct);
return "DairyProduct added successfully";
}

public String removeDairyProduct(String dairyProductId)
{
return "DairyProduct removed";
}
//-------------------------^^^ DairyProducts ^^^---------------------------
// Testing not done yet
public List<Sells> getAllSellsList()
{
//System.out.println("************"+fruitsRepository.findAll()+"  ***  "+fruitsRepository.findAll().getClass().getName());
List<Sells> l=sellsRepository.findAll();
return sellsRepository.findAll();

}

public String addSells(Sells sells)
{
sellsRepository.save(sells);
return "Sells added successfully";
}

public String removeSells(String sellsId)
{
return "Sells removed";
}
//-------------------------^^^ Sells ^^^---------------------------

public List<Storage> getAllStorageList()
{
//System.out.println("************"+fruitsRepository.findAll()+"  ***  "+fruitsRepository.findAll().getClass().getName());
//List<Storage> l=storageRepository.findAll();
return storageRepository.findAll();

}

public String addStorage(Storage storage)
{
storageRepository.save(storage);
return "Storage added successfully";
}

public Storage removeStorage(RemoveItem removeItem)
{
System.out.println("*********** "+removeItem.getDelName()+" "+removeItem.getDelType());
//Query query=new Query(Criteria.where("name").is(removeItem.getDelName().toLowerCase()));
Query query= new Query();
query.addCriteria(new Criteria().andOperator(Criteria.where("name").is(removeItem.getDelName().toLowerCase()),Criteria.where("type").is(removeItem.getDelType())));
return mongoTemplate.findAndRemove(query,Storage.class,"storageData");
}
//-------------------------^^^ Storage ^^^---------------------------
public List<Admin> getAllAdminList()
{
//System.out.println("************"+adminRepository.findAll()+"  ***  "+adminRepository.findAll().getClass().getName());
//List<Admin> l=adminRepository.findAll();
return adminRepository.findAll();

}

public String addAdmin(Admin admin)
{
adminRepository.save(admin);
return "Admin added successfully";
}

public String removeAdmin(String adminId)
{
return "Admin removed";
}
//-------------------------^^^ Admin ^^^---------------------------
public User login(User user)
{
List<Admin> ll= adminRepository.findAll();
Admin admin=ll.get(0);
if(admin.getId().equals(user.getUserId()) && admin.getPassword().equals(user.getUserPassword()))
{
System.out.println("Server side login me credential sahi he");
return user;
}
else
{
System.out.println("Server side login me credential galat he"+user.getUserId()+" "+user.getUserPassword());
return null;
}
}


}