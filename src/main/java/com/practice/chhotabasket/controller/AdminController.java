package com.practice.chhotabasket.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.text.SimpleDateFormat;
import com.practice.chhotabasket.pojo.*;
import com.practice.chhotabasket.services.*;
import com.practice.chhotabasket.response.*;
import com.practice.chhotabasket.model.*;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/admin")
public class AdminController
{
ResponseWrapper responseWrapper=null;

@Autowired
AdminService adminService;

@Autowired
ProductModel productModel;


@GetMapping("/getAllFruits")
public ResponseWrapper getAllFruits()
{
// abhi exception wala kaam nhi hua he
responseWrapper=new ResponseWrapper();
try{
responseWrapper.result=adminService.getAllFruitsList();
responseWrapper.hasResult=true;
return responseWrapper;
}catch(Exception exception)
{
responseWrapper.success=false;
responseWrapper.isException=true;
responseWrapper.exception=exception.toString();
return responseWrapper;
}
}

@PostMapping("/addStorage")	// not only for fruits
public ResponseWrapper addNewFruit(@RequestBody Storage storage)
{
responseWrapper= new ResponseWrapper();
storage.setTimeStamp(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()));
storage.setImgSrc(storage.getName()+".jpg");
try{
storage.setName(storage.getName().toLowerCase());
productModel.updateProductData(storage.getName());
if(storage.getType().equalsIgnoreCase("fruit"))
{
responseWrapper.result=adminService.addFruit(storage);
}
else if(storage.getType().equalsIgnoreCase("vegetable"))
{
responseWrapper.result=adminService.addVegetable(storage);
}
else if(storage.getType().equalsIgnoreCase("dairyproduct"))
{
responseWrapper.result=adminService.addDairyProduct(storage);
}

responseWrapper.hasResult=true;
return responseWrapper;
}catch(Exception exception)
{
responseWrapper.success=false;
responseWrapper.isException=true;
responseWrapper.exception=exception.toString();
return responseWrapper;
}
}

@PostMapping("/removeStorage")
public ResponseWrapper removeStorage(@RequestBody RemoveItem removeItem)
{
responseWrapper= new ResponseWrapper();
try
{
productModel.deleteProductData(removeItem.getDelName());
responseWrapper.result=adminService.removeStorage(removeItem);
responseWrapper.hasResult=true;
return responseWrapper;
}catch(Exception exception)
{
responseWrapper.success=false;
responseWrapper.isException=true;
responseWrapper.exception=exception.toString();
return responseWrapper;
}

}

@PostMapping("/removeFruit/{fruitId}")
public String removeFruit(@PathVariable("fruitId") String fruitId)
{
return adminService.removeFruit(fruitId);
}
//-------------------------^^^ Fruits ^^^---------------------------

@GetMapping("/getAllVegetables")
public ResponseWrapper getAllVegetables()
{
// abhi exception wala kaam nhi hua he
responseWrapper=new ResponseWrapper();
try{
responseWrapper.result=adminService.getAllVegetablesList();
responseWrapper.hasResult=true;
return responseWrapper;
}catch(Exception exception)
{
responseWrapper.success=false;
responseWrapper.isException=true;
responseWrapper.exception=exception.toString();
return responseWrapper;
}
}

@PostMapping("/addVegetable")
public ResponseWrapper addNewVegetable(@RequestBody Vegetable vegetable)
{
responseWrapper= new ResponseWrapper();
try{
//responseWrapper.result=adminService.addVegetable(vegetable);
responseWrapper.hasResult=true;
return responseWrapper;
}catch(Exception exception)
{
responseWrapper.success=false;
responseWrapper.isException=true;
responseWrapper.exception=exception.toString();
return responseWrapper;
}
}

@PostMapping("/removeVegetable/{vegetableId}")
public String removeVegetable(@PathVariable("vegetableId") String vegetableId)
{
return adminService.removeVegetable(vegetableId);
}
//-------------------------^^^ Vegetable ^^^---------------------------

@GetMapping("/getAllDairyProducts")
public ResponseWrapper getAllDairyProducts()
{
// abhi exception wala kaam nhi hua he
responseWrapper=new ResponseWrapper();
try{
responseWrapper.result=adminService.getAllDairyProductsList();
responseWrapper.hasResult=true;
return responseWrapper;
}catch(Exception exception)
{
responseWrapper.success=false;
responseWrapper.isException=true;
responseWrapper.exception=exception.toString();
return responseWrapper;
}
}

@PostMapping("/addDairyProduct")
public ResponseWrapper addNewDairyProduct(@RequestBody DairyProduct dairyProduct)
{
responseWrapper= new ResponseWrapper();
try{
//responseWrapper.result=adminService.addDairyProduct(dairyProduct);
responseWrapper.hasResult=true;
return responseWrapper;
}catch(Exception exception)
{
responseWrapper.success=false;
responseWrapper.isException=true;
responseWrapper.exception=exception.toString();
return responseWrapper;
}
}

