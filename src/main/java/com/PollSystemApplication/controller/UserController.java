package com.PollSystemApplication.controller;

import com.PollSystemApplication.model.Poll;
import com.PollSystemApplication.model.User;
import com.PollSystemApplication.model.UserRequest;
import com.PollSystemApplication.model.UserResponse;
import com.PollSystemApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;



import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping(value = "/create")
    @CrossOrigin
    public Long createUser(@RequestBody User user) {
        return userService.createUser(user);
    }


    @GetMapping(value = "/get/{userId}")
    public Map<String, Object> getUserById(@PathVariable Long userId ) {
                return userService.getUserById(userId);
    }


    @DeleteMapping("/delete/{userId}")
    private void deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUserById(userId);
    }


    @PutMapping(value = "/update/{userId}")
    public void updateUserById(@PathVariable Long userId,
                               @RequestBody User user)  {

        userService.updateUserById(userId, user);

    }



    @PostMapping(value = "/answerUser")
    public UserResponse answerUser(@RequestBody UserRequest userRequest) throws Exception {
        return userService.answerUser(userRequest);
    }


    @GetMapping(value = "/get/{questionId}/countOptions")
    public List<Map<String, Object>> getCountQuestionOptions( @PathVariable Long questionId)  {
                return userService.getCountQuestionOptions(questionId);
    }



    @GetMapping(value = "/get/{questionId}/answersTotal")
    public   Map<String, Object> getAnswersTotal(@PathVariable  Long questionId) {
                return userService.getAnswersTotal( questionId);
    }

    @GetMapping(value = "/get/{userId}/userAnswers")
    public  List<Map<String, Object>> getUserAnswers( @PathVariable  Long userId)  {
                return userService.getUserAnswers(userId);
    }


    @GetMapping(value = "/get/{userId}/answersNumber")
    public  Map<String, Object> getAnswersNumber( @PathVariable  Long userId)  {
        return userService.getAnswersNumber( userId);
    }


    @GetMapping(value = "/get/allQuestions")
    public List<Map<String, Object>> getAllQuestions() {
                return userService.getAllQuestions();
    }



}