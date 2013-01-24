/**
 * Product.java by lizhm
 * 版权所有
 */
package com.paidc.smgt.persist.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author lizhm
 *
 */
@MappedSuperclass
public class Product implements java.io.Serializable{

	private static final long serialVersionUID = 194333978100481624L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="uuid")
	private String id;
}
