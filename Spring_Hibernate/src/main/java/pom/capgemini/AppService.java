package pom.capgemini;

import org.hibernate.SessionFactory;
import org.hibernate.Session;

import javax.sql.DataSource;

public class AppService {
    private DataSource dataSource;
    private SessionFactory sessionFactory;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void testConnection() {
        try {
            if (dataSource != null && dataSource.getConnection() != null) {
                System.out.println("PostgreSQL connection test successful!");
                dataSource.getConnection().close();
            }
        } catch (Exception e) {
            System.out.println("PostgreSQL connection test failed: " + e.getMessage());
        }
    }

    public void testHibernateConnection() {
        try {
            if (sessionFactory != null) {
                Session session = sessionFactory.openSession();
                System.out.println("Hibernate SessionFactory connection test successful!");
                session.close();
            }
        } catch (Exception e) {
            System.out.println("Hibernate connection test failed: " + e.getMessage());
        }
    }
}

