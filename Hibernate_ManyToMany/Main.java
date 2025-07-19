package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Laptop l1 = new Laptop();
        l1.setLid(1);
        l1.setBrand("Asus");
        l1.setModel("rog");
        l1.setRam(16);


        Laptop l2 = new Laptop();
        l2.setLid(2);
        l2.setBrand("Dell");
        l2.setModel("Vostro");
        l2.setRam(32);

        Laptop l3 = new Laptop();
        l3.setLid(3);
        l3.setBrand("Apple");
        l3.setModel("Macbook");
        l3.setRam(8);


        Coder c1 = new Coder();
        c1.setCid(101);
        c1.setName("Raj");
        c1.setTech("Java");

        Coder c2 = new Coder();
        c2.setCid(102);
        c2.setName("Robert");
        c2.setTech("Python");

        Coder c3 = new Coder();
        c3.setCid(103);
        c3.setName("Ned Stark");
        c3.setTech("AI");

//        setting laptops to coders
        c1.setLaptops(Arrays.asList(l1,l2));
        c2.setLaptops(Arrays.asList(l2,l3));
        c3.setLaptops(Arrays.asList(l1));

//        setting coders to laptops
        l1.setCoders(Arrays.asList(c1,c3));
        l2.setCoders(Arrays.asList(c1,c2));
        l3.setCoders(Arrays.asList(c2));

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(org.example.Coder.class)
                .addAnnotatedClass(org.example.Laptop.class)
                .configure()
                .buildSessionFactory();
        Session s = sf.openSession();

//        configuration loads the xml file

        Transaction t = s.beginTransaction();           // we can manipulate data in DB only between transactions
        s.persist(l1);
        s.persist(l2);
        s.persist(l3);

        s.persist(c1);
        s.persist(c2);
        s.persist(c3);
        t.commit();

        Coder c5 = s.get(Coder.class ,102);
        System.out.println(c5);
        s.close();
        sf.close();

    }
}