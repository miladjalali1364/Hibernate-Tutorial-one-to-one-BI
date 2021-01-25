package learn.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import learn.hibernate.entity.Instructor;
import learn.hibernate.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		
		//create session factory
		
		SessionFactory factory = new Configuration()
				                     .configure()
				                     .addAnnotatedClass(Instructor.class)
				                     .addAnnotatedClass(InstructorDetail.class)
				                     .buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			
			Instructor tempInstructor = 
					new Instructor("Madhu", "Patel", "madhu@luv2code.com");
			
			
			InstructorDetail tempInstructorDetail =
					new InstructorDetail(
							"http://www.youtube.com",
							"Guitar");
			
			// associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			// start a transaction
			session.beginTransaction();
			
			
			
			//commit transaction
			session.getTransaction().commit();
			
			
		} finally {
			// TODO: handle finally clause
		}
		
		

	}

}
