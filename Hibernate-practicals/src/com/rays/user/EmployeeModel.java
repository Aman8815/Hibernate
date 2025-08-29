package com.rays.user;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class EmployeeModel {
	
	
	 public void add(EmployeeDTO dto) {
		 
		 SessionFactory sf = new Configuration().configure().buildSessionFactory();

			Session session = sf.openSession();

			Transaction tx = session.beginTransaction();

			session.save(dto);

			tx.commit();

			session.close();
		 
	 }
	 
	 public void update(EmployeeDTO dto) {
		 
		 SessionFactory sf = new Configuration().configure().buildSessionFactory();
		 
		 Session session = sf.openSession();
		 Transaction tx = session.beginTransaction();
		 
		 session.update(dto);
		 
		 tx.commit();
		 session.close();
		 
	 }
	 
	 public List search(EmployeeDTO dto, int pageSize, int pageNo) {
		 
		 List list = null;
		 SessionFactory sf = new Configuration().configure().buildSessionFactory();
		 Session session = sf.openSession();
	
		 Criteria criteria = session.createCriteria(EmployeeDTO.class);

			if (dto != null) {

				if (dto.getName() != null && dto.getName().length() > 0) {

					criteria.add(Restrictions.like("firstName", dto.getName() + "%"));

				}
			}

			if (pageSize > 0) {
				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult(pageNo);
				criteria.setMaxResults(pageSize);
			}

			 list = criteria.list();

			session.close();

			return list;
		 
		  
		
		 
	 }
	 
	 public  EmployeeDTO authenticate(String login ,String password) {
		 
			SessionFactory sf = new Configuration().configure().buildSessionFactory();

			Session session = sf.openSession();

			Query q = session.createQuery("from EmployeeDTO where loginId = ? and password = ?");

			q.setString(0, login);
			q.setString(1, password);

			List list = q.list();

			EmployeeDTO dto = null;

			if (list.size() > 0) {

				dto = (EmployeeDTO) list.get(0);

			}
			session.close();
		return dto;
		 
	 }
	 
	 public EmployeeDTO FindByPk(int pk) {
		 SessionFactory sf = new Configuration().configure().buildSessionFactory();

			Session session = sf.openSession();
			

			EmployeeDTO dto = (EmployeeDTO) session.get(EmployeeDTO.class, pk);

			session.close();
		 
		return dto;
		 
	 }

}
