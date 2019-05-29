package test2.wwwTutorialspointJpa.service;

import test2.wwwTutorialspointJpa.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CreateEmployee {
    public static void main(String[] args) {
        EntityManagerFactory emfactory =  Persistence .createEntityManagerFactory ( "Hibernate_JPA" );

        EntityManager entitymanager = emfactory .createEntityManager( );
        entitymanager.getTransaction ( ).begin (  );

        Employee employee = new Employee( );
        employee.seteId( 1201 );
        employee.seteName( "Gopal" );
        employee.seteSalary( 40000 );
        employee.seteDeg( "Technical Manager" );

        entitymanager.persist( employee );
        entitymanager.getTransaction( ).commit( );

        entitymanager.close( );
        emfactory.close( );
    }
}



