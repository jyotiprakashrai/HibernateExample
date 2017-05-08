package com.jyoti.hibernate.main;

import java.util.Date;

import org.hibernate.Session;

import com.jyoti.hibernate.model.Employee;
import com.jyoti.hibernate.util.HibernateUtil;

public class HibernateMain {
	
	public static void main(String[] args) {
		Employee emp = new Employee();
		emp.setName("Jyoti");
		emp.setRole("Developer");
		emp.setInsertTime(new Date());
		
		//Get Session
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		//start transaction
		session.beginTransaction();
		//Save the Model object
		session.save(emp);
		//Commit transaction
		session.getTransaction().commit();
		System.out.println("Employee ID="+emp.getId());
		
		//terminate session factory, otherwise program won't end
		HibernateUtil.getSessionFactory().close();
	}

}
