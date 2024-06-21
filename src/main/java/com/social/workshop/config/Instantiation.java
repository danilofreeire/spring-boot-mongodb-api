package com.social.workshop.config;

import com.social.workshop.domain.Post;
import com.social.workshop.domain.User;
import com.social.workshop.dto.AuthorDTO;
import com.social.workshop.dto.CommentDTO;
import com.social.workshop.repository.PostRepository;
import com.social.workshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    UserRepository user;
    @Autowired
    PostRepository post;


    @Override
    public void run(String... args) throws Exception {
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy").withZone(ZoneId.of("GMT"));


        user.deleteAll();
        post.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        user.saveAll(Arrays.asList(maria,alex,bob));

        Post post1 = new Post(null, LocalDate.parse("21/03/2018",fmt1),
                "Partiu Viagem!", "Vou viajar para São Paulo. Abraços!",new AuthorDTO(maria));

        Post post2 = new Post(null, LocalDate.parse("23/03/2018",fmt1),
                "Bom dia", "Acordei Feliz hoje!",new AuthorDTO(maria));

        CommentDTO c1 = new CommentDTO("Boa viagem mano!",LocalDate.parse("21/03/2018",fmt1),new AuthorDTO(alex));
        CommentDTO c2 = new CommentDTO("Aproveite",LocalDate.parse("22/03/2018",fmt1),new AuthorDTO(bob));
        CommentDTO c3 = new CommentDTO("Tenha um otimo dia",LocalDate.parse("23/03/2018",fmt1),new AuthorDTO(alex));

        post1.getComments().addAll(Arrays.asList(c1,c2));

        post2.getComments().addAll(Arrays.asList(c3));

        post.saveAll(Arrays.asList(post1,post2));

        maria.getPosts().addAll(Arrays.asList(post1,post2));
        user.save(maria);
    }
}
