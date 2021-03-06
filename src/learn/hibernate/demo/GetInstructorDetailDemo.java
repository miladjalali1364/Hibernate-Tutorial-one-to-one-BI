package learn.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import learn.hibernate.entity.Instructor;
import learn.hibernate.entity.InstructorDetail;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {
		
		// Create session factory
        SessionFactory factory = new Configuration()
            		                 .configure()
            		                 .addAnnotatedClass(Instructor.class)
            		                 .addAnnotatedClass(InstructorDetail.class)
            		                 .buildSessionFactory();
		
        // create session
		Session session = factory.getCurrentSession();
	
		
		try {
			
			
			//start a transaction
			session.beginTransaction();
			
			//get the instructor detail object
			 int theid =3;
			 
			 InstructorDetail tempInstructorDetail = 
					        session.get(InstructorDetail.class,theid);
						
			
			//print the instructor detail
			System.out.println("tempInstructorDetail: " + tempInstructorDetail);
			 
			 
			//print the associated intsructor
			System.out.println("the associated instructor: " + 
					           tempInstructorDetail.getInstructor());
					
			
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
			
		} 
		catch (Exception exp) {
			
			exp.printStackTrace();
		}
		finally {
			
			//handle connection leak issu
			session.close();
			factory.close();
		}
		
		
		
		
	}
	

}
