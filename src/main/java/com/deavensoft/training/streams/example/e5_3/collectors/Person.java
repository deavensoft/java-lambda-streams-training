package com.deavensoft.training.streams.example.e5_3.collectors;

public class Person {
  private final String name;
  private final Gender gender;
  private final int age;
  
  public Person(String theName, Gender theGender, int theAge) {
    name = theName;
    gender = theGender;
    age = theAge;
  }
  
  public String getName() { 
    return name; 
  }
  public int getAge() { 
    return age; 
  }
  public Gender getGender() { return gender; }
  
  public String toString() {
    return String.format("%s -- %s -- %d", name, gender, age);
  }  
}