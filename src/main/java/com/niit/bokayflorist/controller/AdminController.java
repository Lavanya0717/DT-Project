package com.niit.bokayflorist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Dao.CategoryDAO;
import com.Dao.SupplierDao;
import com.Model.Category;
import com.Model.Supplier;

@Controller
public class AdminController {
	@Autowired
	Category category;
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	Supplier supplier;

	@Autowired
	SupplierDao supplierDAO;

	@RequestMapping("/home")
	public String Home(){
		return "home";
	}
	
	@RequestMapping("/adminAdding")
	public String adminAdding(){
		return "adminAdding";
	}
	
	@RequestMapping("/viewDetailsAdmin")
	public ModelAndView viewDetailsAdmin(){
		ModelAndView m=new ModelAndView("viewDetailsAdmin");
		List<Supplier> supList=supplierDAO.getAllSupplier();
		m.addObject("supList",supList);
		List<Category> catList=categoryDAO.getAllCategory();
		m.addObject("catList",catList);
		return m;
	}

	
	@RequestMapping("/addCategory")
	public String addCategory(@RequestParam String name) {
		category.setCid(0);
		category.setCategoryName(name);
		categoryDAO.addCategory(category);
		return "redirect:viewDetailsAdmin";
	}
	
	@RequestMapping("/updateCategory")
	public String updateCategory(@RequestParam int id,@RequestParam String name) {
		category.setCid(id);
		category.setCategoryName(name);
		categoryDAO.updateCategory(category);
		return "redirect:viewDetailsAdmin";
	}
	
	@RequestMapping("/deleteCategory")
	public String deleteCategory(@RequestParam int id) {
		Category category2=categoryDAO.getCategoryById(id);
		categoryDAO.deleteCategory(category2);
		return "redirect:viewDetailsAdmin";
	}
	
	@RequestMapping("/addSupplier")
	public String addSupplier(@RequestParam String name) {
		/*supplier.setSid(0);*/
		supplier.setSupplierName(name);
		supplierDAO.addSupplier(supplier);
		return "redirect:viewDetailsAdmin";
	}
	
	@RequestMapping("/updateSupplier")
	public String updateSupplier(@RequestParam int id,@RequestParam String name) {
		supplier.setSid(id);
		supplier.setSupplierName(name);
		supplierDAO.updateSupplier(supplier);
		return "redirect:viewDetailsAdmin";
	}
	
	@RequestMapping("/deleteSupplier")
	public String deleteSupplier(@RequestParam int id) {
		Supplier supplier2=supplierDAO.getSupplierById(id);
		supplierDAO.deleteSupplier(supplier2);
		return "redirect:viewDetailsAdmin";
	}
}

