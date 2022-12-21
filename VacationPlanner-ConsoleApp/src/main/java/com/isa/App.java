package com.isa;

import com.isa.menu.MenuBehaviour;
import com.isa.model.Employee;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class App
{
    public static void main( String[] args )
    {
        System.out.println( "*Luz_Blue Team*" + "\n" + "Hello!" + "\n" + "Welcome to the VacationPlanner\n" );

        MenuBehaviour menu = new MenuBehaviour();
        menu.retrieveSelection();



    }
}
