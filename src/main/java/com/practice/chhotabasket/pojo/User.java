package com.practice.chhotabasket.pojo;

public class User implements java.io.Serializable
{
private String userId;
private String userPassword;

public void setUserId(String userId)
{
this.userId = userId;
}
public String getUserId()
{
return this.userId;
}
public void setUserPassword(String userPassword)
{
this.userPassword = userPassword;
}
public String getUserPassword()
{
return this.userPassword;
}
}