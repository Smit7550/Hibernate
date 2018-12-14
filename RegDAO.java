package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.RegVO;

public class RegDAO {
	public void insert(RegVO obj) 
	{
		try
		{
			SessionFactory s=new Configuration().configure().buildSessionFactory();
			
			Session s1 = s.openSession();
			
			Transaction t = s1.beginTransaction();
			
			s1.save(obj);
			
			t.commit();
			
			s1.close();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public List search(RegVO obj1) 
	{
		List ls = new ArrayList();
		try
		{
			SessionFactory s=new Configuration().configure().buildSessionFactory();
			
			Session s1 = s.openSession();
			
			Transaction t = s1.beginTransaction();
			
			Query q = s1.createQuery("from RegVO WHERE firstname LIKE '"+obj1.getFirstname()+"%'");
			ls = q.list();
			
			t.commit();
			
			s1.close();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return ls;
	}
	
	public void delete(RegVO obj2)
	{
		try
		{
			SessionFactory s=new Configuration().configure().buildSessionFactory();
			
			Session s1 = s.openSession();
			
			Transaction t = s1.beginTransaction();

			s1.delete(obj2);
			
			t.commit();
			
			s1.close();
			
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void edit(RegVO obj3)
	{
		try
		{
SessionFactory s=new Configuration().configure().buildSessionFactory();
			
			Session s1 = s.openSession();
			
			Transaction t = s1.beginTransaction();

			s1.update(obj3);
			
			t.commit();
			
			s1.close();

		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	
	public List search1(RegVO obj4) 
	{
		List ls = new ArrayList();
		try
		{
			SessionFactory s=new Configuration().configure().buildSessionFactory();
			
			Session s1 = s.openSession();
			
			Transaction t = s1.beginTransaction();
			
			Query q = s1.createQuery("from RegVO WHERE id='"+obj4.getId()+"'");
			ls = q.list();
			
			t.commit();
			
			s1.close();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return ls;
	}
	

}
