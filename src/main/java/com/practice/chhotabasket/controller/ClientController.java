package com.practice.chhotabasket.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.beans.factory.annotation.Autowired;

import com.mongodb.MongoClient; 
import com.mongodb.client.MongoDatabase; 
import com.mongodb.BasicDBObject;
import org.bson.Document;
import com.mongodb.client.MongoCollection;


import com.mongodb.DBCollection;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.google.gson.*;

import org.springframework.data.mongodb.core.MongoTemplate;


import java.util.*;
import com.practice.chhotabasket.pojo.*;
import com.practice.chhotabasket.services.*;
import com.practice.chhotabasket.response.*;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/client")
public class ClientController
{
ResponseWrapper responseWrapper=null;

@Autowired
ClientService clientService;

@Autowired
MongoTemplate mongoTemplate;

@Autowired
EmailMessanger emailMessanger;


@GetMapping("/getSearchProductList")
public ResponseWrapper getSearchProductList()
{
responseWrapper = new ResponseWrapper();
System.out.println("getSearchProductList**********************");
try{
responseWrapper.result=clientService.getSearchProductList();
responseWrapper.hasResult=true;
return responseWrapper;
}catch(Exception exception)
{
responseWrapper.success=false;
responseWrapper.isException=true;
responseWrapper.exception=exception.getMessage();
return responseWrapper;
}


}


@GetMapping("/getClient/{userId}")
public ResponseWrapper getClient(@PathVariable String userId)
{
responseWrapper = new ResponseWrapper();
try{
responseWrapper.result=clientService.getClient(userId);
responseWrapper.hasResult=true;
return responseWrapper;
}catch(Exception exception)
{
responseWrapper.success=false;
responseWrapper.isException=true;
responseWrapper.exception=exception.getMessage();
return responseWrapper;
}

}

@PostMapping("/addClient")
public ResponseWrapper addClient(@RequestBody Client client)
{
responseWrapper= new ResponseWrapper();
try{
responseWrapper.result=clientService.addClient(client);
responseWrapper.hasResult=true;
String temp=client.getEmailId();
String collName=temp.split("@")[0]+temp.split("@")[1].split("\\.")[0];
System.out.println("****************"+collName);

// create collection
//MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
//MongoDatabase database = mongoClient.getDatabase("GroceryDatabase");
//database.createCollection(collName);
//MongoCollection<Document> collection = database.getCollection(collName);
//System.out.println(collection);

mongoTemplate.createCollection(collName);


return responseWrapper;
}catch(Exception exception)
{
responseWrapper.success=false;
responseWrapper.isException=true;
responseWrapper.exception=exception.toString();
return responseWrapper;
}
}


@PostMapping("/login")
public ResponseWrapper login(@RequestBody User user)
{
responseWrapper= new ResponseWrapper();
try{
System.out.println("login Controller chala");
System.out.println(user.getUserPassword());
Client client=clientService.login(user);
responseWrapper.result=client;
if(client==null)
{
responseWrapper.success=false;
responseWrapper.hasResult=false;
responseWrapper.isError=true;
responseWrapper.error="Invalid user Id. Failed to login";
}
else
{
String pass=client.getPassword();
if(!pass.equals(user.getUserPassword()))
{
responseWrapper.success=false;
responseWrapper.hasResult=false;
responseWrapper.isError=true;
responseWrapper.error="Invalid Password. Failed to login";
}
else{
System.out.println("sab thik he");
responseWrapper.hasResult=true;
}
}
return responseWrapper;
}catch(Exception exception)
{
responseWrapper.success=false;
responseWrapper.isException=true;
responseWrapper.hasResult=false;
responseWrapper.isError=true;
responseWrapper.error="Invalid user Id. Failed to login";
responseWrapper.exception=exception.toString();
return responseWrapper;
}
}

@PostMapping("/addToCart/{userId}")
public ResponseWrapper addToCart(@PathVariable String userId,@RequestBody CartDocument cartDocument)
{
responseWrapper= new ResponseWrapper();
try
{
responseWrapper.result=clientService.addToCart(userId,cartDocument);
return responseWrapper;
}catch(Exception exception)
{
responseWrapper.success=false;
responseWrapper.isException=true;
responseWrapper.hasResult=false;
responseWrapper.exception=exception.toString();
return responseWrapper;
}
}

@GetMapping("/getCartDetails/{userId}")
public ResponseWrapper getCartDetails(@PathVariable String userId)
{
responseWrapper= new ResponseWrapper();
try
{
responseWrapper.result=clientService.getCartDetails(userId);
return responseWrapper;
}catch(Exception exception)
{
responseWrapper.success=false;
responseWrapper.isException=true;
responseWrapper.hasResult=false;
responseWrapper.exception=exception.toString();
return responseWrapper;
}
}


@PostMapping("/cartPurchase/{userId}")
public ResponseWrapper cartPurchase(@PathVariable String userId)
{
responseWrapper= new ResponseWrapper();
try{
/*MongoClient mongo = new MongoClient( "localhost" , 27017 );
MongoDatabase database = mongo.getDatabase("GroceryDatabase");
MongoCollection<Document> collection = database.getCollection(sells.get_id().split("@")[0]);	
Gson gson = new Gson();
String json = gson.toJson(sells);
Document document = Document.parse(json);
collection.insertOne(document);
*/
responseWrapper.result=clientService.cartPurchase(userId);
return responseWrapper;
}catch(Exception exception)
{
responseWrapper.success=false;
responseWrapper.isException=true;
responseWrapper.exception=exception.getMessage();
return responseWrapper;
}
}


@GetMapping("/removeFromCart/{userId}/{cartProduct}")
public ResponseWrapper removeFromCart(@PathVariable("userId") String userId,@PathVariable("cartProduct") String cartProduct)
{
responseWrapper= new ResponseWrapper();
try
{
System.out.println("**************************"+userId+cartProduct);
responseWrapper.result=clientService.removeFromCart(userId,cartProduct);
responseWrapper.hasResult=true;
return responseWrapper;
}catch(Exception exception)
{
responseWrapper.success=false;
responseWrapper.isException=true;
responseWrapper.exception=exception.getMessage();
return responseWrapper;
}
}

@GetMapping("/search/{productName}")
public ResponseWrapper search(@PathVariable String productName)
{
responseWrapper= new ResponseWrapper();
try{
responseWrapper.result=clientService.search(productName.toLowerCase());
responseWrapper.hasResult=true;
return responseWrapper;
}catch(Exception exception)
{
responseWrapper.success=false;
responseWrapper.isException=true;
responseWrapper.exception=exception.getMessage();
return responseWrapper;
}
}

@GetMapping("/forgotPassword/{userId}")
public ResponseWrapper forgotPassword(@PathVariable String userId)
{
responseWrapper= new ResponseWrapper();
try{
Client client =clientService.forgotPassword(userId);
responseWrapper.result=client;
if(responseWrapper.result==null)
{
responseWrapper.success=false;
responseWrapper.isError=true;
responseWrapper.error="Please check your email id. We failed to find your mail id";
return responseWrapper;
}
responseWrapper.hasResult=true;
// backhere
String to=userId;
String subject="One time Password For re-configuring your Password";
String text="**Mr.Coder'S Grocery**\nYour one time password (OTP) is : "+client.getOtp()+"\nYour OTP is valid for 1hr only.\nCongratulations you can now create new Password. \n\nIf this wasn't you please reach us.\n\n\n\n This is the system generated mail please don't reply.\nThank you";
emailMessanger.sendSimpleMessage(to,subject,text);
return responseWrapper;
}catch(Exception exception)
{
responseWrapper.success=false;
responseWrapper.isException=true;
responseWrapper.exception=exception.getMessage();
return responseWrapper;
}
}

@PostMapping("/resetPassword/{userId}")
public ResponseWrapper resetPasssword(@PathVariable("userId") String userId,@RequestBody ResetPasswordObject resetPasswordObject)
{
responseWrapper= new ResponseWrapper();
try{
responseWrapper.result=clientService.resetPasssword(userId,resetPasswordObject);
responseWrapper.hasResult=true;
return responseWrapper;
}catch(Exception exception)
{
responseWrapper.success=false;
responseWrapper.isException=true;
responseWrapper.exception=exception.getMessage();
return responseWrapper;
}
}

@GetMapping("/getBannerData")
public ResponseWrapper getBannerData()
{
responseWrapper= new ResponseWrapper();
try{
responseWrapper.result=clientService.getBannerData();
responseWrapper.hasResult=true;
return responseWrapper;
}catch(Exception exception)
{
responseWrapper.success=false;
responseWrapper.isException=true;
responseWrapper.exception=exception.getMessage();
return responseWrapper;
}
}

}	// end of class 
