package com.vape.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.vape.Util.DaoUtil;
import com.vape.entity.Brand;
import com.vape.entity.CartDetail;

public class CartDao extends DaoUtil<CartDetail, Integer>{
	private static EntityManagerFactory emf;

	@Override
	public void insert(CartDetail entity) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ASMJV4");
		EntityManager em = emf.createEntityManager();
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
	public void update(CartDetail entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CartDetail> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<CartDetail> selectAllbyuser(String key) {
		emf = Persistence.createEntityManagerFactory("ASMJV4");
		EntityManager em = emf.createEntityManager();
		List<CartDetail> list = null;
		try {
			em.getTransaction().begin();
			String jpql = "SELECT o FROM CartDetail o WHERE o.username like '"+key+"'";
			TypedQuery<CartDetail> query = em.createQuery(jpql, CartDetail.class);
			list = query.getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
		em.close();
		emf.close();
		return list;
	}


        	@Override
	public List<CartDetail> selectPage(int x) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartDetail selectById(Integer key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected List<CartDetail> selectBySql(String sql, Object... args) {
		// TODO Auto-generated method stub
		return null;
	}

}
