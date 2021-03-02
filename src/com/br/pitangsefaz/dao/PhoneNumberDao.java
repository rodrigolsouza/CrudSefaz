package com.br.pitangsefaz.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.br.pitangsefaz.model.*;
import com.br.pitangsefaz.util.*;

public class PhoneNumberDao {

	@SuppressWarnings("unchecked")
	public List<PhoneNumber> getByUserId(int userId) {

		Transaction transaction = null;
		List<PhoneNumber> phoneNumbers = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			phoneNumbers = session.createQuery("FROM PhoneNumber WHERE user_id = :user_id")
					.setParameter("user_id", userId).getResultList();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return phoneNumbers;
	}

	public void save(PhoneNumber phoneNumber) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(phoneNumber);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public void delete(int id) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			PhoneNumber phoneNumber = session.get(PhoneNumber.class, id);
			if (phoneNumber != null) {
				session.delete(phoneNumber);
				System.out.println("Number deleted.");
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public PhoneNumber get(int id) {

		Transaction transaction = null;
		PhoneNumber phoneNumber = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			phoneNumber = session.get(PhoneNumber.class, id);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return phoneNumber;
	}

	public void update(PhoneNumber phoneNumber) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.update(phoneNumber);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

}