@PostMapping("/removeDairyProduct/{dairyProductId}")
public String removeDairyProduct(@PathVariable("dairyProductId") String dairyProductId)
{
return adminService.removeVegetable(dairyProductId);
}
//-------------------------^^^ DairyProducts ^^^---------------------------

@GetMapping("/getAllSells")
public ResponseWrapper getAllSells()
{
// abhi exception wala kaam nhi hua he
responseWrapper=new ResponseWrapper();
try{
responseWrapper.result=adminService.getAllSellsList();
responseWrapper.hasResult=true;
return responseWrapper;
}catch(Exception exception)
{
responseWrapper.success=false;
responseWrapper.isException=true;
responseWrapper.exception=exception.toString();
return responseWrapper;
}
}

@PostMapping("/addSells")
public ResponseWrapper addNewSells(@RequestBody Sells sells)
{
responseWrapper= new ResponseWrapper();
try{
responseWrapper.result=adminService.addSells(sells);
responseWrapper.hasResult=true;
return responseWrapper;
}catch(Exception exception)
{
responseWrapper.success=false;
responseWrapper.isException=true;
responseWrapper.exception=exception.toString();
return responseWrapper;
}
}

@PostMapping("/removeSells/{sellsId}")
public String removeSells(@PathVariable("sellsId") String sellsId)
{
return adminService.removeSells(sellsId);
}
//-------------------------^^^ Sells ^^^---------------------------

@GetMapping("/getAllStorage")
public ResponseWrapper getAllStorage()
{
// abhi exception wala kaam nhi hua he
System.out.println("Get all Storage chala");
responseWrapper=new ResponseWrapper();
try{
responseWrapper.result=adminService.getAllStorageList();
responseWrapper.hasResult=true;
return responseWrapper;
}catch(Exception exception)
{
responseWrapper.success=false;
responseWrapper.isException=true;
responseWrapper.exception=exception.toString();
return responseWrapper;
}
}

/*@PostMapping("/addStorage")
public ResponseWrapper addNewStorage(@RequestBody Storage storage)
{
responseWrapper= new ResponseWrapper();
try{
responseWrapper.result=adminService.addStorage(storage);
responseWrapper.hasResult=true;
return responseWrapper;
}catch(Exception exception)
{
responseWrapper.success=false;
responseWrapper.isException=true;
responseWrapper.exception=exception.toString();
return responseWrapper;
}
}
*/


/*@PostMapping("/removeStorage/{storageId}")
public String removeStorage2(@PathVariable("storageId") String storageId)
{
return adminService.removeStorage(storageId);
}*/
//-------------------------^^^ Storage ^^^---------------------------

@GetMapping("/getAllAdmin")
public ResponseWrapper getAllAdmin()
{
// abhi exception wala kaam nhi hua he
responseWrapper=new ResponseWrapper();
try{
responseWrapper.result=adminService.getAllAdminList();
responseWrapper.hasResult=true;
return responseWrapper;
}catch(Exception exception)
{
responseWrapper.success=false;
responseWrapper.isException=true;
responseWrapper.exception=exception.toString();
return responseWrapper;
}
}

@PostMapping("/addAdmin")
public ResponseWrapper addNewAdmin(@RequestBody Admin admin)
{
responseWrapper= new ResponseWrapper();
try{
responseWrapper.result=adminService.addAdmin(admin);
responseWrapper.hasResult=true;
return responseWrapper;
}catch(Exception exception)
{
responseWrapper.success=false;
responseWrapper.isException=true;
responseWrapper.exception=exception.toString();
return responseWrapper;
}
}

@PostMapping("/removeAdmin/{adminId}")
public String removeAdmin(@PathVariable("adminId") String adminId)
{
return adminService.removeAdmin(adminId);
}
//-------------------------^^^ Admin ^^^---------------------------

@PostMapping("/login")
public ResponseWrapper login(@RequestBody User user)
{
System.out.println("admin login chala"+user.getUserId()+" "+user.getUserPassword());
responseWrapper= new ResponseWrapper();
try{

responseWrapper.result=adminService.login(user);
if(responseWrapper.result==null)
{
responseWrapper.success=false;
responseWrapper.hasResult=false;
}
else
{
responseWrapper.hasResult=true;
}
return responseWrapper;
}catch(Exception exception)
{
responseWrapper.success=false;
responseWrapper.isException=true;
responseWrapper.exception=exception.toString();
return responseWrapper;
}
}
//---------------------^^^ login ^^^---------------------------
@PostMapping("/addProduct")
public ResponseWrapper addNewProduct(@RequestBody Product product)
{
responseWrapper= new ResponseWrapper();
try{
//responseWrapper.result=adminService.addFruit(fruit);
//responseWrapper.hasResult=true;
System.out.println(product.getName());
return responseWrapper;
}catch(Exception exception)
{
responseWrapper.success=false;
responseWrapper.isException=true;
responseWrapper.exception=exception.toString();
return responseWrapper;
}
}


}	// End of class 