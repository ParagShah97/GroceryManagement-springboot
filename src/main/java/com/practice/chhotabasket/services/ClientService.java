package com.practice.chhotabasket.services;

import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Criteria;

import com.practice.chhotabasket.pojo.*;
import com.practice.chhotabasket.repository.*;
import com.practice.chhotabasket.response.*;
import com.practice.chhotabasket.model.*;

import java.util.*;
//import java.time.LocalDateTime;
import java.text.SimpleDateFormat;

@Service
public class ClientService
{
@Autowired
EmailMessanger emailMessanger;

@Autowired
ProductModel productModel;

@Autowired
MongoTemplate mongoTemplate;

@Autowired
ClientsRepository clientsRepository;

@Autowired
StorageRepository storageRepository;

@Autowired
IdCounterRepository idCounterRepository;


public List<String> getSearchProductList()
{
return productModel.getProductData();
}

public String addClient(Client client)
{
System.out.println(clientsRepository.save(client));
return "Client added successfully";
}

public Client getClient(String userId)
{
Client client=clientsRepository.findById(userId).orElse(null);
client.setPassword("");
return client;
}

public Client login(User user)
{
Client client=clientsRepository.findById(user.getUserId()).orElse(null);	// remember it.
//System.out.println(client.getPassword());
return client;
}

public String addToCart(String userId,CartDocument cartDocument)
{
double i=cartDocument.hashCode()*(Math.random()*97);
cartDocument.setCartId(String.valueOf(i));
//String temp=cartDocument.getUserId();
mongoTemplate.save(cartDocument,userId.split("@")[0]+userId.split("@")[1].split("\\.")[0]);
return "Product Added Successfully";
}

public List<CartDocument> getCartDetails(String userId)
{
//String temp="pappu.kumar2000@gmail.com";
Query query= new Query(Criteria.where("type").is("cart"));
return mongoTemplate.find(query,CartDocument.class,userId.split("@")[0]+userId.split("@")[1].split("\\.")[0]);

}

public Sells cartPurchase(String userId)
{
double totalCost=0;
String collectionName=userId.split("@")[0]+userId.split("@")[1].split("\\.")[0];
List<CartDocument> cartDocumentList=getCartDetails(userId);
List<SellsProduct> sellsProductList=new ArrayList<>();
Storage storageTemp;
for(CartDocument c:cartDocumentList)
{
sellsProductList.add(new SellsProduct(c.getProductId(),c.getProductName(),c.getProductCost(),c.getProductQuantity()));
totalCost+=Double.parseDouble(c.getTotalCost());
storageTemp=storageRepository.findById(c.getProductId()).orElse(null);
storageTemp.setTotalQuantity(storageTemp.getTotalQuantity()-(Double.parseDouble(storageTemp.getQuantity())*Double.parseDouble(c.getProductQuantity())));
storageRepository.save(storageTemp);
}
Sells sells= new Sells();
sells.setEmailId(userId);
sells.setTotalCost(totalCost);
sells.setSellsProduct(sellsProductList);
sells.setTimeStamp(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()));
List<IdCounter> l=idCounterRepository.findAll();
String oldId=l.get(3).getLastId();
int i=Integer.parseInt(oldId.substring(1));
i++;
String newId="s"+(String.valueOf(i));
System.out.println(oldId+"  "+newId);
sells.setId(newId);
l.get(3).setLastId(newId);
idCounterRepository.save(l.get(3));
String temp=sells.getEmailId();
System.out.println("**************"+temp.split("@")[0]+temp.split("@")[1].split("\\.")[0]);
CartSellsDocument cart=new CartSellsDocument(newId,"sells");
mongoTemplate.save(cart,temp.split("@")[0]+temp.split("@")[1].split("\\.")[0]);
mongoTemplate.save(sells,"sellsData");
Query query=new Query(Criteria.where("type").is("cart"));
mongoTemplate.remove(query,collectionName);
// storage data to be modified.
return sells;
}

// not done yet.
public Storage removeFromCart(String userId,String cartProduct)
{
Query query= new Query();
query.addCriteria(Criteria.where("productName").is(cartProduct));
return mongoTemplate.findAndRemove(query,Storage.class,userId.split("@")[0]+userId.split("@")[1].split("\\.")[0]);
}

public Storage search(String productName)
{
/*try{
emailMessanger.sendMessageWithAttachment();
}catch(Exception e)
{
System.out.println("******* bla bla "+e.getMessage());
}*/


System.out.println(productName+" searched ***");
List<String> l=productModel.getProductData();
for(String s:l){
if(s.contains(productName))
{
return storageRepository.findByName(s);
}
}
return null;
}

public Client forgotPassword(String userId)
{
String s= String.valueOf(UUID.randomUUID()).substring(0,6);
Client client=clientsRepository.findById(userId).orElse(null);
if(client==null) return null;
client.setOtp(s);
return client;
}

public ResetPasswordObject resetPasssword(String userId,ResetPasswordObject resetPasswordObject)
{
System.out.println(userId);
Client client=clientsRepository.findById(userId).orElse(null);
if(!client.getOtp().equalsIgnoreCase(resetPasswordObject.getOtp()))
{
// start here
}
return resetPasswordObject;
}

public List<Storage> getBannerData()
{
List<Storage> banner=storageRepository.findAll();
List<Storage> returnBannerList=new ArrayList<>();
int fruit=0;
int dairyProduct=0;
int vegetable=0;

Collections.shuffle(banner);
for(Storage sto:banner)
{
if(fruit<4 && sto.getType().equals("fruit")) 
{
returnBannerList.add(sto);
fruit++;
}
if(dairyProduct<4 && sto.getType().equals("dairyProduct")) 
{
returnBannerList.add(sto);
dairyProduct++;
}
if(vegetable<4 && sto.getType().equals("vegetable")) 
{
returnBannerList.add(sto);
vegetable++;
}
if(fruit==4 && dairyProduct==4 && vegetable==4)
{
break;
}
}
return returnBannerList;
}


}
