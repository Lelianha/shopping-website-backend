package com.PollSystemApplication.service;
import com.PollSystemApplication.model.Poll;

public interface PollService {
    Long createPoll(Poll poll);
    Poll getPollById(Long pollId) ;
    void deletePollById(Long pollId);
    void updatePollById(Long pollId, Poll poll);

}
