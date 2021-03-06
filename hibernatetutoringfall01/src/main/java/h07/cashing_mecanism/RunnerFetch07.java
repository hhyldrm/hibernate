package h07.cashing_mecanism;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.fasterxml.classmate.AnnotationOverrides.StdBuilder;

public class RunnerFetch07 {

	public static void main(String[] args) {
		
		Book07 book = new Book07();
		
		Student07 std = new Student07();
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Student07.class).
				addAnnotatedClass(Book07.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		
		Transaction tx = session.beginTransaction();
		
		
		//std = session.get(Student07.class, 101);
		
		
		book = session.get(Book07.class, 10);
		book = session.get(Book07.class, 11);
		book = session.get(Book07.class, 10);
		book = session.get(Book07.class, 1);
		
		tx.commit();
		session.close();
	//	System.out.println(std);
		System.out.println(book);
		
		
		
		Session session2 = sf.openSession();
		Transaction tx2 = session2.beginTransaction();
		
		Book07 b2= session2.get(Book07.class, 10);
		b2= session2.get(Book07.class, 12);
		b2= session2.get(Book07.class, 12);
		
		tx2.commit();
		System.out.println(b2);
		
		
		
		

	}

}
