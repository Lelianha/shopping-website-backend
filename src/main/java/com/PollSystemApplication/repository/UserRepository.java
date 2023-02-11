package com.PollSystemApplication.repository;

import com.PollSystemApplication.model.User;

import java.util.List;
import java.util.Map;

public interface UserRepository {
    Long createUser(User user);
    Map<String, Object> getUserById(Long userId ) ;
    void deleteUserById(Long userId);
    void updateUserById(Long userId, User user) ;
    void answerUser( User user) throws Exception;
    List<Map<String, Object>>  getCountQuestionOptions( Long questionId);
   Map<String, Object> getAnswersTotal(Long questionId);
    List<Map<String, Object>>getUserAnswers(Long userId);
    Map<String, Object> getAnswersNumber( Long userId);
    List<Map<String, Object>> getAllQuestions();

}
