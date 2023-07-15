package Todo.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import Todo.Dao.Todo_Dao;
import Todo.Dto.Task;
import Todo.Dto.User_info;

@Component
public class Todo_Service {

	@Autowired
	Todo_Dao dao;

	public String signup(User_info info, ModelMap map) {	
		if(dao.findByEmail(info.getEmail())==null){
		dao.save(info);
		map.put("pass", "Account created successfully");
		return "Login.jsp";
	}
		else{
			map.put("fail", "Email you entered already exist, should be unique");
			return "Signup.jsp";
		}
	}

	public String login(String email, String password, ModelMap map,HttpSession session) {
		User_info info=dao.findByEmail(email);
		if(info==null){
			map.put("fail", "Incorrect Email");
			return "Login.jsp";
		}
		else{
			if(info.getPassword().equals(password))
			{
				
				session.setAttribute("user_info", info);
				List<Task> list=info.getTasks();
				if(list==null)
				{
					list=new ArrayList<Task>();
				}
				map.put("list", list);
			map.put("pass", "Login success");
			return "Todo_Home.jsp";
		}
			else{
				map.put("fail", "Incorrect password");
				return "Login.jsp";
			}
		}
    }
	public String addTask(Task task, String day, ModelMap model, HttpSession session) {
		task.setDate(LocalDate.parse(day));
		User_info info = (User_info) session.getAttribute("userInfo");
		if(info==null)
		{
			model.put("fail", "Invalid Session");
			return "Login.jsp";
		}
		else {
		dao.save(task);
		List<Task> list=info.getTasks();
	
		if(list==null)
		list=new ArrayList<Task>();
			
		list.add(task);
		info.setTasks(list);
		
		dao.save(info);
		
		model.put("pass", "Task Added Success");
		model.put("list", info.getTasks());
		return "TodoHome.jsp";
		}
	}

	public String changeStatus(HttpSession session, ModelMap model, int id) {
		User_info info = (User_info) session.getAttribute("userInfo");
		if(info==null)
		{
			model.put("fail", "Invalid Session");
			return "Login.jsp";
		}
		else {
			Task task=dao.findById(id);
			
			if(task.isStatus())
				task.setStatus(false);
			else
				task.setStatus(true);
			
			dao.update(task);
			
			model.put("pass", "Status Changed Success");
			model.put("list", info.getTasks());
			return "TodoHome.jsp";
		}
	}

	public String deleteTask(HttpSession session, ModelMap model, int id) {
		User_info info = (User_info) session.getAttribute("userInfo");
		if(info==null)
		{
			model.put("fail", "Invalid Session");
			return "Login.jsp";
		}
		else {
			Task task=dao.findById(id);
			info.getTasks().remove(task);
			dao.update(info);
			
			dao.delete(task);
			model.put("pass", "Task Deleted Success");
			model.put("list", info.getTasks());
			return "TodoHome.jsp";
			
		}
	}

	public String update(HttpSession session, ModelMap model, int id) {
		User_info info = (User_info) session.getAttribute("userInfo");
		if(info==null)
		{
			model.put("fail", "Invalid Session");
			return "Login.jsp";
		}
		else {
			Task task=dao.findById(id);
			model.put("task", task);
			return "Update.jsp";
			
		}
	}

	public String updateTask(Task task, String day, ModelMap map, HttpSession session) {
		task.setDate(LocalDate.parse(day));
		User_info info = (User_info) session.getAttribute("userInfo");
		if(info==null)
		{
			map.put("fail", "Invalid Session");
			return "Login.jsp";
		}
		else {
		dao.update(task);
		
		map.put("pass", "Task Updated Success");
		map.put("list", info.getTasks());
		return "Todo_Home.jsp";
	}
	}
}
