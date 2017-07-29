package com.kpgn.indiasaysserver.server;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public abstract class BaseMySqlDBServer extends BaseDBServer {

	protected static SessionFactory factory;
	protected static Session session;

	@SuppressWarnings("deprecation")
	protected SessionFactory createFactory() {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		return factory;
	}

}