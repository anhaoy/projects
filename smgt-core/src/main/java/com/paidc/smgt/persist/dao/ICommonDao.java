package com.paidc.smgt.persist.dao;

public interface ICommonDao<E, K extends java.io.Serializable> {
	/**
	 * 保存实体对象
	 * @param e
	 */
	public void save (E e);
	/**
	 * 更新实体对象
	 * @param e
	 */
	public void update(E e);
	/**
	 * 删除
	 * @param e
	 */
	public void delete(E e);
	/**
	 * 保存实体对象
	 * @param e
	 */
	public void saveOrUpdate(E e);
	/**
	 * 根据ID加载实体对象
	 * @param id
	 * @return 如果对象不存在，返回 NULL
	 */
	public E getById(K id);
	/**
	 * 根据ID加载实体对象
	 * @param id
	 * @return 实体对象
	 * @throws 如果实体对象不存在，底层实现会RuntimeException的子类
	 */
	public E loadById(K id);
}
