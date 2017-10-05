package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pojo.Dep;
import com.pojo.Emp;

/**
 * ����һ�Զࣺ������һ��һ�����в���,������Ӳ��ţ������Ա��,
 * ʹ�ò������Ա��
 * 3��SQL���
 * 	Hibernate: insert into dep (dep_name, dep_id) values (?, ?)
	Hibernate: insert into emp (emp_name, depid, emp_id) values (?, ?, ?)
 *	Hibernate: update emp set depid=? where emp_id=?
 * 
 * @author SiVan
 *
 */
public class Test14 {
	
	
	public static void main(String[] args) {
		
		//��ȡ�������ļ�
		Configuration configuration = new Configuration().configure();
		
		//����SessionFactory
		SessionFactory factory = configuration.buildSessionFactory();
		
		//����Session
		Session session = factory.openSession();
		
		//��������
		Transaction transaction = session.beginTransaction();
		
		Dep dep = new Dep();
		dep.setDepId(2);
		dep.setDepName("�Ƽ���");
		
		session.save(dep);
		
		Emp emp = new Emp();
		emp.setEmpId(2);
		emp.setEmpName("wxw");
		dep.getEm().add(emp);
		session.save(emp);
		
		
		//�ύ����
		transaction.commit();
		
		//�ر�session
		session.close();
		
		
		
		
	}

}
