package com.project2.spacepals;

import com.project2.spacepals.entities.Role;
import com.project2.spacepals.entities.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.time.LocalDate;
import java.util.Date;

public class UsersDriver {

    private static SessionFactory factory ;

    public UsersDriver(SessionFactory sessionFactory){
        super();
        this.factory = sessionFactory;
    }
    public static void main(String[] args) {
        try {
            addUsers();
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    public static void addUsers() {
    try(Session session = factory.getCurrentSession()){
session.beginTransaction();

        Users[] users = {
                new Users("Magnus","Croly","Magnus@gmail.com","895-345-5675",
                        LocalDate.of(1995,12,25),"revature","Mars",
                        "Male",35, Role.BASIC_USER),
                new Users("Evan","Hsi","EMoney@gmail.com","313-485-6247",LocalDate.of(1995,12,29),"revature","Saturn","Male",100,Role.FLIGHT_MANAGER),
                new Users("Niles","Diggs","NDawg@gmail.com","206-584-1697",LocalDate.of(1994,5,29),"revature","Venus","Male",100,Role.FLIGHT_MANAGER),
                new Users("Ervin","Stewart","e.s@gmail.com","313-459-7896",LocalDate.of(1995,8,7),"revature","Earth","Male",100,Role.ADMIN),
                new Users("Ashley","Everhart","Everhart@gmail.com","313-390-5675",
                        LocalDate.of(1985,1,26),"revature","Earth",
                        "Female",5, Role.BASIC_USER),
                new Users("Kelly","Baker","Everhart@gmail.com","313-490-5675",
                        LocalDate.of(1972,11,5),"revature","Earth",
                        "Female",20, Role.BASIC_USER),
                new Users("Blake","Dunn","Dunn@gmail.com","808-390-5675",
                        LocalDate.of(1990,11,20),"revature","Earth",
                        "Male",50, Role.BASIC_USER),
                new Users("Ezra","Tremblay","Other@gmail.com","571-390-5675",
                        LocalDate.of(1998,6,15),"revature","Jupiter",
                        "Other",0, Role.BASIC_USER)
        };

        for(Users u: users) session.save(u);
        session.getTransaction().commit();

    }

    }
}