package com.practice.chhotabasket.pojo;

//import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import com.practice.chhotabasket.pojo.SellsProduct;
import java.util.List;

public class Sells implements java.io.Serializable
{
@Id
private String id;
private String emailId;
private List<SellsProduct> sellsProduct;
private double totalCost;
private String timeStamp;

public void setSellsProduct(List<SellsProduct> sellsProduct)
{
this.sellsProduct=sellsProduct;
}

public void setEmailId(String emailId)
{
this.emailId=emailId;
}

public String getEmailId()
{
return this.emailId;
}

public List<SellsProduct> getSellsProduct()
{
return this.sellsProduct;
}

public void setId(String id)
{
this.id = id;
}
public String getId()
{
return this.id;
}

public void setTotalCost(double totalCost)
{
this.totalCost = totalCost;
}
public double getTotalCost()
{
return this.totalCost;
}
public void setTimeStamp(String timeStamp)
{
this.timeStamp = timeStamp;
}
public String getTimeStamp()
{
return this.timeStamp;
}


}