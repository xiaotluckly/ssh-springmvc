package cn.ibeans.web.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import cn.ibeans.service.UserService;
import cn.ibeans.web.model.User;

@Controller
@RequestMapping(value="/user")
public class LoginController extends HttpServlet{
	private static Logger log = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private UserService userService;
	

	//@RequestMapping(value="/login")	//如果类级别上已有映射地址（/user），此处的完整请求地址是/user/login
	public String doLogin(Model model,Object loginForm){
		//model.addAttribute("username",username);	//model被用来封装数据，向前台传递
		WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
		ServletContext sc = context.getServletContext();
		
		return "/welcome";
	}
	
	@RequestMapping(value="/login")
	public String login(@ModelAttribute User user,Model model){
		log.info(user.getUsername());
		model.addAttribute(user);
		
		return "/welcome";
	}
	
	@RequestMapping(value="/save")
	public String save(@ModelAttribute User user,Model model){
		log.info(user.getUsername());
		userService.saveUser(user);
		model.addAttribute(user);
		return "/welcome";
	}
	
	@RequestMapping(value="/query")
	@ResponseBody
	public User query(@ModelAttribute User user){
		log.info("query:"+user.getId());
		User queryUser=userService.queryUser(user.getId());
		log.info("queryUser:"+queryUser.getUsername());
		return queryUser;
		
	}
}
