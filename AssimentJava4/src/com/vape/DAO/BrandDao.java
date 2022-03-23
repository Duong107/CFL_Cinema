package com.vape.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.vape.Util.DaoUtil;
import com.vape.entity.Brand;
import com.vape.entity.Users;

public class BrandDao extends DaoUtil<Brand, Integer> {
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
	public void insert(Brand entity) {
		EntityManager em = getE();
		if (em != null) {
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
	public void update(Brand entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer key) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Brand> selectAll() {
		emf = Persistence.createEntityManagerFactory("ASMJV4");
		EntityManager em = emf.createEntityManager();
		List<Brand> list = null;
		try {
			em.getTransaction().begin();
			String jpql = "SELECT o FROM Brand o";
			TypedQuery<Brand> query = em.createQuery(jpql, Brand.class);
			list = query.getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
//			em.getTransaction().rollback();
		}
		em.close();
		emf.close();
		return list;
	}

	@Override
	public List<Brand> selectPage(int x) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Brand selectById(Integer key) {
		emf = Persistence.createEntityManagerFactory("ASMJV4");
		EntityManager em = emf.createEntityManager();
		Brand user = null;
		try {
			em.getTransaction().begin();
			String jpql = "SELECT o FROM Brand o WHERE o.id=:id";
			TypedQuery<Brand> query = em.createQuery(jpql, Brand.class);
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

	@Override
	protected List<Brand> selectBySql(String sql, Object... args) {
		// TODO Auto-generated method stub
		return null;
	}

}
