package com.mphasis.training;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.mphasis.training.daos.PlayerDao;
import com.mphasis.training.entities.Product;


public class PlayerApp {

	public static void main(String[] args) throws ParseException {
		
		System.out.println( " Welcome Player App" );
		PlayerDao pdao=new PlayerDao();
        System.out.println( "Welcome!" );
        Scanner s=new Scanner(System.in);
        PlayerDao pd=new PlayerDao();
        
        while(true) {
            System.out.println("1.Retrive All Players \n2.Get Player by Id \n3.Get Player by Name "
                    + "\n4.Get Player By gender \n 5.Get Player By Contact \n 6 .Get Player By Email \n  7. Get Player By Team Name \n 8.Get Player By Age \n 9.Get Player By DOB \n 10.Get Player By Score \n ");
            
            switch(s.nextInt()) {
            
            case 1:
                System.out.println("List of all players");
                pd.retrieveAllPlayers().forEach(p->System.out.println(p));
                break;
                
            case 2:
                System.out.println("Enter player id to search");
                System.out.println(pd.retrievePlayerById(s.nextInt()));
                break;
                
            case 3:
            	 System.out.println("List of Players by name");
            	 pd.retrieveByName(s.next()).forEach(p->System.out.println(p));
                 break;
                 
            case 4:
           	     System.out.println("List of Players by gender");
           	     pd.retrieveByGender(s.next()).forEach(p->System.out.println(p));
                  break;
                
            case 5:
              	 System.out.println("List of Players by contact");
              	 System.out.println(pd.retrieveByContact(s.next()));
                   break;
                   
            case 6:
              	 System.out.println("List of Players by email");
              	 System.out.println(pd.retrieveByEmail(s.next()));
                   break;
                   
            case 7:
              	 System.out.println("List of Players by Team Name");
              	 pd.retrieveByTeamName(s.next()).forEach(p->System.out.println(p));
                   break;
                   
            case 8:
              	 System.out.println("List of Players by age");
              	 pd.retrieveByAge(s.nextInt()).forEach(p->System.out.println(p));
                   break;
                   
            case 9:
              	 System.out.println("List of Players by dob");
              	Date date=new SimpleDateFormat("dd-MMM-yyyy").parse(s.next());
              	pd.retrieveByDob(date).forEach(p->System.out.println(p));
                   break;
                   
            case 10:
              	 System.out.println("List of Players by score");
              	 pd.retrieveByScore(s.nextLong()).forEach(p->System.out.println(p));
                   break;
                
                   
            default: System.out.println("Invalid Choice");

	}

}
}
}
