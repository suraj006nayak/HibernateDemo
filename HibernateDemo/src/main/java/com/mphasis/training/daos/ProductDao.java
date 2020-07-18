package com.mphasis.training.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.mphasis.training.entities.Product;

public class ProductDao {
	
	SessionFactory sessionFactory =null;
	public ProductDao() {
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Product.class);
		StandardServiceRegistryBuilder builder=
				new StandardServiceRegistryBuilder().applySettings(con.getProperties());
		sessionFactory =con.buildSessionFactory(builder.build());
	}
	
	public void insertProduct (Product p) {
		Session session =sessionFactory.openSession();
		session.beginTransaction();
		session.save(p);
		session.getTransaction().commit();
		session.close();
	}
	
	
	public void updateProduct (Product p) {
		Session session =sessionFactory.openSession();
		session.beginTransaction();
		session.update(p);
		session.getTransaction().commit();
		session.close();
	}

	public void deleteProduct (int pid) {
		Session session=null;
		try {
		 session =sessionFactory.openSession();
		session.beginTransaction();
		Product p=(Product)session.get(Product.class, pid);
		session.delete(p);
		session.getTransaction().commit();
		}catch(Exception e) {
			session.getTransaction().rollback();
		}finally {
		session.close();
		}
	}
	
	public Product retrieveProductById(int pid) {
		Session session=sessionFactory.openSession();
		Product p=(Product)session.get(Product.class, pid);
		return p;
	}
	
	public List<Product> retrieveAll() {
		List<Product> products =new ArrayList<>();
		Session session =sessionFactory.openSession();
		products = session.createCriteria(Product.class).list();
		return products;
	}

	//select * from product where cost =?;
	public List<Product> retrieveByCost(double cost){
		List<Product> products =new ArrayList<>();
		Session session = sessionFactory.openSession();
		products =session.createCriteria(Product.class)
				.add(Restrictions.eq("cost", cost)).list();
		return products;
	}


}
