package de.hrw.dbprog.carrent.dblayer.configuration;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
/**
 * Carrent db-layer.
 *
 * @author Bjoern Antonio Makowe <bm-132189@hs-weingarten.de>
 */
@Configuration
@EnableTransactionManagement
public class DatabaseConfiguration {

	/**
	 * Gets the entity manager factory.
	 *
	 * @return the entity manager factory
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean getEntityManagerFactory() {

		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(getDataSource());
		emf.setPackagesToScan("de.hrw.dbprog.carrent.dblayer.model");

		JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		emf.setJpaVendorAdapter(adapter);
		emf.setJpaProperties(getProperties());

		return emf;
	}

	/**
	 * Gets the data source.
	 *
	 * @return the data source
	 */
	@Bean
	public DataSource getDataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://universe.dnshome.de:3306/rentsystem");
		dataSource.setUsername("rentsystem");
		dataSource.setPassword("TuuG7MZmS8RFidoyCsOg");

		return dataSource;
	}

	/**
	 * Gets the properties.
	 *
	 * @return the properties
	 */
	private Properties getProperties() {
		Properties props = new Properties();
		props.setProperty("hibernate.hbm2ddl.auto", "none");
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		props.setProperty("hibernate.show_sql", "false");

		return props;
	}

	/**
	 * Gets the transaction manager.
	 *
	 * @param emf the emf
	 * @return the transaction manager
	 */
	@Bean
	public PlatformTransactionManager getTransactionManager(EntityManagerFactory emf) {
		JpaTransactionManager manager = new JpaTransactionManager();
		manager.setEntityManagerFactory(emf);

		return manager;
	}

	/**
	 * Gets the post processor.
	 *
	 * @return the post processor
	 */
	@Bean
	public PersistenceExceptionTranslationPostProcessor getPostProcessor() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
}
