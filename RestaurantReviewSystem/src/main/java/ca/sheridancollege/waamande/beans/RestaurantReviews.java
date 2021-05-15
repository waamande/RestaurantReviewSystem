package ca.sheridancollege.waamande.beans;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantReviews implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private long id;
	private String restaurantName;
	private String restaurantAddress;
	private String review;
	private String temp="";
	@DateTimeFormat(pattern="yyyy-MM-dd") private LocalDate reviewDate;
	@DateTimeFormat(pattern="HH:mm") private LocalTime reviewTime;

}
