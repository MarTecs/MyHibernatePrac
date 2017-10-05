package com.test;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.pojo.Dep;
import com.pojo.Emp;

/**
 * ����һ�Զࣺ������һ��һ�����в���,�������Ա��������Ӳ���,
 * ʹ�ò������Ա��
 * 3��SQL���
Hibernate: insert into emp (emp_name, depid, emp_id) values (?, ?, ?)
Hibernate: insert into dep (dep_name, dep_id) values (?, ?)
Hibernate: update emp set depid=? where emp_id=?

 * @author SiVan
 *
 */
public class Test16 {
	
	
	public static void main(String[] args) {
		
		
		
		//���ȶ�ȡ�������ļ�
		Configuration configuration = new Configuration().configure();
		
		//����SessionFactory
		SessionFactory factory = configuration.buildSessionFactory();
		
		//����Session
		Session session = factory.openSession();
		//��������
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
		
		
		//�ύ����
		transaction.commit();
		//�ر�Session
		session.close();
	}

}
