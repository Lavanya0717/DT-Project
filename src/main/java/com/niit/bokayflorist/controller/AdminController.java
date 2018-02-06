package com.niit.bokayflorist.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.Dao.CategoryDAO;
import com.Dao.ProductDAO;
import com.Dao.SupplierDao;
import com.Model.Category;
import com.Model.Product;
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
	
	/*@Autowired
	Product product;*/
	
	@Autowired
	ProductDAO productDAO;
	
	

	@RequestMapping("/home")
	public String Home(){
		return "home";
	}
	
	@RequestMapping("/adminAdding")
	public ModelAndView addDetailsAdmin(@ModelAttribute("product") Product product){
		ModelAndView m= new ModelAndView("adminAdding");
		List<Supplier> supList=supplierDAO.getAllSupplier();
		m.addObject("supList",supList);
		List<Category> catList=categoryDAO.getAllCategory();
		m.addObject("catList",catList);
		return m;
	}
	
	@RequestMapping("/viewDetailsAdmin")
	public ModelAndView viewDetailsAdmin(){
		ModelAndView m=new ModelAndView("viewDetailsAdmin");
		List<Supplier> supList=supplierDAO.getAllSupplier();
		m.addObject("supList",supList);
		List<Category> catList=categoryDAO.getAllCategory();
		m.addObject("catList",catList);
		List<Product> proList=productDAO.getAllProduct();
		m.addObject("proList",proList);
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
		supplier.setSid(0);
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
	
	@RequestMapping(value="/addProduct",method=RequestMethod.POST)
	public ModelAndView addProduct(@ModelAttribute("product") Product product,HttpSession session)
	{	
		ModelAndView m=new ModelAndView("redirect:viewDetailsAdmin");
		MultipartFile image=product.getProImage();
		String imgpath=session.getServletContext().getRealPath("/resources/images/");
		String file_info=imgpath+image.getOriginalFilename()+".jpg";
		File f=new File(file_info);
		if(!image.isEmpty()){
			try{
			byte buff[]=image.getBytes();
			BufferedOutputStream bs=new BufferedOutputStream(new FileOutputStream(f));
			bs.write(buff);
			bs.close();
			product.setImageName(image.getOriginalFilename());
			productDAO.insertOrUpdateProduct(product);
			}
			catch(Exception e){
				System.out.println("Exception");
			}
		}
		return m;
	}
	@RequestMapping("/deleteProduct")
	public ModelAndView deleteProduct(@RequestParam("proId") int proId)
	{	ModelAndView m=new ModelAndView("redirect:viewDetailsAdmin");
		Product product=productDAO.getProduct(proId);
		productDAO.deleteProduct(product);
		return m;
	}
	
	
	@RequestMapping("/updateProduct")
	public ModelAndView updateProduct(@RequestParam("proId") int proId){
		ModelAndView m= new ModelAndView("updateProduct");
		Product product=productDAO.getProduct(proId);
		List<Supplier> supList=supplierDAO.getAllSupplier();
		m.addObject("supList",supList);
		List<Category> catList=categoryDAO.getAllCategory();
		m.addObject("catList",catList);
		m.addObject("product",product);
		return m;
	}
	
}


