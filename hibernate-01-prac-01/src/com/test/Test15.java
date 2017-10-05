package com.test;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.pojo.Dep;
import com.pojo.Emp;

/**
 * ����һ�Զࣺ�����Զ��һ�����в���,�������Ա��������Ӳ���,
 * ʹ��Ա����Ӳ���
 * 4��SQL���
Hibernate: select dep_.dep_id, dep_.dep_name as dep2_0_ from dep dep_ where dep_.dep_id=?
Hibernate: insert into emp (emp_name, depid, emp_id) values (?, ?, ?)
Hibernate: insert into dep (dep_name, dep_id) values (?, ?)
Hibernate: update emp set emp_name=?, depid=? where emp_id=?

 * @author SiVan
 *
 */
public class Test15 {
	
	
	
	public static void main(String[] args) {
		
		//��ȡ�������ļ�
		Configuration configuration = new Configuration().configure();
		
		
		//����һ��SessionFactory
		SessionFactory factory = configuration.buildSessionFactory();
		
		//����һ��Session
		Session session = factory.openSession();
		
		//��������
		Transaction transaction = session.beginTransaction();
		
		Dep dep = new Dep();
		dep.setDepId(3);
		dep.setDepName("��װ��");
		
		
		Emp emp = new Emp();
		emp.setEmpId(3);
		emp.setEmpName("wxw");
		emp.setDep(dep);
		session.save(emp);
		session.save(dep);
		
		//�ύ����
		transaction.commit();
		//�ر�SessIon
		session.close();
		
		
	}
	
	
	

}
