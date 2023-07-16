package com.practice.chhotabasket.pojo;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection="dairyProductsData")
public class DairyProduct implements java.io.Serializable
{

@Id
private String id;
private String name;
private String category;
private String quantity;
private String scale;
private double cost;
private String imgSrc;

public DairyProduct(){}

public DairyProduct(String id,String name,String category,String quantity,String scale,double cost,String imgSrc)
{
this.id=id;
this.name=name;
this.category=category;
this.quantity=quantity;
this.scale=scale;
this.cost=cost;
this.imgSrc=imgSrc;
}

public void setId(String id)
{
this.id = id;
}
public String getId()
{
return this.id;
}
public void setName(String name)
{
this.name = name;
}
public String getName()
{
return this.name;
}
public void setCategory(String category)
{
this.category = category;
}
public String getCategory()
{
return this.category;
}
public void setQuantity(String quantity)
{
this.quantity = quantity;
}
public String getQuantity()
{
return this.quantity;
}
public void setScale(String scale)
{
this.scale = scale;
}
public String getScale()
{
return this.scale;
}
public void setCost(double cost)
{
this.cost = cost;
}
public double getCost()
{
return this.cost;
}
public void setImgSrc(String imgSrc)
{
this.imgSrc = imgSrc;
}
public String getImgSrc()
{
return this.imgSrc;
}
}