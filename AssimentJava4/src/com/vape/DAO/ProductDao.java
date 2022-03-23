package com.vape.DAO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.vape.Util.DaoUtil;
import com.vape.entity.*;

public class ProductDao extends DaoUtil<Product, Integer> {
	private static EntityManagerFactory emf;
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
	public void insert(Product entity) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ASMJV4");
		EntityManager em = emf.createEntityManager();
		if (em!=null) {
			try {
				em.getTransaction().begin();
				em.persist(entity);
				em.getTransaction().commit();
			} catch (Exception e) {
				em.getTransaction().rollback();
			}
		}
		em.close();
		emf.close();

	}
	
	@Override
	public void update(Product entity) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ASMJV4");
		EntityManager em = emf.createEntityManager();
		if (em!=null) {
			try {
				em.getTransaction().begin();
				em.merge(entity);
				em.getTransaction().commit();
			} catch (Exception e) {
				em.getTransaction().rollback();
			}
		}
		em.close();
		emf.close();

	}

	@Override
	public void delete(Integer key) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ASMJV4");
		EntityManager em = emf.createEntityManager();
		if (em!=null) {
			try {
				em.getTransaction().begin();
				em.remove(em.find(Product.class,key));
				em.getTransaction().commit();
			} catch (Exception e) {
				em.getTransaction().rollback();
			}
		}
		em.close();
		emf.close();
	}

	@Override
	public List<Product> selectAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ASMJV4");
		EntityManager em = emf.createEntityManager();
		List<Product> list = null;
		try {
			em.getTransaction().begin();
			String jpql = "SELECT o FROM Product o";
			TypedQuery<Product> query = em.createQuery(jpql, Product.class);
			list = query.getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		em.close();
		emf.close();
		return list;
	}
	@Override
	public List<Product> selectPage(int x) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product selectById(Integer key) {
		emf = Persistence.createEntityManagerFactory("ASMJV4");
		EntityManager em = emf.createEntityManager();
		Product xs = null;
		try {
			em.getTransaction().begin();
			xs = em.find(Product.class, key);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		em.close();
		emf.close();
		return xs;
	}

	@Override
	protected List<Product> selectBySql(String sql, Object... args) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Product> selectAlllike(String values) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ASMJV4");
		EntityManager em = emf.createEntityManager();
		List<Product> list = null;
		try {
			em.getTransaction().begin();
			String jpql = "SELECT o FROM Product o where o.name like :name";
			TypedQuery<Product> query = em.createQuery(jpql, Product.class);
			query.setParameter("name", "%"+values+"%");
			list = query.getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		em.close();
		emf.close();
		return list;
	}
	
}
