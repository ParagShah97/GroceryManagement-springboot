package com.practice.chhotabasket.pojo;

public class ResetPasswordObject implements java.io.Serializable
{
private String otp;
private String password;
public void setOtp(String otp)
{
this.otp = otp;
}
public String getOtp()
{
return this.otp;
}
public void setPassword(String password)
{
this.password = password;
}
public String getPassword()
{
return this.password;
}

}