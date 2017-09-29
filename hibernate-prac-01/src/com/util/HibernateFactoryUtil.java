package com.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateFactoryUtil {
	
	private static SessionFactory factory;
	
	static {
		factory = new Configuration().configure().buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory() {
		return factory;
	}

}
