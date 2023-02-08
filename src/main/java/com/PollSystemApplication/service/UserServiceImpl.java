package com.PollSystemApplication.service;

import com.PollSystemApplication.model.Poll;
import com.PollSystemApplication.model.User;
import com.PollSystemApplication.model.UserRequest;
import com.PollSystemApplication.model.UserResponse;
import com.PollSystemApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public  class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PollService pollService;

    @Override
    public Long createUser(User user) {
        return userRepository.createUser(user);
    }
    @Override
    public Map<String, Object> getUserById(Long userId ) {
        return userRepository.getUserById(userId);
    }
    @Override
    public void deleteUserById(Long userId) {userRepository.deleteUserById(userId);}
    @Override
    public void updateUserById(Long userId, User user){
        userRepository.updateUserById(userId, user);
    }

    @Override
    public UserResponse answerUser(UserRequest userRequest) throws Exception {
        Poll selectedPoll = userRequest.getPoll();
        if (selectedPoll != null) {
            if (selectedPoll.getId() != null) {
                Poll existingPoll = pollService.getPollById(selectedPoll.getId());
                if (existingPoll != null) {
                    userRepository.answerUser(userRequest.toUser());
                } else {
                    throw new Exception("Can't  answer with non existing poll id " + selectedPoll.getId());
                }

            } else {
                throw new Exception("Can't create customerOrder with customer as null");
            }
        }
        return null ;
    }

    @Override
    public List<Map<String, Object>> getCountQuestionOptions( Long questionId) {
        return userRepository.getCountQuestionOptions( questionId);
    }
    @Override
    public Map<String, Object> getAnswersTotal(Long questionId) {
        return userRepository.getAnswersTotal( questionId);
    }


    @Override
    public List<Map<String, Object>> getUserAnswers(Long userId) {
        return userRepository.getUserAnswers(userId);
    }

    @Override
    public  Map<String, Object> getAnswersNumber( Long userId) {
        return userRepository.getAnswersNumber( userId);
    }

    @Override
    public List<Map<String, Object>> getAllQuestions() {
        return userRepository.getAllQuestions();
    }





}
