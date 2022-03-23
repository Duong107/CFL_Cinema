package com.vape.DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.vape.Util.DaoUtil;
import com.vape.entity.Users;

public class UserDao extends DaoUtil<Users, String> {

	private static EntityManagerFactory emf;

	@Override
	public void insert(Users entity) {
		emf = Persistence.createEntityManagerFactory("ASMJV4");
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
			System.out.println("Them moi thanh cong!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			System.out.println("Them moi that bai!");
		}	
		em.close();
		emf.close();
	}
	
	public static void sinsert(Users entity) {
		emf = Persistence.createEntityManagerFactory("ASMJV4");
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
			System.out.println("Them moi thanh cong!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			System.out.println("Them moi that bai!");
		}
		em.close();
		emf.close();
	}
	
	public static void main(String[] args) {
		sinsert(new Users("s"));
	}
	@Override
	public void update(Users entity) {
		emf = Persistence.createEntityManagerFactory("ASMJV4");
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
			System.out.println("update");
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		em.close();
		emf.close();

	}

	@Override
	public void delete(String key) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Users> selectAll() {
		emf = Persistence.createEntityManagerFactory("ASMJV4");
		EntityManager em = emf.createEntityManager();
		List<Users> list = null;
		try {
			em.getTransaction().begin();
			String jpql = "SELECT o FROM nguoidung o";
			TypedQuery<Users> query = em.createQuery(jpql, Users.class);
			list = query.getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		em.close();
		emf.close();
		return list;
	}

	public static List<Users> selectAsll() {
		EntityManager em = getE();
		List<Users> list = null;
		try {
			em.getTransaction().begin();
			String jpql = "SELECT o FROM nguoidung o";
			TypedQuery<Users> query = em.createQuery(jpql, Users.class);
			list = query.getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		em.close();
		emf.close();
		return list;
	}

	private static EntityManager getE() {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("ASMJV4");
			return emf.createEntityManager();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Users> selectPage(int x) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users selectById(String key) {
		EntityManager em = getE();
		Users user = null;
		try {
			em.getTransaction().begin();
			String jpql = "SELECT o FROM Users o WHERE o.id=:id";
			TypedQuery<Users> query = em.createQuery(jpql, Users.class);
			query.setParameter("id", key);
			user = query.getSingleResult();
			em.getTransaction().commit();
			return user;
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		em.close();
		emf.close();
		return user;
	}

	public Users selectByd(String Username, String pas) {
		EntityManager em = getE();
		Users user = null;
		try {
			em.getTransaction().begin();
			String jpql = "SELECT o FROM Users o WHERE o.id=:id AND o.password=:pw";
			TypedQuery<Users> query = em.createQuery(jpql, Users.class);
			query.setParameter("id", Username);
			query.setParameter("pw", pas);
			user = query.getSingleResult();
			em.getTransaction().commit();
			return user;
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		em.close();
		emf.close();
		return user;
	}

	@Override
	protected List<Users> selectBySql(String sql, Object... args) {
		// TODO Auto-generated method stub
		return null;
	}
}
