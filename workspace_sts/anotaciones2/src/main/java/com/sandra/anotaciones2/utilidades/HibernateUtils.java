package com.sandra.anotaciones2.utilidades;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	
	static SessionFactory sessionFactory;
	static Session session;
	
	public static boolean openSession(){
		sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		return session.isOpen();
	}
	
	public static boolean closeSession(){
		try {
			if (sessionFactory.isOpen()) sessionFactory.close();
			if (session.isOpen()) session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static <T> List<T> getListaObjetosDeprecated(String clase) {
		return session.createQuery("from "+clase).list();
	}
	
	public static <T> List<T> getListaObjetos(Class<T> clase) {
		return session.createSelectionQuery("from "+clase.getSimpleName(), clase).list();
	}
	
	public static <T> boolean addObjetoDeprecated(T objeto) {
		try {
			Transaction trans = session.beginTransaction();
			session.save(objeto);
			trans.commit();
			session.clear();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static <T> boolean addObjeto(T objeto) {
		Transaction trans = null;
		try {
			trans = session.beginTransaction();
			session.persist(objeto);
			trans.commit();
			session.clear();
			return true;
		} catch (Exception e) {
			trans.rollback();
			return false;
		}
	}
	
	public static <T> boolean updateObjetoDeprecated(Class<T> clase, String where, T datos) {
		Transaction trans = null;
		try {
			List<T> resultados = session.createQuery("from "+clase.getSimpleName()+" where "+where).list();
			trans = session.beginTransaction();
			Arrays.asList(clase.getDeclaredFields()).forEach(atr->{
				resultados.forEach(r->{
					atr.setAccessible(true);
					try {
						if (atr.get(datos)!=null && !Modifier.isStatic(atr.getModifiers())) atr.set(r, atr.get(datos));
					} catch (IllegalArgumentException | IllegalAccessException e) {
						e.printStackTrace();
					}
					atr.setAccessible(false);
				});
			});
			resultados.forEach(e->session.update(e));
			trans.commit();
			session.clear();
			return true;
		} catch (Exception e) {
			trans.rollback();
			return false;
		}
	}
	
	public static <T> boolean updateObjeto(Class<T> clase, String where, T datos) {
		Transaction trans = null;
		try {
			List<T> resultados = session.createSelectionQuery("from "+clase.getSimpleName()+" where "+where, clase).list();
			trans = session.beginTransaction();
			Arrays.asList(clase.getDeclaredFields()).forEach(atr->{
				resultados.forEach(r->{
					atr.setAccessible(true);
					try {
						if (atr.get(datos)!=null && !Modifier.isStatic(atr.getModifiers())) atr.set(r, atr.get(datos));
					} catch (IllegalArgumentException | IllegalAccessException e) {
						e.printStackTrace();
					}
					atr.setAccessible(false);
				});
			});
			resultados.forEach(e->session.merge(e));
			trans.commit();
			session.clear();
			return true;
		} catch (Exception e) {
			trans.rollback();
			return false;
		}
	}
	
	public static <T> boolean deleteObjeto(T objeto) {
		Transaction trans = null;
		try {
			trans = session.beginTransaction();
			session.persist(objeto);
			trans.commit();
			session.clear();
			return true;
		} catch (Exception e) {
			trans.rollback();
			return false;
		}
	}
	
	public static <T> int deleteObjetoDeprecated(String clase, String where) {
		Transaction trans = null;
		try {
			List<T> resultados = session.createQuery("from "+clase+" where "+where).list();
			trans = session.beginTransaction();
			resultados.forEach(e->session.delete(e));
			trans.commit();
			session.clear();
			return resultados.size();
		} catch (Exception e) {
			trans.rollback();
			return -1;
		}
	}
	
	public static <T> int deleteObjeto(Class<T> clase, String where) {
		Transaction trans = null;
		try {
			List<T> resultados = session.createSelectionQuery("from "+clase.getSimpleName()+" where "+where, clase).list();
			trans = session.beginTransaction();
			resultados.forEach(e->session.remove(e));
			trans.commit();
			session.clear();
			return resultados.size();
		} catch (Exception e) {
			trans.rollback();
			return -1;
		}
	}
	
}
