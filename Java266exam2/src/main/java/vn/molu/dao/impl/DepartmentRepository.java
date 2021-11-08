package vn.molu.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import vn.molu.dao.HibernateUtil;
import vn.molu.domain.Department;
import vn.molu.domain.User;

import vn.molu.utils.Helper;

public class DepartmentRepository {
	// get User
	public List<Department> findAll() {
		try (Session session = HibernateUtil.getSessionfactory().openSession()) {
			return session.createQuery("From Department").list();
		}
	}

	public Department find(long id) {
		try (Session session = HibernateUtil.getSessionfactory().openSession()) {
			return session.find(Department.class, id);
		}
	}



	// save Department
	public boolean save(Department obj) {
		Transaction tran = null;
		try (Session session = HibernateUtil.getSessionfactory().openSession()) {
			tran = session.beginTransaction();
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
	// edit Department
		public boolean edit(Department obj) {
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


	//delete User
	public int delete(long id) {
		Transaction tran = null;
		try (Session session = HibernateUtil.getSessionfactory().openSession()) {
			tran = session.beginTransaction();
			Department obj = find(id);
			session.delete(obj);
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