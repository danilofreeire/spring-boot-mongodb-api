package com.social.workshop.repository;

import com.social.workshop.domain.Post;
import com.social.workshop.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Post> findByTitle(String text);

    List<Post> findByTitleContaining(String text);
    @Query("{ $and:  [ {date:  {$gte: ?1}} , { date: {$lte: ?2}} " +
            ", {$or: [{ 'title': { $regex: ?0, $options: 'i' } },{ 'body': { $regex: ?0, $options: 'i' } }" +
            ",{ 'comments.text': { $regex: ?0, $options: 'i' } }]}]}")
    List<Post> fullSearch(String text, LocalDate minDate, LocalDate maxDate);

}
