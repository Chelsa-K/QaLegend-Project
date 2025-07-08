package Utilities;
//to dynamically construct unique phone numbers, client names, etc. 
//For this, in pom.xml,we must first add faker dependency(gives faker class) which contains the faker utility supporting jar files
//(dependency is from java fakerclass in github)
import java.util.Random;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;

public class FakerUtility {
	public static int getRandomNumber() {   //random class is an inbuilt class of Java
		Random rand= new Random();
		int randomNumber= rand.nextInt(100000);
		return randomNumber;
	}
	
	public static String getFakerFirstName() {
		Faker faker = new Faker();                  //instantiate Faker Class
		Address address = faker.address();     //address - interface, 
		String firstName= address.firstName();
		return firstName;
		
	}
	public static String getFakerLastName() {
		Faker faker = new Faker();
		Address address = faker.address();
		String lastName= address.lastName();
		return lastName;
		
	}
	public static String getFakerAddress() {
		Faker faker = new Faker();
		Address address = faker.address();
		String address1= address.fullAddress();
		return address1;
		
	}
			//
	public static String getFakerCityName() {
		Faker faker = new Faker();
		Address address = faker.address();
		String cityName= address.cityName();
		return cityName;
	}
	
	public static String getFakerStateName() {
		Faker faker = new Faker();
		Address address = faker.address();
		String stateName= address.state();
		return stateName;
	}
	
	public static String getFakerCountryName() {
		Faker faker = new Faker();
		Address address = faker.address();
		String countryName= address.country();
		return countryName;
	}
	
	public static String getFakerCountryCode() {
		Faker faker = new Faker();
		Address address = faker.address();
		String countryCode= address.countryCode();
		return countryCode;
		
	}
	public static String getFakerzipCode() {
		Faker faker = new Faker();
		Address address = faker.address();
		String zipCode= address.zipCode();
		return zipCode;
	}
	
	public static String getFakerPhoneNumber() {
		Faker faker = new Faker();
		String phoneNumber= faker.phoneNumber().phoneNumber();  //????????????
		return phoneNumber;
	}

	

	
	
	

	
	
		
}
	
