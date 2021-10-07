package com.example.demo.person;

import java.util.*;

public class VD
{
	 String dauvao;
	 String a, b, c, d;
	 
	 public VD (String dauvao, String a, String b, String c, String d)
	 {
		  this.dauvao = dauvao;
		  this.a = a;
		  this.b = b;
		  this.c = c;
		  this.d = d;
	 }
	 
	 public VD ()
	 {
	 }
	 
	 public String getA ()
	 {
		  return a;
	 }
	 
	 public void setA (String a)
	 {
		  this.a = a;
	 }
	 
	 public String getB ()
	 {
		  return b;
	 }
	 
	 public void setB (String b)
	 {
		  this.b = b;
	 }
	 
	 public String getC ()
	 {
		  return c;
	 }
	 
	 public void setC (String c)
	 {
		  this.c = c;
	 }
	 
	 public String getD ()
	 {
		  return d;
	 }
	 
	 public void setD (String d)
	 {
		  this.d = d;
	 }
	 
	 public String getDauvao ()
	 {
		  return dauvao;
	 }
	 
	 public void setDauvao (String dauvao)
	 {
		  this.dauvao = dauvao;
	 }
	 
	 @Override
	 public String toString ()
	 {
		  return "VD{" +
					"dauvao='" + dauvao + '\'' +
					", a='" + a + '\'' +
					", b='" + b + '\'' +
					", c='" + c + '\'' +
					", d='" + d + '\'' +
					'}';
	 }
	 
	 public boolean checkPrime (long n)
	 {
		  for (int i = 2 ; i <= Math.sqrt (n) ; ++ i)
		  {
				if (n % i == 0)
				{
					 return false;
				}
		  }
		  return true;
	 }
	 
	 public static void main (String[] args)
	 {
		  VD vd = new VD ();
		  int n = 2;
		  HashMap<Integer, Integer> hashMap1 = new HashMap<Integer, Integer> ();
		  int temp = n;
		  int count = 0;
		  while (temp > 1)
		  {
				count = 0;
				for (int i = 2 ; i <= temp ; ++ i)
				{
					 if (vd.checkPrime (i))
					 {
						  while (temp % i == 0)
						  {
								count++;
								temp /= i;
						  }
						  if (count > 0)
						  {
								hashMap1.put (i, count);
								count = 0;
						  }
					 }
				}
		  }
//		  System.out.println (hashMap1);
//		  StringBuilder finalText = new StringBuilder ();
//		  for (Integer key : hashMap1.keySet ())
//		  {
//				finalText.append (String.valueOf (key)).append ("^").append (String.valueOf (hashMap1.get (key))).append (" x ");
//
//		  }
		  String finalText = "";
		  
		  Iterator hmIterator = hashMap1.entrySet ().iterator ();
		  while (hmIterator.hasNext ())
		  {
				Map.Entry mapElement = (Map.Entry) hmIterator.next ();
				int marks = ((int) mapElement.getValue ());
				
				if (! hmIterator.hasNext ())
				{
//					 System.out.print (mapElement.getKey () + "^" + marks);
					 finalText += String.valueOf (mapElement.getKey () + "^" + marks);
				}
				else
				{
//					 System.out.print (mapElement.getKey () + "^" + marks + " x ");
					 finalText += String.valueOf (mapElement.getKey () + "^" + marks + " x ");
				}
		  }
		  System.out.println (finalText.toString ());
		  
	 }
	 
	 
}
