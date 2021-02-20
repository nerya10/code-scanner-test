package rib.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import rib.entity.Address;
import rib.util.HibernateUtils;

public class AddressDao implements EntityDao<Address, Integer>{
	private Session session = HibernateUtils.getSessionFactory().getCurrentSession();

	private Transaction transaction;

	public AddressDao() {
	}

	public Session openCurrentSession() {
		session = HibernateUtils.getSessionFactory().openSession();
		return session;
	}

	public Session openCurrentSessionwithTransaction() {
		session = HibernateUtils.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		return session;
	}

	public void closeCurrentSession() {
		session.close();
	}

	public void closeCurrentSessionwithTransaction() {
		transaction.commit();
		session.close();
	}


	@Override
	public Address findByNo(int no) {
		return session.get(Address.class, no);
	}

	@Override
	public void delete(Address entity) {
		session.delete(entity);
	}

	@Override
	public void deleteAll() {
		session.createQuery("delete from Address").executeUpdate();
	}

	@Override
	public List<Address> orderByCityAsc() {
		return session.createQuery("FROM Address order by city asc", Address.class).list();
	}

	@Override
	public List<Address> orderByCityDesc() {
		return session.createQuery("FROM Address order by city desc", Address.class).list();
	}
	
	public List<Address> orderByCountyAsc(){
		return session.createQuery("FROM Address order by county asc", Address.class).list();
	}
	
	public List<Address> orderByCountyDesc(){
		return session.createQuery("FROM Address order by county desc", Address.class).list();
	}

	@Override
	public List<Address> orderByNoAsc() {
		return session.createQuery("FROM Address order by No asc", Address.class).list();
	}

	@Override
	public List<Address> orderByNoDesc() {
		return session.createQuery("FROM Address order by No desc", Address.class).list();
	}

	@Override
	public void persist(Address entity) {
		session.save(entity);
	}

	@Override
	public List<Address> showAll() {
		return session.createQuery("from Address", Address.class).list();
	}

	@Override
	public void update(Address entity) {
		session.saveOrUpdate(entity);
	}
}