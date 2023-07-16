package com.practice.chhotabasket.pojo;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
@Document(collection="idCounter")
public class IdCounter implements java.io.Serializable
{
@Id
private int id;
private String collectionName;
private String lastId;

public void setId(int id)
{
this.id = id;
}
public int getId()
{
return this.id;
}
public void setCollectionName(String collectionName)
{
this.collectionName = collectionName;
}
public String getCollectionName()
{
return this.collectionName;
}
public void setLastId(String lastId)
{
this.lastId = lastId;
}
public String getLastId()
{
return this.lastId;
}
}