package Todo.Helper;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("Todo")
public class My_Configuration {
	
@Bean
public EntityManager getEntityManager(){
	return Persistence.createEntityManagerFactory("dev").createEntityManager();
}
}
