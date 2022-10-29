package com.lica.elasticsearch.controller;

import com.lica.elasticsearch.entity.User;
import com.lica.elasticsearch.userRepository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @PostConstruct
    public void init(){
        User user = new User();
        user.setFirstName("Hüseyin");
        user.setLastName("Afşin");
        user.setAddress("Test");
        user.setBirthDate(Calendar.getInstance().getTime());
        user.setId("U0001");
        userRepository.save(user);
    }


    public ResponseEntity<User> save(@RequestBody User user){

        return ResponseEntity.ok(userRepository.save(user));
    }

    @GetMapping("/{search}")
    public ResponseEntity<List<User>> getUsers(@PathVariable String search){
        List<User> users = userRepository.findByFirstNameLikeOrLastNameLike(search, search);

        return ResponseEntity.ok(users);
    }



}
