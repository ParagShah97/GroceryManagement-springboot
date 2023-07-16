package com.practice.chhotabasket.pojo;

public class SellsProduct implements java.io.Serializable
{
private String productId;
private String productName;
private String productCost;
private String productQuantity;


public SellsProduct(String productId,String productName,String productCost,String productQuantity)
{
this.productId=productId;
this.productName=productName;
this.productCost=productCost;
this.productQuantity=productQuantity;
}

public void setProductId(String productId)
{
this.productId = productId;
}
public String getProductId()
{
return this.productId;
}
public void setProductName(String productName)
{
this.productName = productName;
}
public String getProductName()
{
return this.productName;
}
public void setProductCost(String productCost)
{
this.productCost = productCost;
}
public String getProductCost()
{
return this.productCost;
}
public void setProductQuantity(String productQuantity)
{
this.productQuantity = productQuantity;
}
public String getProductQuantity()
{
return this.productQuantity;
}

}
