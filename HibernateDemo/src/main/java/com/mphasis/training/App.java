package com.mphasis.training;

import java.util.Scanner;

import org.hibernate.cfg.Configuration;

import com.mphasis.training.daos.ProductDao;
import com.mphasis.training.entities.Product;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Product App" );
       
        ProductDao pdao=new ProductDao();
        System.out.println( "Welcome!" );
        Scanner s=new Scanner(System.in);
        ProductDao pd=new ProductDao();
        while(true) {
        System.out.println("1.Retrive Products \n2.Search Product \n3.Insert Product "
                + "\n4.Update Product   \n5.Delete product");
        
        switch(s.nextInt()) {
        
        case 1:
            System.out.println("List of all products");
            pd.retrieveAll().forEach(p->System.out.println(p));
            break;
            
        case 2:
            System.out.println("Enter product id to search");
            System.out.println(pd.retrieveProductById(s.nextInt()));
            break;
            
        case 3:
            System.out.println("Enter product details");
            Product p=new Product(s.nextInt(),s.next(),s.nextDouble(),s.nextInt());
            pd.insertProduct(p);
            System.out.println("Product added successfully");
            break;
            
        case 4:
            System.out.println("Enter product details to update");
            Product p1=new Product(s.nextInt(),s.next(),s.nextDouble(),s.nextInt());
            pd.updateProduct(p1);
            System.out.println("Product updated successfully");
            break;
            
        case 5:
            System.out.println("Enter product details to delete");
            pd.deleteProduct(s.nextInt());
            System.out.println("Product deleted  successfully");
            break;
            
 
              
              default: System.out.println("Invalid Choice");
              
       
        }
    }
}
}
