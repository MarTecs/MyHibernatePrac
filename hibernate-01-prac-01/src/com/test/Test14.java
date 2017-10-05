package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pojo.Dep;
import com.pojo.Emp;

/**
 * 测试一对多：这里以一的一方进行操作,首先添加部门，再添加员工,
 * 使用部门添加员工
 * 3条SQL语句
 * 	Hibernate: insert into dep (dep_name, dep_id) values (?, ?)
	Hibernate: insert into emp (emp_name, depid, emp_id) values (?, ?, ?)
 *	Hibernate: update emp set depid=? where emp_id=?
 * 
 * @author SiVan
 *
 */
public class Test14 {
	
	
	public static void main(String[] args) {
		
		//读取总配置文件
		Configuration configuration = new Configuration().configure();
		
		//创建SessionFactory
		SessionFactory factory = configuration.buildSessionFactory();
		
		//创建Session
		Session session = factory.openSession();
		
		//创建事务
		Transaction transaction = session.beginTransaction();
		
		Dep dep = new Dep();
		dep.setDepId(2);
		dep.setDepName("科技部");
		
		session.save(dep);
		
		Emp emp = new Emp();
		emp.setEmpId(2);
		emp.setEmpName("wxw");
		dep.getEm().add(emp);
		session.save(emp);
		
		
		//提交事务
		transaction.commit();
		
		//关闭session
		session.close();
		
		
		
		
	}

}
