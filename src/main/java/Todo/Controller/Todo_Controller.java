package Todo.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Todo.Dao.Todo_Dao;
import Todo.Dto.Task;
import Todo.Dto.User_info;
import Todo.Service.Todo_Service;

@Controller
public class Todo_Controller {
	

	/*public String Signup(@RequestParam String name, @RequestParam String email, @RequestParam String password) {
		User_info info = new User_info();
		info.setEmail(email);
		info.setName(name);
		info.setPassword(password);*/

	//OR
	
	@Autowired
	Todo_Service service;
	
    @PostMapping("Signup")
		public String Signup(User_info info, ModelMap map) {
			return service.signup(info,map);
		}

    @PostMapping("Login")
    public String Login(@RequestParam String email,@RequestParam String password,ModelMap map,HttpSession session){
		return service.login(email,password,map,session);
    	
    }
    
    @PostMapping("addtask")
	public String addTask(Task task, @RequestParam String day, ModelMap model, HttpSession session) {
		return service.addTask(task, day, model, session);
	}

	@GetMapping("/changestatus")
	public String changeStatus(HttpSession session, ModelMap model, @RequestParam int id) {
		return service.changeStatus(session,model,id);
	}
	
	@GetMapping("/delete")
	public String deleteTask(HttpSession session, ModelMap model, @RequestParam int id) {
		return service.deleteTask(session,model,id);
	}
	
	@GetMapping("update")
	public String update(HttpSession session, ModelMap model, @RequestParam int id)
	{
		return service.update(session,model,id);
	}
	
	@PostMapping("updatetask")
	public String updateTask(Task task, @RequestParam String day, ModelMap model, HttpSession session) {
		return service.updateTask(task, day, model, session);
	}

	@GetMapping("/logout")
	public String logout(HttpSession session, ModelMap model) {
		session.invalidate();
		model.put("pass", "Logged out Success");
		return "Login.jsp";

	}
}
