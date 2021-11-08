package com.silcfcr.controllers;


import java.util.List;

//import javax.validation.constraints.class="entity class from-rainbow">Size;


import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.silcfcr.models.Product;
import com.silcfcr.models.User;
import com.silcfcr.services.ProductService;
import com.silcfcr.services.UserService;


@Controller
public class ProductControllers {
	private final UserService userService;
	private final ProductService productService;
 
 public ProductControllers(UserService userService,ProductService productService) {
     this.userService = userService;
     this.productService = productService;
 }
 
 @RequestMapping("/dashboard")
 public String home(HttpSession session, Model model) {
	 if (session.getAttribute("user_id") == null) {
		 return "redirect:/";
	 }
	 else {
		 Long user_id = (Long) session.getAttribute("user_id");
		 User currentUser = userService.findUserById(user_id);
		 model.addAttribute("user", currentUser);
		 
		 List<Product> productList = productService.getAll();
		 model.addAttribute("productList", productList);
		 
	     return "dashboard.jsp";	 
	 }
	 
 }
 
 @RequestMapping(value="/addProduct", method=RequestMethod.GET)
 public String newSong(HttpSession session, Model model) {
	 if (session.getAttribute("user_id") == null) {
		 return "redirect:/";
	 }
	 else {
	 Long user_id = (Long) session.getAttribute("user_id");
	 User currentUser = userService.findUserById(user_id);
	 model.addAttribute("user", currentUser);
	 return "create.jsp";
	 }
}
     
 @RequestMapping(value="/addProduct", method=RequestMethod.POST)
 public String createSong(@RequestParam(value="name") String name,
		 					@RequestParam(value="category") String category,
		 					@RequestParam(value="description") String description,
		 					@RequestParam(value="creatorId") Long creatorId,
		 					HttpSession session, RedirectAttributes redirectAttributes) {
	 if (session.getAttribute("user_id") == null) {
		 return "redirect:/";
	 }
	 else {
		 if (name == "") {
			 redirectAttributes.addFlashAttribute("errorMessage", "Provide the name of the song!");
				return "redirect:/addproduct";
		 }
		 if (category == "") {
			 redirectAttributes.addFlashAttribute("errorMessage", "Provide the genre of the song!");
				return "redirect:/addProduct";
		 }
		 if (description.length() < 5) {
			 redirectAttributes.addFlashAttribute("errorMessage", "lyrics must be at least 5 characters long!");
				return "redirect:/addProduct";
		 }
	 Product product = new Product(name, category, description, creatorId);
	 Product newSong = productService.create(product);
	 return "redirect:/dashboard";
	 
	 }
    }
 
// @RequestMapping("/show/{id}")
//	public String show(@PathVariable("id") Long id, Model model,HttpSession session ) {
//	 if (session.getAttribute("user_id") == null) {
//		 return "redirect:/";
//	 }
//	 else {
//	 	Product song = songService.findById(id);
//		model.addAttribute("song", song);
//		Long creator_id = song.getCreatorId();
//		 User creator = userService.findUserById(creator_id);
//		 System.out.println(creator_id);
//		 System.out.println(creator);
//		 model.addAttribute("creator", creator);
//		
//		
//		return "show.jsp";
//	 }
//	}
// 
// @RequestMapping(value="show/edit/{id}", method=RequestMethod.GET)
// public String editEvent(@PathVariable("id") Long id, Model model, HttpSession session,RedirectAttributes redirectAttributes) {
//	 if (session.getAttribute("user_id") == null) {
//		 return "redirect:/";
//	 }
//	 else {
//		Long user_id = (Long) session.getAttribute("user_id");
//		 User currentUser = userService.findUserById(user_id);
//		 model.addAttribute("user", currentUser);
//		 Product song = songService.findById(id);
//		 model.addAttribute("song", song);
//		 
//	
//	 return "update.jsp";
//	 
//	 }
//	 
// }
//	 
// @RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
// public String editEvent(@RequestParam(value="name") String name,
//		 					@RequestParam(value="genre") String genre,
//		 					@RequestParam(value="lyrics") String lyrics,
//		 					@RequestParam(value="contributor_id") Long contributor_id,
//		 					HttpSession session, RedirectAttributes redirectAttributes, @PathVariable("id") Long id, Model model) {
//  
//	 if (session.getAttribute("user_id") == null) {
//		 return "redirect:/";
//	 }
//	 else {
//		 Product currentSong = songService.findById(id);
//	 
//		 currentSong.setName(name);
//		 currentSong.setGenre(genre);
//		 currentSong.setLyrics(lyrics);
//		 
//		 int contributionsCount = currentSong.getContributions();
//		 contributionsCount += 1;
//		 currentSong.setContributions(contributionsCount);
//		 songService.editSong(currentSong);
//		 return "redirect:/songs";
//	 }
//}
// 
// @RequestMapping("/delete/{id}")
//	public String deleteEvent(@PathVariable("id") Long id,RedirectAttributes redirectAttributes) {
//		Product currentSong = songService.findById(id);
//		songService.deleteSong(currentSong);
//		return "redirect:/songs";
//	}
// 

}