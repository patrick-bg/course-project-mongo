package com.dev.workshopmongo.services;

import com.dev.workshopmongo.domain.Post;
import com.dev.workshopmongo.domain.User;
import com.dev.workshopmongo.dto.UserDTO;
import com.dev.workshopmongo.repository.PostRepository;
import com.dev.workshopmongo.repository.UserRepository;
import com.dev.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
    }

    public List<Post> findByTitle(String text){
        return repo.findbyTitle(text);
    }

    public List<Post> completeSearch(String text, Date minDate, Date maxDate) {
        // Added 24 hours to the query, as the method returns the start of the maxDate.
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return repo.completeSearch(text, minDate, maxDate);
    }

}
