package com.test;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.pojo.Dep;
import com.pojo.Emp;

/**
 * 测试一对多：这里以一的一方进行操作,首先添加员工，再添加部门,
 * 使用部门添加员工
 * 3条SQL语句
Hibernate: insert into emp (emp_name, depid, emp_id) values (?, ?, ?)
Hibernate: insert into dep (dep_name, dep_id) values (?, ?)
Hibernate: update emp set depid=? where emp_id=?

 * @author SiVan
 *
 */
public class Test16 {
	
	
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
		dep.setDepId(4);
		dep.setDepName("ddd");
		
		Emp emp = new Emp();
		emp.setEmpId(4);
		emp.setEmpName("wxw");
		dep.getEm().add(emp);
		session.save(emp);
		session.save(dep);
		
		
		//提交事务
		transaction.commit();
		//关闭Session
		session.close();
	}

}
