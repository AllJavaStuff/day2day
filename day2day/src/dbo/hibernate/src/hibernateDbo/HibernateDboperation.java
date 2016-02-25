package hibernateDbo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import hibernateBean.hibernateEmpBean;
import hibernateUtility.HibernateUtil;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HibernateDboperation {

	public static void main(String[] args) {

		HibernateDboperation hdbo = new HibernateDboperation();

		Integer id1 = hdbo.saveEmployee("abc", "dsd", 100000, "2005-12-31");
		Integer id2 = hdbo.saveEmployee("pqr", "sdff", 50000, "2011-06-26");
		Integer id3 = hdbo.saveEmployee("xyz", "sdff", 45000, "2013-05-22");
		Integer id4 = hdbo.saveEmployee("asf", "dfs", 65000, "2013-04-15");
		hdbo.retriveEmployee();
		hdbo.deleteEmployee(id2);
		hdbo.deleteEmployee("xyz", "sdff");
		hdbo.updateEmployee(65000);

	}

	private void updateEmployee(int salary) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			String queryString = "from Employee where salary = :sal";
			Query query = session.createQuery(queryString);
			query.setInteger("sal", salary);
			hibernateEmpBean employee = (hibernateEmpBean) query.uniqueResult();

			employee.setSalary(11000);
			session.update(employee);
			System.out.println("employee id" + employee.getId()
					+ " is updated!");
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	private void deleteEmployee(String name, String city) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			String queryString = "from Emp where name = :name and city = :city";
			Query query = session.createQuery(queryString);
			query.setString("name", name);
			query.setString("city", city);
			hibernateEmpBean employee = (hibernateEmpBean) query.uniqueResult();
			session.delete(employee);
			System.out.println("employee is deleted!");

			// Another way to write it
			/*
			 * String hql =
			 * "delete from Emp where name = "+name+" and city ="+city; Query
			 * query1 = session.createQuery(hql); int row =
			 * query1.executeUpdate(); if (row == 0){
			 * System.out.println("No Row deleted!"); } else{
			 * System.out.println("Deleted Row: " + row); }
			 */

		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	private void updateEmployee(Integer id1, int salary) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			hibernateEmpBean employee = (hibernateEmpBean) session.get(
					hibernateEmpBean.class, id1);
			employee.setSalary(salary);
			session.update(employee);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	private void deleteEmployee(Integer id2) {
		// TODO Auto-generated method stub

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			hibernateEmpBean employee = (hibernateEmpBean) session.get(
					hibernateEmpBean.class, id2);
			session.delete(employee);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	private void retriveEmployee() {
		// TODO Auto-generated method stub

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List<hibernateEmpBean> employees = session.createQuery("FROM Emp")
					.list();
			for (hibernateEmpBean emp : employees) {
				System.out.println(emp);
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	private Integer saveEmployee(String name, String city, int salary,
			String joining_date) {
		// TODO Auto-generated method stub

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Integer employeeID = null;
		try {
			tx = session.beginTransaction();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

			java.util.Date d = formatter.parse(joining_date);

			hibernateEmpBean employee = new hibernateEmpBean(name, city,
					salary, d);
			employeeID = (Integer) session.save(employee);
			System.out.println("inserted Id =" + employeeID);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}

		return employeeID;

	}
}
