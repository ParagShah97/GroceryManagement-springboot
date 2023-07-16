package com.practice.chhotabasket.model;
import java.util.*;

public class ProductModel implements java.io.Serializable
{

private List<String> productName= new LinkedList<>();

public ProductModel(){}

public void setProductData(List<String> productName)
{
this.productName=productName;
}

public List<String> getProductData()
{
return this.productName;
}

public void updateProductData(String product)
{
this.productName.add(product);
}

public void deleteProductData(String product)
{
this.productName.remove(product);
}

}