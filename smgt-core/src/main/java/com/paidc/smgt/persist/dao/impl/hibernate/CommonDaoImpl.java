package com.paidc.smgt.persist.dao.impl.hibernate;

import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.paidc.smgt.persist.dao.ICommonDao;

public class CommonDaoImpl<E, K extends java.io.Serializable> implements ICommonDao<E, K> {
	private final Class<E> entityClass;
	private String entityName;

	@SuppressWarnings("unchecked")
	public CommonDaoImpl() {
		this.entityClass = (Class<E>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		this.entityName = this.entityClass.getSimpleName();
	}

	// 默认按 名称 注入 SessionFactory
	@Resource
	private SessionFactory sessionFactory;
	/**
	 * 取得Hibernate session。
	 * 事务必须是开启的，否则获取不到
	 * @return
	 */
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void save(E e) {
		getSession().save(e);
	}

	@Override
	public void update(E e) {
		getSession().update(e);
	}

	@Override
	public void delete(E e) {
		getSession().delete(e);
	}

	@Override
	public void saveOrUpdate(E e) {
		getSession().saveOrUpdate(e);
	}

	@SuppressWarnings("unchecked")
	@Override
	public E getById(K id) {
		return (E) getSession().get(entityClass, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public E loadById(K id) {
		return (E) getSession().load(entityClass, id);
	}
	
	public Class<E> getEntityClass() {
		return entityClass;
	}
	public String getEntityName() {
		return entityName;
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
