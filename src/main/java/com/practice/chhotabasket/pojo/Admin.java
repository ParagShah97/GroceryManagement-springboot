package com.practice.chhotabasket.pojo;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection="admin")
public class Admin implements java.io.Serializable
{
@Id
private String id;
private String firstName;
private String lastName;
private String password;
private String contact;

public void setId(String id)
{
this.id = id;
}
public String getId()
{
return this.id;
}
public void setFirstName(String firstName)
{
this.firstName = firstName;
}
public String getFirstName()
{
return this.firstName;
}
public void setLastName(String lastName)
{
this.lastName = lastName;
}
public String getLastName()
{
return this.lastName;
}
public void setPassword(String password)
{
this.password = password;
}
public String getPassword()
{
return this.password;
}
public void setContact(String contact)
{
this.contact = contact;
}
public String getContact()
{
return this.contact;
}
}