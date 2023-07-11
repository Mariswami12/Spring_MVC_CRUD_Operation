package Todo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Todo.Dao.Todo_Dao;
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

			Todo_Dao dao = new Todo_Dao();
			return service.signup(info,map);
		}

    @PostMapping("Login")
    public String Login(@RequestParam String email,@RequestParam String password,ModelMap map){
		return service.login(email,password,map);
    	
    }
}
