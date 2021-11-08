package vn.molu.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import vn.molu.dao.HibernateUtil;

import vn.molu.domain.User;

import vn.molu.utils.Helper;

public class UserRepository {
	// get User
	public List<User> findAll() {
		try (Session session = HibernateUtil.getSessionfactory().openSession()) {
			return session.createQuery("From User").list();
		}
	}

	
	public User logOn(String username) {
		try (Session session = HibernateUtil.getSessionfactory().openSession()) {
			
			User user = session.find(User.class, username);
			return user;

		}

	}

	// save User
	public boolean save(User obj) {
		Transaction tran = null;
		System.out.println(obj.getUsername());
		obj.setRole("ROLE_USER");
		obj.setPassword(Helper.bcrypt(obj.getPassword()));
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

	//	edit
	public boolean edit(User obj) {
		
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
//	edit
	public boolean delete(String username) {
		
		Transaction tran = null;
		try (Session session = HibernateUtil.getSessionfactory().openSession()) {
			tran = session.beginTransaction();
			session.delete(logOn(username));
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
}
