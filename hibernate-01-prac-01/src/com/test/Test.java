package com.test;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * ʹ�ø�ʵ���������������Ӧ�����ű��
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
