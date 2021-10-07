package com.example.demo.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
//@RequestMapping (path = "/vd", method = RequestMethod.GET)
public class CalculatorController
{
//	 private final PersonService personService;

//	 @Autowired
//	 public PersonController (PersonService personService)
//	 {
//		  this.personService = personService;
//	 }

//	 @GetMapping
//	 public List<Person> getListPerson (Model model)
//	 {
//		  return personService.getListPerson ();
//	 }
	 
	 @GetMapping ("/")
//	 @RequestMapping (path = "/vd", method = RequestMethod.GET)
	 public String getData (Model model)
	 {
//		  Person person = new Person ();
		  VD vd = new VD ();
		  model.addAttribute ("vd", vd);
		  return "index";
	 }
	 
	 @PostMapping ("/index")
	 public String submit (@ModelAttribute ("vd") VD vd)
	 {
		  long a = cauA (vd.getDauvao ().toString ());
		  long b = cauB (vd.getDauvao ().toString ());
		  long c = cauC (vd.getDauvao ().toString ());
		  String d = cauD (vd.getDauvao ().toString ());
		  vd.setA (String.valueOf (a));
		  vd.setB (String.valueOf (b));
		  vd.setC (String.valueOf (c));
		  vd.setD (String.valueOf (d));
		  System.out.println (vd.toString ());
		  return "index";
	 }
	 
	 public long cauA (String n)
	 {
		  Pattern p = Pattern.compile ("[^0-9 ]", Pattern.CASE_INSENSITIVE);
		  Matcher m = p.matcher (n);
		  boolean b = m.find ();
		  
		  if (b)
		  {return 0;}
		  
		  char first = n.charAt (0);
		  if (first == '0')
		  {
				return 0;
		  }
		  
		  if (n.equals ("0"))
		  {
				return 0;
		  }
		  
		  int number = Integer.parseInt (n);
		  long S = 0;
		  for (int i = 1 ; i <= number ; ++ i)
		  {
				S += i;
		  }
		  return S;
	 }
	 
	 public long cauB (String n)
	 {
		  Pattern p = Pattern.compile ("[^0-9 ]", Pattern.CASE_INSENSITIVE);
		  Matcher m = p.matcher (n);
		  boolean b = m.find ();
		  if (b)
		  {return 0;}
		  
		  long num = Long.parseLong (n);
		  if (num == 1 || num == 2)
		  {
				return 0;
		  }
		  
		  char first = n.charAt (0);
		  if (first == '0')
		  {
				return 0;
		  }
		  long S = 0;
		  for (int i = 1 ; i < num ; ++ i)
		  {
				if (num % i == 0)
				{
					 S += i;
				}
		  }
		  
		  return S;
	 }
	 
	 public long cauC (String n)
	 {
		  Pattern p = Pattern.compile ("[^0-9 ]", Pattern.CASE_INSENSITIVE);
		  Matcher m = p.matcher (n);
		  boolean b = m.find ();
		  if (b)
		  {return 0;}
		  
		  long num = Long.parseLong (n);
		  if (num == 1 || num == 2)
		  {
				return 0;
		  }
		  
		  char first = n.charAt (0);
		  if (first == '0')
		  {
				return 0;
		  }
		  
		  long S = 0;
		  for (int i = 2 ; i <= num ; ++ i)
		  {
				if (checkPrime (i))
				{
					 S += i;
				}
		  }
		  return S;
	 }
	 
	 private boolean checkPrime (long n)
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
	 
	 public String cauD (String n)
	 {
		  Pattern p = Pattern.compile ("[^0-9 ]", Pattern.CASE_INSENSITIVE);
		  Matcher m = p.matcher (n);
		  boolean b = m.find ();
		  
		  if (b)
		  {return "Not Valid!!!";}
		  
		  char first = n.charAt (0);
		  if (first == '0')
		  {
				return "Not Valid!!!";
		  }
		  
		  if (n.equals ("0"))
		  {
				return "Not Valid!!!";
		  }
		  
		  if (n.equals ("1"))
		  {
				return "1";
		  }
		  
		  long number = Long.parseLong (n);
		  HashMap<Integer, Integer> hashMap1 = new HashMap<Integer, Integer> ();
		  long temp = number;
		  int count = 0;
		  while (temp > 1)
		  {
				count = 0;
				for (int i = 2 ; i <= temp ; ++ i)
				{
					 if (checkPrime (i))
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
		  return finalText.toString ();
	 }
}
