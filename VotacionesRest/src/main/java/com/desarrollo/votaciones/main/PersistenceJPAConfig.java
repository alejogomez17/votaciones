
package com.desarrollo.votaciones.main;

import com.desarrollo.votaciones.api.datos.dao.EleccionDaoImpl;
import java.util.Properties;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.desarrollo.votaciones.api.datos.dao.EleccionDao;
import com.desarrollo.votaciones.api.datos.dao.OpcionEleccionDao;
import com.desarrollo.votaciones.api.datos.dao.OpcionEleccionDaoImpl;
import com.desarrollo.votaciones.api.datos.dao.VotoDao;
import com.desarrollo.votaciones.api.datos.dao.VotoDaoImpl;
import com.desarrollo.votaciones.api.datos.dao.VotoOpcionEleccionDao;
import com.desarrollo.votaciones.api.datos.dao.VotoOpcionEleccionDaoImpl;
import com.desarrollo.votaciones.api.negocio.control.AdministradorEleccionesService;
import com.desarrollo.votaciones.api.negocio.control.AdministradorOpcionEleccionService;
import com.desarrollo.votaciones.api.negocio.control.AdministradorVotoService;
import com.desarrollo.votaciones.api.negocio.impl.AdministradorEleccionesServiceImpl;
import com.desarrollo.votaciones.api.negocio.impl.AdministradorOpcionEleccionServiceImpl;
import com.desarrollo.votaciones.api.negocio.impl.AdministradorVotoServiceImpl;

/**
 *
 * @author Alejo Gomez
 */
@Configuration
@EnableTransactionManagement
public class PersistenceJPAConfig {
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(new String[]{"com.desarrollo.votaciones.api.datos.dominio"});
        em.setPersistenceUnitName("PersistenceContext");
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalProperties());
        return em;
    }
    
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
//        dataSource.setUrl("jdbc:postgresql://35.192.168.203:5432/ogmios_prueba");
        dataSource.setUrl("jdbc:postgresql://34.66.246.14:5432/votacion");
        dataSource.setUsername("postgres");
        dataSource.setPassword("Arca852456");
        return dataSource;
    }
    
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

    Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        properties.setProperty("hibernate.temp.use_jdbc_metadata_defaults", "false");
        properties.setProperty("hibernate.format_sql", "true");
        properties.setProperty("hibernate.show_sql", "true");
        return properties;
    }
    
    @Bean
    public EleccionDao eleccionDaoImpl() {
        return new EleccionDaoImpl();
    }
    
    @Bean
    public OpcionEleccionDao opcionEleccionDaoImpl() {
        return new OpcionEleccionDaoImpl();
    }
    
    @Bean
    public VotoDao votoDaoImpl(){
        return new VotoDaoImpl();
    }
    
    @Bean
    public VotoOpcionEleccionDao votoOpcionEleccionDaoImpl(){
        return new VotoOpcionEleccionDaoImpl();
    }
    
    @Bean
    public AdministradorEleccionesService administradorEleccionesServiceImpl(){
        return new AdministradorEleccionesServiceImpl();
    }
    
    @Bean
    public AdministradorOpcionEleccionService administradorOpcionEleccionServiceImpl(){
        return new AdministradorOpcionEleccionServiceImpl();
    }
    
    @Bean
    public AdministradorVotoService administradorVotoServiceImpl(){
        return new AdministradorVotoServiceImpl();
    }

}
