package com.practice.chhotabasket.pojo;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection="clientData")
public class Client implements java.io.Serializable
{
@Id
private String emailId;
private String firstName;
private String lastName;
private String password;
private String contact;
private String optionalContact;
private String address;
private String otp;

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
public void setEmailId(String emailId)
{
this.emailId = emailId;
}
public String getEmailId()
{
return this.emailId;
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
public void setOptionalContact(String optionalContact)
{
this.optionalContact = optionalContact;
}
public String getOptionalContact()
{
return this.optionalContact;
}
public void setAddress(String address)
{
this.address = address;
}
public String getAddress()
{
return this.address;
}


public void setOtp(String otp)
{
this.otp = otp;
}
public String getOtp()
{
return this.otp;
}

}