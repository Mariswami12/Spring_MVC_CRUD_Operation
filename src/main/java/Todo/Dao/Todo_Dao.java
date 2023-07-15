package Todo.Dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import Todo.Dto.Task;
import Todo.Dto.User_info;
@Component
public class Todo_Dao {
	
	@Autowired
	EntityManager manager;

public void save (User_info info){
	
//	try{
//		manager.getTransaction().begin();
//		manager.persist(info);
//		manager.getTransaction().commit();
//		return true;
//	}
//	catch (Exception e){
//		manager.getTransaction().commit();
//		return false;
//	}
	
	manager.getTransaction().begin();
	manager.persist(info);
	manager.getTransaction().commit();
	
}


public User_info findByEmail(String email) {
	List<User_info> list=manager.createQuery("select x from User_info x where email=?1").setParameter(1, email).getResultList();
	if(list.isEmpty())
	return null;
	else
		return list.get(0);
	
}

public void save(Task task) {
	manager.getTransaction().begin();
	manager.persist(task);
	manager.getTransaction().commit();
}

public Task findById(int id) {
	return manager.find(Task.class, id);
}

public void update(Task task) {
	manager.getTransaction().begin();
	manager.merge(task);
	manager.getTransaction().commit();
}

public void delete(Task task) {
	manager.getTransaction().begin();
	manager.remove(task);
	manager.getTransaction().commit();
}

public void update(User_info info) {
	manager.getTransaction().begin();
	manager.merge(info);
	manager.getTransaction().commit();
}

}
