package com.dev.workshopmongo.services;

import com.dev.workshopmongo.domain.Post;
import com.dev.workshopmongo.domain.User;
import com.dev.workshopmongo.dto.UserDTO;
import com.dev.workshopmongo.repository.PostRepository;
import com.dev.workshopmongo.repository.UserRepository;
import com.dev.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
