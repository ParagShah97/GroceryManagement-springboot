package com.practice.chhotabasket.pojo;

import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;


public class CartDocument implements java.io.Serializable
{
@Id
private String cartId;
//private String userId;
private String type;
private String productName;
private String productQuantity;
private String productCost;
private String totalCost;
private String productId;

public CartDocument()
{}

public CartDocument(String cartId,String type,String productName,String productQuantity,String productCost,String totalCost,String productId)
{
  this.cartId=cartId;
  //this.userId=userId;
  this.type=type;
  this.productName=productName;
  this.productQuantity=productQuantity;
  this.productCost=productCost;
  this.totalCost=totalCost;
  this.productId=productId;
}

public void setCartId(String cartId)
{
this.cartId = cartId;
}
public String getCartId()
{
return this.cartId;
}
/*public void setUserId(String userId)
{
this.userId = userId;
}
public String getUserId()
{
return this.userId;
}*/
public void setType(String type)
{
this.type = type;
}
public String getType()
{
return this.type;
}
public void setProductName(String productName)
{
this.productName = productName;
}
public String getProductName()
{
return this.productName;
}
public void setProductQuantity(String productQuantity)
{
this.productQuantity = productQuantity;
}
public String getProductQuantity()
{
return this.productQuantity;
}
public void setProductCost(String productCost)
{
this.productCost = productCost;
}
public String getProductCost()
{
return this.productCost;
}
public void setTotalCost(String totalCost)
{
this.totalCost = totalCost;
}
public String getTotalCost()
{
return this.totalCost;
}
public void setProductId(String productId)
{
this.productId = productId;
}
public String getProductId()
{
return this.productId;
}


}