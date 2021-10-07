package com.example.demo.person;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService
{
	 
	 public List<Person> getListPerson ()
	 {
		  List<Person> peopleList = new ArrayList<> ();
		  peopleList.add (new Person (1, "Hung", "lhun@gmail.com", LocalDate.of (2000, 11, 20), getBirth (LocalDate.of (2000, 11, 20))));
		  peopleList.add (new Person (2, "Khai", "khai1@gmail.com", LocalDate.of (2000, 1, 22), getBirth (LocalDate.of (2000, 1, 22))));
		  peopleList.add (new Person (3, "Tung", "tungnhu1@gmail.com", LocalDate.of (2000, 12, 11), getBirth (LocalDate.of (2000, 12, 11))));
		  peopleList.add (new Person (4, "Hien", "hienhua4@gmail.com", LocalDate.of (2000, 4, 27), getBirth (LocalDate.of (2000, 4, 27))));
		  return peopleList;
	 }
	 
	 private int getBirth (LocalDate d1)
	 {
		  LocalDate now = LocalDate.now ();
		  Period age = Period.between (d1, now);
		  return age.getYears ();
	 }
}
