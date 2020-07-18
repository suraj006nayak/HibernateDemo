package com.mphasis.training.daos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.mphasis.training.entities.Player;
import com.mphasis.training.entities.Product;



public class PlayerDao {
	
	SessionFactory sessionFactory =null;
	
       public PlayerDao() {
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Player.class);
		StandardServiceRegistryBuilder builder=
				new StandardServiceRegistryBuilder().applySettings(con.getProperties());
		sessionFactory =con.buildSessionFactory(builder.build());
	}
       
       public List<Player> retrieveAllPlayers() {
   		List<Player> players =new ArrayList<>();
   		Session session =sessionFactory.openSession();
   		players = session.createCriteria(Player.class).list();
   		return players;
   	}
       
       public Player retrievePlayerById(int pid) {
   		Session session=sessionFactory.openSession();
   		Player p=(Player)session.get(Player.class, pid);
   		return p;
   	}
	
       
       public List<Player> retrieveByName(String name){
   		List<Player> players =new ArrayList<>();
   		Session session = sessionFactory.openSession();
   		players =session.createCriteria(Player.class)
   				.add(Restrictions.eq("name", name)).list();
   		return players;
   	}
       
       public List<Player> retrieveByGender(String gender){
      		List<Player> players =new ArrayList<>();
      		Session session = sessionFactory.openSession();
      		players =session.createCriteria(Player.class)
      				.add(Restrictions.eq("gender", gender)).list();
      		return players;
      	}
       
       public List<Player> retrieveByContact(String contact){
     		List<Player> players =new ArrayList<>();
     		Session session = sessionFactory.openSession();
     		players =session.createCriteria(Player.class)
     				.add(Restrictions.eq("contact", contact)).list();
     		return players;
     	}
       
       
       public List<Player> retrieveByEmail(String email){
     		List<Player> players =new ArrayList<>();
     		Session session = sessionFactory.openSession();
     		players =session.createCriteria(Player.class)
     				.add(Restrictions.eq("email", email)).list();
     		return players;
     	}
       
       public List<Player> retrieveByTeamName(String teamName){
     		List<Player> players =new ArrayList<>();
     		Session session = sessionFactory.openSession();
     		players =session.createCriteria(Player.class)
     				.add(Restrictions.eq("teamName", teamName)).list();
     		return players;
     	}
       
       public List<Player> retrieveByAge(int age){
     		List<Player> players =new ArrayList<>();
     		Session session = sessionFactory.openSession();
     		players =session.createCriteria(Player.class)
     				.add(Restrictions.eq("age", age)).list();
     		return players;
     	}
       
       public List<Player> retrieveByDob(Date date){
     		List<Player> players =new ArrayList<>();
     		Session session = sessionFactory.openSession();
     		players =session.createCriteria(Player.class)
     				.add(Restrictions.eq("dob", date)).list();
     		return players;
     	}
       
       public List<Player> retrieveByScore(long score){
     		List<Player> players =new ArrayList<>();
     		Session session = sessionFactory.openSession();
     		players =session.createCriteria(Player.class)
     				.add(Restrictions.eq("score", score)).list();
     		return players;
     	}

}
