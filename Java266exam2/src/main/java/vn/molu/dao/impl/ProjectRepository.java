package vn.molu.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import vn.molu.dao.HibernateUtil;
import vn.molu.domain.Project;
import vn.molu.utils.Helper;

public class ProjectRepository {
	public List<Project> findAll() {
		try (Session session = HibernateUtil.getSessionfactory().openSession()) {
			return session.createQuery("From Project").list();
		}
	}

	public Project find(long id) {
		try (Session session = HibernateUtil.getSessionfactory().openSession()) {
			return session.find(Project.class, id);
		}
	}

	public boolean save(Project obj) {
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

	public boolean edit(Project obj) {
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
			Project project = find(id);
			session.delete(project);
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
