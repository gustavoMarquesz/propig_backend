package com.propig_backend.propig.service;

import com.propig_backend.propig.exceptions.CotaNotFound;
import com.propig_backend.propig.models.User;
import com.propig_backend.propig.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User save(User user){
        return userRepository.save(user);
    }

    public User find (Long id) throws CotaNotFound {
        Optional<User> produtoPost = userRepository.findById(id);
        return  produtoPost.orElseThrow(()-> new CotaNotFound());
    }

}
