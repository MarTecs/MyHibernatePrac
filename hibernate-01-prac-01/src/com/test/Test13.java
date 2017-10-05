package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pojo.Dep;
import com.pojo.Emp;

/**
 * 测试一对多：这里以多的一方进行操作,首先添加部门，再添加员工,
 * 使用员工添加部门
 * 2条SQL语句
 * 1. 插入部门
 * 2. 插入员工
 * @author SiVan
 *
 */
public class Test13 {
	
	public static void main(String[] args) {
		
		//首先读取总配置文件
		Configuration configuration = new Configuration().configure();
		
		//创建SessionFactory
		SessionFactory factory = configuration.buildSessionFactory();
		
		//创建Session
		Session session = factory.openSession();
		
		//开启事务
		Transaction transaction = session.beginTransaction();
		
		Dep dep = new Dep();
		dep.setDepId(1);
		dep.setDepName("国防部");
		session.save(dep);
		
		Emp emp = new Emp();
		emp.setEmpId(1);
		emp.setEmpName("吴晓文");
		emp.setDep(dep);
		session.save(emp);
		
		
		
		//提交事务
		transaction.commit();
		//关闭Session
		session.close();
		
		
		
	}

}
