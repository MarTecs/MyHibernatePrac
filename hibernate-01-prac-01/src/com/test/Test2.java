package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pojo.Dep;

/**
 * ������ɾ�Ĳ�,ʹ�ò��ű�
 * @author SiVan
 *
 */

public class Test2 {
	
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
		dep.setDepName("������");
		dep.setDepId(1);
		session.save(dep);
		transaction.commit();
		
		
		//��������ֵΪ1�Ľ��в���
		Dep dep2 = (Dep) session.get(Dep.class, 1);
		System.out.println("��ѯ�ɹ���" + dep2.getDepId() + "\t" + dep2.getDepName() + "\t");
		
		dep2.setDepName("�Ƽ���");
		Dep dep3 = (Dep) session.get(Dep.class, 1);
		System.out.println("�޸ĳɹ���" + dep3.getDepId() + "\t" + dep3.getDepName() + "\t");
		session.update(dep2);
		transaction.commit();
		
		session.delete(dep3);
		transaction.commit();
		Dep dep4 = (Dep) session.get(Dep.class, 1);
		if(dep4 == null)
			System.out.println("ɾ���ɹ�");
		
	}

}
