package vn.molu.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import vn.molu.dao.HibernateUtil;
import vn.molu.domain.Employee;

public class EmployeeRepository {
	public List<Employee> findAll() {
		try (Session session = HibernateUtil.getSessionfactory().openSession()) {
			return session.createQuery("From Employee").list();
		}
	}

	public Employee find(long id) {
		try (Session session = HibernateUtil.getSessionfactory().openSession()) {
			return session.find(Employee.class, id);
		}
	}

	public boolean save(Employee obj) {
		Transaction tran = null;
		try (Session session = HibernateUtil.getSessionfactory().openSession()) {
			tran = session.beginTransaction();
//			System.out.println(obj.getId());
//			System.out.println(obj.getName());
//			System.out.println(obj.getEmail());
//			System.out.println(obj.getIddepartment());
			session.save(obj);
			tran.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			if (tran != null) {

				tran.rollback();
			}
			return false;
		}
	}

	public boolean edit(Employee obj) {
		Transaction tran = null;
		try (Session session = HibernateUtil.getSessionfactory().openSession()) {
			tran = session.beginTransaction();
			session.update(obj);
			tran.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			if (tran != null) {

				tran.rollback();
			}
			return false;
		}
	}

	public int delete(long id) {
		Transaction tran = null;
		try (Session session = HibernateUtil.getSessionfactory().openSession()) {
			tran = session.beginTransaction();
			Employee employee = find(id);
			session.delete(employee);
			tran.commit();
			return 1;
		} catch (Exception ex) {
			if (tran != null) {
				tran.rollback();
			}
			return 0;
		}
	}
}
