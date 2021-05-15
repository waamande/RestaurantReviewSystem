package ca.sheridancollege.waamande.controllers;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.waamande.beans.RestaurantReviews;
import ca.sheridancollege.waamande.database.DatabaseAccess;

@Controller
public class ReviewController {
	
	@Autowired
	private DatabaseAccess da;
	
	@GetMapping("/")
	public String getIndex(Model model) {
		model.addAttribute("reviews", da.getAllReviews());
		return "index";
	}
	
	@GetMapping("/reviews/{id}")
	public String getForm(Model model, @PathVariable int id) {
		model.addAttribute("review", da.getReviewById(id));
		return "form";
	}
	
	@PostMapping("/")
	public String postIndex(@ModelAttribute RestaurantReviews review, Model model) {
		LocalDate date = LocalDate.now();
		review.setReviewDate(date);
		
		LocalTime time = LocalTime.now();
		review.setReviewTime(time);
		
		review.setReview(review.getTemp());
		
		da.insertReview(review);
		model.addAttribute("reviews", da.getAllReviews());
		return "index";
	}

}
