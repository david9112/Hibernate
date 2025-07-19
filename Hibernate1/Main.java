package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Student s1=new Student();
//        s1.setRollNo(5);
//        s1.setName("Walter");
//        s1.setAge(25);

//        Configuration c = new Configuration();
//        c.addAnnotatedClass(org.example.Student.class);
//        c.configure();

//        Student s2=new Student();
        String s2=null;
        SessionFactory sf = new Configuration().addAnnotatedClass(org.example.Student.class).configure().buildSessionFactory();
        Session s = sf.openSession();
        s1=s.get(Student.class,5);
        Transaction t = s.beginTransaction();
//        s2 = s.get(Student.class,4);
//        s.persist(s1);
//        s.merge(s1);
//        s.remove(s1);
        t.commit();
        s.close();
        sf.close();

        System.out.println(s1);
    }
}
