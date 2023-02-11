package com.PollSystemApplication.service;
import com.PollSystemApplication.model.User;
import com.PollSystemApplication.model.UserRequest;
import com.PollSystemApplication.model.UserResponse;

import java.util.List;
import java.util.Map;

public interface UserService {
    Long createUser(User user);
   Map<String, Object> getUserById(Long userId );
    void deleteUserById(Long userId);
    void updateUserById(Long userId, User user);
     UserResponse answerUser(UserRequest userRequest) throws Exception ;
    List<Map<String, Object>> getCountQuestionOptions( Long questionId);
   Map<String, Object> getAnswersTotal(Long questionId);
   List<Map<String, Object>> getUserAnswers(Long userId);
    Map<String, Object> getAnswersNumber( Long userId);
    List<Map<String, Object>> getAllQuestions();


}
