package Todo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import Todo.Dao.Todo_Dao;
import Todo.Dto.User_info;

@Component
public class Todo_Service {

	@Autowired
	Todo_Dao dao;

	public String signup(User_info info, ModelMap map) {
		
//		if(dao.save(info)){
//		map.put("pass", "Account is Created Successfully");
//		return "Login.jsp" ;
//		}
//		else{
//			map.put("fail", "Email you entered already exist, should be unique");
//			return "Signup.jsp";
//		}
//		
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

	public String login(String email, String password, ModelMap map) {
		User_info info=dao.findByEmail(email);
		if(info==null){
			map.put("fail", "Incorrect Email");
			return "Login.jsp";
		}
		else{
			if(info.getPassword().equals(password))
			{
			map.put("pass", "Login success");
			return "Todo_Home.jsp";
		}
			else{
				map.put("fail", "Incorrect password");
				return "Login.jsp";
			}
		}
    }
}
