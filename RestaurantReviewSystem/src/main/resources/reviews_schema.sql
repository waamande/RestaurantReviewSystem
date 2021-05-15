CREATE TABLE RestaurantReviews (
id LONG PRIMARY KEY AUTO_INCREMENT,
restaurantName VARCHAR(255),
restaurantAddress VARCHAR(255),
review VARCHAR(255),
reviewDate DATE,
reviewTime TIME
);