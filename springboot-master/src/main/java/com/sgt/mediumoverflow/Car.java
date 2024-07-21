package com.sgt.mediumoverflow;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Car
{

        @Autowired
        Engine e;

        public int startCar()
        {
           return e.start();
        }


}
