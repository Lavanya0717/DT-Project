package com.niit.bokayflorist.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class indexController {

	@RequestMapping("/")
	public String index(){
		return "index";
	}
	
	/*@RequestMapping("/home")
	public String home(){
		return "home";
	}
	
	@RequestMapping("/supplierManage")
	public String supplierManage(){
		return "supplierManage";
	}
	@RequestMapping("/addSupplier")
	public String addSupplier(){
		return "supplierManage";
	}*/
	
	@RequestMapping("403Error")
	public String Error(){
		return "403";
	}
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


	

