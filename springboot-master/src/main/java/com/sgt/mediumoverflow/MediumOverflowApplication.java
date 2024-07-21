package com.sgt.mediumoverflow;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
//This notation is a short hand version for 3 notations
//Configuration
//EnableAutoConfiguration
//These automatically puts the classpath
//ComponentScan
//Scans all the beans and informs the ioc
//Thus,if we create a bean outside it,it will not be able to scan

//web or resource-1st layer


public class MediumOverflowApplication {

	public static void main(String[] args)
	{

//		This was on 16th November
		ApplicationContext applicationContext=SpringApplication.run(MediumOverflowApplication.class, args);
//		Car c=applicationContext.getBean(Car.class);
////here,we are calling the bean of car class
//
//		System.out.println(c.startCar());




	}


}
