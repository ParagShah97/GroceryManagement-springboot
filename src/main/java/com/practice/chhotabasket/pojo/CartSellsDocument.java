package com.practice.chhotabasket.pojo;

import org.springframework.data.annotation.Id;
public class CartSellsDocument implements java.io.Serializable
{
@Id
private String sellsId;
private String type;

public CartSellsDocument()
{}

public CartSellsDocument(String sellsId,String type)
{
this.type=type;
this.sellsId=sellsId;
}


public void setType(String type)
{
this.type=type;
}

public void setSellsId(String sellsId)
{
this.sellsId=sellsId;
}

public String getType()
{
return this.type;
}
public String getSellsId()
{
return this.sellsId;
}
}