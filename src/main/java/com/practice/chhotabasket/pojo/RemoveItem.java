package com.practice.chhotabasket.pojo;

public class RemoveItem implements java.io.Serializable
{
private String delName;
private String delType;

public RemoveItem(){}

public RemoveItem(String delName,String delType){
this.delName=delName;
this.delType=delType;
}

public void setDelName(String delName)
{
this.delName = delName;
}
public String getDelName()
{
return this.delName;
}
public void setDelType(String delType)
{
this.delType = delType;
}
public String getDelType()
{
return this.delType;
}
}