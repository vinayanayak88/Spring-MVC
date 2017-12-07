package com.spring.mvc.persistence.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.xml.bind.JAXBException;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Vinaya Nayak
 * Jun 11, 2017
 * PersistenceConfig.java
 */	
@Configuration
@EnableAspectJAutoProxy
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManager",
transactionManagerRef = "transactionManager",basePackages = "com.spring.mvc.persistence.repository")
public class PersistenceConfig {
	
	 private static final Logger log = LoggerFactory.getLogger(PersistenceConfig.class);
	
	private static final String[] ENTITY_PACKAGES = {
            "com.spring.mvc.persistence.model"
    };
	
	 private static final String PROPERTY_NAME_DB_DRIVER_CLASS = "db.driver";
	    private static final String PROPERTY_NAME_DB_PASSWORD = "db.password";
	    private static final String PROPERTY_NAME_DB_URL = "db.url";
	    private static final String PROPERTY_NAME_DB_USER = "db.username";
	    private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
	    private static final String PROPERTY_NAME_HIBERNATE_FORMAT_SQL = "hibernate.format_sql";
	    private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
	    
	    
	    @Bean(destroyMethod = "close")
	    DataSource dataSource() throws JAXBException {
	    	  Properties props = loadProperties();
	    	DataSource dataSource = new DataSource();
	        dataSource.setDriverClassName(props.getProperty(PROPERTY_NAME_DB_DRIVER_CLASS));
	        dataSource.setUrl(props.getProperty(PROPERTY_NAME_DB_URL));
	        dataSource.setUsername(props.getProperty(PROPERTY_NAME_DB_USER));
	        dataSource.setPassword(props.getProperty(PROPERTY_NAME_DB_PASSWORD));
	        return dataSource;
	    }

	    /**
	     * Load the properties file from /application.properties if it doesnt exist then load it through classloader
	     * @return
	     */
		private Properties loadProperties() {
			String propertyFile = "/application.properties";  
	    	  File f = new File(propertyFile);
	    	    Properties props = new Properties();
	    	    InputStream is = null;
	    	    try{
	    	    	if(f.exists()){
	    	    		 is = new FileInputStream(f);
	    	    	}
	    	    	else{
	    	    		 is = this.getClass().getClassLoader().getResourceAsStream(propertyFile);
	    	    	}
	    	    	 props.load(is);
	    	    }
	    	    catch (Exception e) {
		    	      log.warn("error loading property file: " + propertyFile);
		    	    }
			return props;
		}
	    
	    /**
	     * Creates the bean that creates the JPA entity manager factory.
	     * @param dataSource    The datasource that provides the database connections.
	     * @param env           The runtime environment of  our application.
	     * @return
	     * @throws JAXBException 
	     */
		@Bean(name = "entityManager")
	    LocalContainerEntityManagerFactoryBean entityManagerFactory() throws JAXBException {
	        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
	        Properties props = loadProperties();
	        entityManagerFactoryBean.setDataSource(dataSource());
	        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
	        entityManagerFactoryBean.setPackagesToScan(ENTITY_PACKAGES);

	        Properties jpaProperties = new Properties();

	        //Configures the used database dialect. This allows Hibernate to create SQL
	        //that is optimized for the used database.
	        jpaProperties.put(PROPERTY_NAME_HIBERNATE_DIALECT, props.getProperty(PROPERTY_NAME_HIBERNATE_DIALECT));

	        //Specifies the action that is invoked to the database when the Hibernate
	        //SessionFactory is created or closed.
	       // jpaProperties.put(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO, props.getProperty(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO));

	        //If the value of this property is true, Hibernate writes all SQL
	        //statements to the console.
	        jpaProperties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL,props.getProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));

	        //If the value of this property is true, Hibernate will use prettyprint
	        //when it writes SQL to the console.
	        jpaProperties.put(PROPERTY_NAME_HIBERNATE_FORMAT_SQL, props.getProperty(PROPERTY_NAME_HIBERNATE_FORMAT_SQL));

	        entityManagerFactoryBean.setJpaProperties(jpaProperties);

	        return entityManagerFactoryBean;
	    }
	    
		 @Bean(name = "transactionManager")
	    JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) throws JAXBException {
	        JpaTransactionManager transactionManager = new JpaTransactionManager();
	        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
	        return transactionManager;
	    }

}
