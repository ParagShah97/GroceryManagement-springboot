package com.practice.chhotabasket.pojo;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection="storageData")
public class Storage implements java.io.Serializable
{
@Id
private String id;
private String name;
private String quantity;
private double totalQuantity;
private double productCost;
private double totalCost;
private double minQuantity;
private String category;
private String type;
private String scale;
private String timeStamp;
private String imgSrc;

public Storage(){}

public Storage(String id,String name,String quantity,double totalQuantity,double productCost,double totalCost,double minQuantity,String category,String type,String scale,String timeStamp,String imgSrc)
{
this.id=id;
this.name=name;
this.quantity=quantity;
this.totalQuantity=totalQuantity;
this.productCost=productCost;
this.totalCost=totalCost;
this.minQuantity=minQuantity;
this.category=category;
this.type=type;
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
public void setQuantity(String quantity)
{
this.quantity=quantity;
}
public String getQuantity()
{
return this.quantity;
}
public void setTotalQuantity(double totalQuantity)
{
this.totalQuantity = totalQuantity;
}
public double getTotalQuantity()
{
return this.totalQuantity;
}
public void setProductCost(double productCost)
{
this.productCost = productCost;
}
public double getProductCost()
{
return this.productCost;
}
public void setTotalCost(double totalCost)
{
this.totalCost = totalCost;
}
public double getTotalCost()
{
return this.totalCost;
}
public void setMinQuantity(double minQuantity)
{
this.minQuantity = minQuantity;
}
public double getMinQuantity()
{
return this.minQuantity;
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

public void setScale(String scale)
{
this.scale = scale;
}
public String getScale()
{
return this.scale;
}

public void setTimeStamp(String timeStamp)
{
this.timeStamp = timeStamp;
}
public String getTimeStamp()
{
return this.timeStamp;
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
