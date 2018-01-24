package com.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class indexController {

	@RequestMapping("/")
	public String index(){
		return "index";
	}
	
	
	
	
	
	
	/*@Autowired
	 private UserDao userDao;
	
	 @RequestMapping(value={"/","/home","/index"})
	    public ModelAndView index() {
	        //mapped to hostname:port/home/index/
		 ModelAndView mv=new ModelAndView("index");
		 mv.addObject("users",userDao.list());		 		 
	        return mv;
	    }*/
}

	

