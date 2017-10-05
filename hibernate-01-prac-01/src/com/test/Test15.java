package com.test;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.pojo.Dep;
import com.pojo.Emp;

/**
 * 测试一对多：这里以多的一方进行操作,首先添加员工，再添加部门,
 * 使用员工添加部门
 * 4条SQL语句
Hibernate: select dep_.dep_id, dep_.dep_name as dep2_0_ from dep dep_ where dep_.dep_id=?
Hibernate: insert into emp (emp_name, depid, emp_id) values (?, ?, ?)
Hibernate: insert into dep (dep_name, dep_id) values (?, ?)
Hibernate: update emp set emp_name=?, depid=? where emp_id=?

 * @author SiVan
 *
 */
public class Test15 {
	
	
	
	public static void main(String[] args) {
		
		//读取总配置文件
		Configuration configuration = new Configuration().configure();
		
		
		//创建一个SessionFactory
		SessionFactory factory = configuration.buildSessionFactory();
		
		//创建一个Session
		Session session = factory.openSession();
		
		//开启事务
		Transaction transaction = session.beginTransaction();
		
		Dep dep = new Dep();
		dep.setDepId(3);
		dep.setDepName("武装部");
		
		
		Emp emp = new Emp();
		emp.setEmpId(3);
		emp.setEmpName("wxw");
		emp.setDep(dep);
		session.save(emp);
		session.save(dep);
		
		//提交事务
		transaction.commit();
		//关闭SessIon
		session.close();
		
		
	}
	
	
	

}
