package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pojo.Dep;

/**
 * 测试增删改查,使用部门表
 * @author SiVan
 *
 */

public class Test2 {
	
	public static void main(String[] args) {
		
		//读取总配置文件
		Configuration configuration = new Configuration().configure();
		
		//创建SessionFactory
		SessionFactory factory = configuration.buildSessionFactory();
		
		//创建Session
		Session session = factory.openSession();
		
		//开启事务
		Transaction transaction = session.beginTransaction();
		
		Dep dep = new Dep();
		dep.setDepName("国防部");
		dep.setDepId(1);
		session.save(dep);
		transaction.commit();
		
		
		//根据主键值为1的进行查找
		Dep dep2 = (Dep) session.get(Dep.class, 1);
		System.out.println("查询成功：" + dep2.getDepId() + "\t" + dep2.getDepName() + "\t");
		
		dep2.setDepName("科技部");
		Dep dep3 = (Dep) session.get(Dep.class, 1);
		System.out.println("修改成功：" + dep3.getDepId() + "\t" + dep3.getDepName() + "\t");
		session.update(dep2);
		transaction.commit();
		
		session.delete(dep3);
		transaction.commit();
		Dep dep4 = (Dep) session.get(Dep.class, 1);
		if(dep4 == null)
			System.out.println("删除成功");
		
	}

}
