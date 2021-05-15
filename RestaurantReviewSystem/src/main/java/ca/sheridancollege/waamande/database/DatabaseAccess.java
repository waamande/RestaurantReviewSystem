package ca.sheridancollege.waamande.database;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.waamande.beans.RestaurantReviews;

@Repository
public class DatabaseAccess {
	
	@Autowired
	public NamedParameterJdbcTemplate jdbc;
	
	public void insertReview(RestaurantReviews review) {
		String query = "INSERT INTO RestaurantReviews (restaurantName, restaurantAddress, review, reviewDate, reviewTime) VALUES (:restaurantName, :restaurantAddress, :review, :reviewDate, :reviewTime)";
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("restaurantName", review.getRestaurantName());
		map.put("restaurantAddress", review.getRestaurantAddress());
		map.put("review", review.getReview());
		map.put("reviewDate", review.getReviewDate());
		map.put("reviewTime", review.getReviewTime());
		jdbc.update(query, map);
	}
	
	public ArrayList<RestaurantReviews> getAllReviews() {
		String query = "SELECT * FROM RestaurantReviews WHERE review IS NOT NULL";
		ArrayList<RestaurantReviews> reviews = (ArrayList<RestaurantReviews>) jdbc.query(query, new BeanPropertyRowMapper<RestaurantReviews>(RestaurantReviews.class));
		return reviews;
	}
	
	public RestaurantReviews getReviewById(int id) {
		String query = "SELECT * FROM RestaurantReviews WHERE id=:id";
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		ArrayList<RestaurantReviews> reviews = (ArrayList<RestaurantReviews>) jdbc.query(query, map, new BeanPropertyRowMapper<RestaurantReviews>(RestaurantReviews.class));
		if(reviews.size()>0)
		{
			return reviews.get(0);
		}
		return null;
	}

}
