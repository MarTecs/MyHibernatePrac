package com.test;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * 使用该实例创建两张与其对应的两张表格
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
