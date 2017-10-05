package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pojo.Dep;
import com.pojo.Emp;

/**
 * ����һ�Զࣺ�����Զ��һ�����в���,������Ӳ��ţ������Ա��,
 * ʹ��Ա����Ӳ���
 * 2��SQL���
 * 1. ���벿��
 * 2. ����Ա��
 * @author SiVan
 *
 */
public class Test13 {
	
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
		dep.setDepId(1);
		dep.setDepName("������");
		session.save(dep);
		
		Emp emp = new Emp();
		emp.setEmpId(1);
		emp.setEmpName("������");
		emp.setDep(dep);
		session.save(emp);
		
		
		
		//�ύ����
		transaction.commit();
		//�ر�Session
		session.close();
		
		
		
	}

}
