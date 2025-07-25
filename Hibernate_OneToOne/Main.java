package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Laptop l1 = new Laptop();
        l1.setLid(1);
        l1.setBrand("Asus");
        l1.setModel("rog");
        l1.setRam(16);

        Coder c1 = new Coder();
        c1.setCid(101);
        c1.setName("Raj");
        c1.setTech("Java");
        c1.setLaptop(l1);

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(org.example.Coder.class)
                .addAnnotatedClass(org.example.Laptop.class)
                .configure()
                .buildSessionFactory();
        Session s = sf.openSession();

//        configuration loads the xml file

        Transaction t = s.beginTransaction();           // we can manipulate data in DB only between transactions
//        Student s2 = s.load(Student.class,1);
        s.persist(l1);
        s.persist(c1);
//      s.merge(stud);
//      s.remove(s1);
        t.commit();

        Coder c2 = s.get(Coder.class ,101);
        System.out.println(c2);
        s.close();
        sf.close();

//        System.out.println(c2);
    }
}