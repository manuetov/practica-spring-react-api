package dev.manuetov.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    // plantilla para hacer una consulta dinámica dentro de la BD sin usar el repository
    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody, String imdbId){
        // Crea una review(objeto) en la DB
        Review review = reviewRepository.insert(new Review(reviewBody));

        // actualiza la clase Movie con la consulta del valor de la review asociada a la peli en la BD.
        mongoTemplate.update(Movie.class).matching(Criteria.where(imdbId).is(imdbId))
                .apply(new Update().push("reviewsId").value(review)).first();
        return review;
    }
}
