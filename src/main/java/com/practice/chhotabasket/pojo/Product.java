package com.practice.chhotabasket.pojo;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

public class Product implements java.io.Serializable
{
private String id;
private String name;
private String category;
private String type;
private String quantity;
private String cost;
private String totalCost;
private String totalQuantity;

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
public void setType(String type)
{
this.type = type;
}
public String getType()
{
return this.type;
}
public void setQuantity(String quantity)
{
this.quantity = quantity;
}
public String getQuantity()
{
return this.quantity;
}
public void setCost(String cost)
{
this.cost = cost;
}
public String getCost()
{
return this.cost;
}
public void setTotalCost(String totalCost)
{
this.totalCost = totalCost;
}
public String getTotalCost()
{
return this.totalCost;
}
public void setTotalQuantity(String totalQuantity)
{
this.totalQuantity = totalQuantity;
}
public String getTotalQuantity()
{
return this.totalQuantity;
}


}