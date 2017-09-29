package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.util.HibernateFactoryUtil;

/**
 * 根据类的关系来生成表格
 * @author SiVan
 *
 */
public class Test {
	
	
	public static void main(String[] args) {
		
		
		Configuration configuration = new Configuration().configure();
		SchemaExport export = new SchemaExport(configuration);
		export.create(true, true);

		
		
	}
	
	

}
